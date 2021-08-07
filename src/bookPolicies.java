
public interface bookPolicies {
	public boolean checkBeyondDueDate(BookClass book);
	public int bookFinePerDay(BookClass book);
	public BookClass borrowBook(BookClass book); 
	public BookClass returnBook(BookClass book);
	
}
