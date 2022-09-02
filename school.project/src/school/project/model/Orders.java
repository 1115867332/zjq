package school.project.model;

public class Orders {
	private int id;
	private String sdept;
	private String isbn;
	private String mname;
	private double price;
	private int count;
	private String state;
	private String time;
	public Orders( String isbn, String mname, int count,String sdept) {
		super();
		this.sdept = sdept;
		this.isbn = isbn;
		this.mname = mname;
		this.count = count;
		this.state = "待发货";
	}
	
	public Orders() {
		super();
	}
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSdept() {
		return sdept;
	}
	public void setSdept(String sdept) {
		this.sdept = sdept;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Orders(int id, String isbn, String mname, double price, int count) {
		super();
		this.id = id;
		this.isbn = isbn;
		this.mname = mname;
		this.price = price;
		this.count = count;
		this.state = "待发货";
	}
	//isbn,bookName,Integer.parseInt(bookCount),sdept,time
	public Orders(String isbn, String mname,int count,String sdept,String time) {
		super();
		this.isbn = isbn;
		this.mname = mname;
		this.count = count;
		this.time = time;
		this.sdept = sdept;
		this.state = "待发货";
	}
	//id,isbn,name,price,count
	
}
