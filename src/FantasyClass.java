import java.util.Date;

public class FantasyClass extends FictionClass {

	/**
	 * Default constructor
	 */
	public FantasyClass() {}

	/**
	 * Custom Constructor
	 * @param bookName
	 * @param genre
	 * @param bookAuthor
	 * @param bookpublisher
	 * @param publishedDate
	 */
	public FantasyClass(String bookName, bookGenre genre, String bookAuthor, String bookpublisher, Date publishedDate) {
		super(bookName, genre, bookAuthor, bookpublisher, publishedDate);
		super.setCategory(bookCategory.FANTASY);
	}
	
}

