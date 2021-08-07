import java.util.Date;

public class HistoryClass extends NonfictionClass {

	/**
	 * Default constructor
	 */
	public HistoryClass() {}

	/**
	 * Custom Constructor
	 * @param bookName
	 * @param genre
	 * @param bookAuthor
	 * @param bookpublisher
	 * @param publishedDate
	 */
	public HistoryClass(String bookName, bookGenre genre, String bookAuthor, String bookpublisher, Date publishedDate) {
		super(bookName, genre, bookAuthor, bookpublisher, publishedDate);
		super.setCategory(bookCategory.HISTORY);
	}
	
}
