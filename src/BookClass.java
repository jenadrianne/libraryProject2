import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

enum bookGenre {
	FICTION,
	NONFICTION
}

enum bookCategory {
	//non-fiction category
	SCIENCE,
	HISTORY, 
	BIOGRAPHY, 
	//fiction category
	COMIC, 
	FANTASY
}

public class BookClass implements bookPolicies{
	/*
	 * State Varibles
	 */
	private int BookId; 
	private String BookName; 
	private bookGenre genre; 
	private Date dateBorrowed; 
	private Date returnDate; 
	private int price;
	private String bookAuthor; 
	private String bookpublisher; 
	private Date publishedDate;
	private boolean isborrowed; 
	
	/**
	 * Default Constructor
	 */
	public BookClass() {}
	/**
	 * Custom Constructor
	 * @param bookName
	 * @param genre
	 * @param bookAuthor
	 * @param bookpublisher
	 * @param publishedDate
	 */
	public BookClass(String bookName, bookGenre genre, String bookAuthor, String bookpublisher, Date publishedDate) {
		this.BookName = bookName;
		this.genre = genre;
		this.bookAuthor = bookAuthor;
		this.bookpublisher = bookpublisher;
		this.publishedDate = publishedDate;
		Random random = new Random();
        this.BookId = Math.abs(random.nextInt());
	}
	
	/*
	 * Getters and Setters 
	 */
	
	public String getBookName() {
		return BookName;
	}
	public void setBookName(String bookName) {
		BookName = bookName;
	}
	public Date getDateBorrowed() {
		return dateBorrowed;
	}
	public void setDateBorrowed(Date dateBorrowed) {
		this.dateBorrowed = dateBorrowed;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public bookGenre getGenre() {
		return genre;
	}
	public void setGenre(bookGenre genre) {
		this.genre = genre;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public String getBookpublisher() {
		return bookpublisher;
	}
	public void setBookpublisher(String bookpublisher) {
		this.bookpublisher = bookpublisher;
	}
	public Date getPublishedDate() {
		return publishedDate;
	}
	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}
	public boolean isIsborrowed() {
		return isborrowed;
	}
	public void setIsborrowed(boolean isborrowed) {
		this.isborrowed = isborrowed;
	}	
	public int getBookId() {
		return BookId;
	}
	public void setBookId(int bookId) {
		BookId = bookId;
	}

	/**
	 * check if the book is beyond its due date
	 */
	@Override
	public boolean checkBeyondDueDate(BookClass book) {
		boolean retval = false; 
		Calendar c = Calendar.getInstance(); 
		Date datenow = c.getTime();
		
		// check if the date is beyond the return date
		if(this.returnDate.after(datenow)){
			retval=true;
		}
		return retval;
	}
	
	/**
	 * Compute the fine of the book
	 */
	@Override
	@SuppressWarnings("deprecation")
	public int bookFinePerDay(BookClass book) {
		int retval = 0;
		
		//if the date is beyond the return date add $1 per day
		if(checkBeyondDueDate(book) && this.isborrowed) {
			Calendar c = Calendar.getInstance(); 
			Date datenow = c.getTime();
			int days = this.returnDate.getDay() - datenow.getDay();
			
			//add $1 per day
			retval = days * 1; 
		}
		
		return retval; 
	}
	
	
	/**
	 * Borrow a Book function
	 */
	@Override
	public BookClass borrowBook(BookClass book) {
		
		//Check if the book is not borrowed by any member
		if(!book.isIsborrowed()) {
			Calendar c = Calendar.getInstance(); 
			Date datenow = c.getTime();
			
			book.setIsborrowed(true);
			book.setDateBorrowed(datenow);
			
			// every book should be returned within 14 days
			c.add(Calendar.DAY_OF_MONTH, 14); 
			book.setReturnDate(c.getTime());
		}
		
		return book; 
	}
	
	/**
	 * Return a book 
	 */
	@Override
	public BookClass returnBook(BookClass book) {
		//Check if the book is borrowed
		if(book.isIsborrowed()) {
			
			// set the price or the fine
			book.setPrice(bookFinePerDay(book));
			
			if(book.getPrice() > 0) {
				System.out.println("Please settle the payment for $" + book.getPrice() + " with the staff. Thank you!"); 
			}
			book.setIsborrowed(false);
			
		}
		return book;
	}
	
	/**
	 * Override To String function to print book information
	 */
	@Override
	public String toString() {
		SimpleDateFormat sm = new SimpleDateFormat("MM-dd-yyyy");
		String strDate = sm.format(this.publishedDate);
		
		String output = "\nID: " + this.BookId;
		output += "\nBook Name: "+ this.BookName; 
		output += "\nGenre: " + this.genre.toString(); 
		output += "\nAuthor: " + this.bookAuthor;  
		output += "\nPublisher: " + this.bookpublisher;
		output += "\nPublished Date: " + strDate; 
		
		return output;
	}
}
