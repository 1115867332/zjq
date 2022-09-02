package school.project.model;

public class Book {
	private String bookIsbn;
	private String bookName;
	private Integer typeId;
	private String bookTypeName;
	private String bookSd;
	private String bookCbs;
	private String bookPd;
	private String bookW;
	private int page;
	private int count;
	private double bookPrice;
	
	
	public Book(String bookIsbn, String bookName, Integer typeId, String bookSd, String bookCbs, String bookPd,
			String bookW, int page, int count, double bookPrice) {
		super();
		this.bookIsbn = bookIsbn;
		this.bookName = bookName;
		this.typeId = typeId;
		this.bookSd = bookSd;
		this.bookCbs = bookCbs;
		this.bookPd = bookPd;
		this.bookW = bookW;
		this.page = page;
		this.count = count;
		this.bookPrice = bookPrice;
	}
	public String getBookIsbn() {
		return bookIsbn;
	}
	public void setBookIsbn(String bookIsbn) {
		this.bookIsbn = bookIsbn;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	public String getBookTypeName() {
		return bookTypeName;
	}
	public void setBookTypeName(String bookTypeName) {
		this.bookTypeName = bookTypeName;
	}
	public String getBookSd() {
		return bookSd;
	}
	public void setBookSd(String bookSd) {
		this.bookSd = bookSd;
	}
	public String getBookCbs() {
		return bookCbs;
	}
	public void setBookCbs(String bookCbs) {
		this.bookCbs = bookCbs;
	}
	public String getBookPd() {
		return bookPd;
	}
	public void setBookPd(String bookPd) {
		this.bookPd = bookPd;
	}
	public String getBookW() {
		return bookW;
	}
	public void setBookW(String bookW) {
		this.bookW = bookW;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}
	
}
