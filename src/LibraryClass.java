import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class LibraryClass {
	/**
	 * State Variables
	 */
	private String LibraryName; 
	private List<PersonClass> membersList; 
	private List<BookClass> booksList;
	
	/**
	 * Default Constructor
	 */
	public LibraryClass() {
		membersList = new ArrayList<PersonClass>(); 
		booksList = new ArrayList<BookClass>();
	}
	
	/*
	 * Getters and Setters
	 */
	public String getLibraryName() {
		return LibraryName;
	}
	public void setLibraryName(String libraryName) {
		LibraryName = libraryName;
	}
	public List<PersonClass> getMembersList() {
		return membersList;
	}
	public void setMembersList(List<PersonClass> membersList) {
		this.membersList = membersList;
	}
	public List<BookClass> getBooksList() {
		return booksList;
	}
	public void setBooksList(List<BookClass> booksList) {
		this.booksList = booksList;
	}
	
	/**
	 * Display Book Information 
	 * This will make use of the overridden toString() method of the book Class
	 * @param option
	 */
	public void displayBooks() {
		for(BookClass book:booksList) {
			System.out.println("\n------------------\n"); 
			System.out.println(book.toString()); 
		}
	}
	
	/**
	 * Display Members information. 
	 * This is will make use of the overridden toSting() method of user class
	 * @param option
	 */
	public void displayMembers(int option) {		
		for(PersonClass member : membersList) {
			System.out.println("\n------------------\n"); 
			if(option == 1 && member.getUserType() == 1) {
				System.out.println(member.toString());
			}else if(option == 2 && member.getUserType() == 2) {
				System.out.println(member.toString());
			}else if(option == 0){
				System.out.println(member.toString());
			}
		}
	}
	
	/**
	 * Get Book
	 * @param id
	 * @return
	 */
	public BookClass getBook(int id) {
		BookClass retval = null;
		for(BookClass book:booksList) {
			if(book.getBookId() == id) {
				retval = book; 
				break; 
			} 
		}
		return retval;
	}
	
	/**
	 * Get member
	 * @param id
	 * @return
	 */
	public PersonClass getMember(int id) {
		PersonClass member = null; 
		for(PersonClass person: membersList) {
			if(person.getPersonId() == id) {
				member = person;
			}
		}
		return member;
	}
	/**
	 * Add a Book to the list
	 * @param scan
	 */
	public void AddBooks(Scanner scan) {
		try {
			System.out.println("\nPlease enter the following information"); 
			System.out.println("Book Name:");
			String bookName = scan.nextLine(); 
			scan.nextLine();
			System.out.println("Author: ");
			String author = scan.nextLine(); 
			scan.nextLine(); 
			System.out.println("Publisher: "); 
			String publisher = scan.nextLine(); 
			scan.nextLine(); 
			System.out.println("Published Date (mm/dd/yyyy): "); 
			String date = scan.next();
			Date publishedDate = new Date(date);
			
			System.out.println("Genre (1-Fiction , 2-Nonfiction):");
			int genre = scan.nextInt(); 
			bookGenre bGenre = (genre==1) ? bookGenre.FICTION : bookGenre.NONFICTION;
			
			//create a book item 
			BookClass book =null;
			if(genre==1) {
				System.out.println("Category (1-Comic , 2-Fantasy):");
				int category = scan.nextInt(); 
				
				switch(category) {
					case 1: book = new ComicClass(bookName, bGenre, author, publisher, publishedDate); break; 
					case 2: book = new FantasyClass(bookName, bGenre, author, publisher, publishedDate); break; 
				}
			}else if (genre==2) {
				System.out.println("Category (1-Science , 2-History, 3-Biography):");
				int category = scan.nextInt(); 
				
				switch(category) {
					case 1: book = new ScienceClass(bookName, bGenre, author, publisher, publishedDate); break; 
					case 2: book = new HistoryClass(bookName, bGenre, author, publisher, publishedDate); break; 
					case 3: book = new BiographyClass(bookName, bGenre, author, publisher, publishedDate); break; 
				}
			}
			
			if(book!=null) {
				//create a book item 
				booksList.add(book);
				System.out.println("Successfully added book " + book.toString());
			}
		
		} catch (Exception e) {
			System.out.println("Error in adding new book\n");
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Add a User to the list
	 * @param scan
	 */
	public void AddUser(Scanner scan) {
		try {
			PersonClass person = null;
			
			System.out.println("\nPlease enter the following information"); 
			System.out.println("User Type (1- Member, 2-Staff): ");
			int userType = scan.nextInt();
			System.out.println("First name : "); 
			String firstname = scan.nextLine(); 
			 scan.nextLine();
			System.out.println("Last name: "); 
			String lastname = scan.nextLine(); 
			 scan.nextLine();
			System.out.println("Email Address: ");
			String emailAddress = scan.next(); 
			System.out.println("Person ID : "); 
			int personid = scan.nextInt();
			
			// Add a member 
			if(userType == 1) {
				System.out.println("Age: "); 
				int age = scan.nextInt(); 
				
				person = new UserClass(firstname, lastname, emailAddress, personid, age, null); 
				
			//Add a staff 
			}else {
				System.out.println("Floor Assignment: "); 
				int floor = scan.nextInt(); 
				System.out.println("Section Assignment: "); 
				String section = scan.next();
				person = new StaffClass(firstname, lastname, emailAddress, personid ,floor, section);
			}
			
			// add to the list of members in library class
			membersList.add(person);
			
			System.out.println("Successfully added new member");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error in adding new member\n");
			e.printStackTrace();
		} 
	}
	
	/**
	 * Borrow Book 
	 * @param scan
	 */
	public void borrowBook(Scanner scan) {
		displayBooks(); 
		
		try {
			//if there are no books then there are no books to be borrowed
			if(booksList.size() < 0) {
				return;
			}
			
			System.out.println("\n Enter book ID to borrow: ");
			int bookid = scan.nextInt();
			
			BookClass book = getBook(bookid); 
			if(book!= null) {
				displayMembers(0);  
				
				System.out.println("\n Enter Members ID: ");
				int memberId = scan.nextInt();
				
				PersonClass member = getMember(memberId); 
				if(member!= null && member.getUserType()==1) {
					List<BookClass> borrowedBooks = ((UserClass) member).getBooks();
					
					// check is the members borrowed books. Max is only 5.
					if(borrowedBooks.size() <=5) {
						borrowedBooks.add(book);
						((UserClass) member).setBooks(borrowedBooks);
					}else {
						System.out.println("Cannot Borrow more than 5 books!"); 
					}
				}else {
					System.out.println("Staff cannot borrow books");
				}
			}else {
				System.out.println("Book does not exist");
			}
			
		} catch (Exception e) {
			System.out.println("Incorrect ID!!"); 
		}
		
	}
	
	/**
	 * Return Book 
	 * @param scan
	 */
	public void returnBook(Scanner scan) {
		displayMembers(0); 
		
		try {
			//if there are no members then not books to be returned
			if(membersList.size() < 0) {
				return;
			}
			
			System.out.println("\n Enter Members ID: ");
			int memberId = scan.nextInt();
			
			PersonClass member = getMember(memberId); 
			
			if(member!= null) {
				((UserClass) member).displayBooks();
				
				System.out.println("\nEnter book to return: ");
				int bookid = scan.nextInt(); 
				
				BookClass book = getBook(bookid); 
				if(book!= null) {
					book.returnBook(book);
				}else {
					System.out.println("Book does not exist");
				}
			}else {
				System.out.println("member does not exist");
			}
			
		} catch (Exception e) {
			System.out.println("Incorrect ID!!"); 
		}
		
	}
}
