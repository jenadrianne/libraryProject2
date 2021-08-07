import java.text.SimpleDateFormat;
import java.util.Date;

public class ScienceClass extends NonfictionClass {

	/**
	 * Default constructor
	 */
	public ScienceClass() {}

	/**
	 * Custom Constructor
	 * @param bookName
	 * @param genre
	 * @param bookAuthor
	 * @param bookpublisher
	 * @param publishedDate
	 */
	public ScienceClass(String bookName, bookGenre genre, String bookAuthor, String bookpublisher, Date publishedDate) {
		super(bookName, genre, bookAuthor, bookpublisher, publishedDate);
		super.setCategory(bookCategory.SCIENCE);
	}
}
