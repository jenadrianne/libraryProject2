import java.util.Date;

public class BiographyClass extends NonfictionClass {

	/**
	 * Default constructor
	 */
	public BiographyClass() {}

	/**
	 * Custom Constructor
	 * @param bookName
	 * @param genre
	 * @param bookAuthor
	 * @param bookpublisher
	 * @param publishedDate
	 */
	public BiographyClass(String bookName, bookGenre genre, String bookAuthor, String bookpublisher, Date publishedDate) {
		super(bookName, genre, bookAuthor, bookpublisher, publishedDate);
		super.setCategory(bookCategory.BIOGRAPHY);
	}
	
}
