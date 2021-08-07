import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class UserClass extends PersonClass{
	/*
	 * State Variables
	 */
	private int age; 
	private List<BookClass> books;
	
	/**
	 * Default Constructor
	 */
	public UserClass() {
		
	}
	/**
	 * Custom constructor
	 * @param firstName
	 * @param lastName
	 * @param emailAddress
	 * @param personId
	 * @param age
	 * @param books
	 */
	public UserClass(String firstName, String lastName, String emailAddress, int personId, int age, List<BookClass> books) {
		super(firstName, lastName, emailAddress, personId);
		super.setUserType(1);
		this.age = age;
		this.books = new ArrayList<BookClass>();
	}
	
	/*
	 * Getters and Setters
	 */
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public List<BookClass> getBooks() {
		return books;
	}
	public void setBooks(List<BookClass> books) {
		this.books = books;
	} 
	
	/**
	 * Override To String function to print book information
	 */
	@Override
	public String toString() {
		String result = "ID: " + super.getPersonId(); 
		result += "\nName: " + super.getFirstName() + " " + super.getLastName(); 
		result += "\nEmail: " + super.getEmailAddress(); 
		result += "\nAge: " + this.getAge(); 
		result += "\nList of Books borrowed: "; 
		
		for(BookClass book : books) {
			result += books.toString(); 
			result += "\n---------"; 
		}
		
		return result; 
	}
	
	/**
	 * display books
	 */
	public void displayBooks() {
		for(BookClass book : books) {
			System.out.println("\n---------------------------\n");
			System.out.println(book.toString()); 
		}
	}
}
