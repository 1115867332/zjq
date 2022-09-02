package school.project.model;

public class DingDan {
	private String Isbn;
	private String name;
	private int count;
	private String gys;
	public DingDan(String isbn, String name, String gys, int count) {
		super();
		this.Isbn = isbn;
		this.name = name;
		this.count = count;
		this.gys = gys;
	}
	public DingDan() {
		super();
	}
	public String getIsbn() {
		return Isbn;
	}
	public void setIsbn(String isbn) {
		Isbn = isbn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getGys() {
		return gys;
	}
	public void setGys(String gys) {
		this.gys = gys;
	}
	
}
