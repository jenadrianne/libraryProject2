import java.util.Date;

public class ComicClass extends FictionClass {

	/**
	 * Default constructor
	 */
	public ComicClass() {}

	/**
	 * Custom Constructor
	 * @param bookName
	 * @param genre
	 * @param bookAuthor
	 * @param bookpublisher
	 * @param publishedDate
	 */
	public ComicClass(String bookName, bookGenre genre, String bookAuthor, String bookpublisher, Date publishedDate) {
		super(bookName, genre, bookAuthor, bookpublisher, publishedDate);
		super.setCategory(bookCategory.COMIC);
	}
	
}
