import java.text.SimpleDateFormat;
import java.util.Date;

public class NonfictionClass extends BookClass{
	private bookCategory category;
	
	/**
	 * Default Constructor
	 */
	public NonfictionClass() {
		
	}

	/**
	 * Custom Constructor
	 * @param bookName
	 * @param genre
	 * @param bookAuthor
	 * @param bookpublisher
	 * @param publishedDate
	 */
	public NonfictionClass(String bookName, bookGenre genre, String bookAuthor, String bookpublisher, Date publishedDate) {
		super(bookName, genre, bookAuthor, bookpublisher, publishedDate);
	}
	
	public bookCategory getCategory() {
		return category;
	}

	public void setCategory(bookCategory category) {
		this.category = category;
	} 
	
	/**
	 * Override To String function to print book information
	 */
	@Override
	public String toString() {
		SimpleDateFormat sm = new SimpleDateFormat("MM-dd-yyyy");
		String strDate = sm.format(super.getPublishedDate());
		
		String output = "\nID: " + super.getBookId();
		output += "\nBook Name: "+ super.getBookName(); 
		output += "\nGenre: " + super.getGenre().toString(); 
		output += "\nAuthor: " + super.getBookAuthor();  
		output += "\nPublisher: " + super.getBookpublisher();
		output += "\nPublished Date: " + strDate; 
		output += "\nCategory:" + this.category.toString();
		
		return output;
	}
}
