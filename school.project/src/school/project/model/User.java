package school.project.model;
/*
 * 用户实体
 */
public class User {
	private int id;//编号 没啥用感觉,现在有了
	private String userName;
	private String password;
	private String address;
	private String sex;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public User() {
		super();
	}
	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	public User(String userName, String sex, String address,String password ) {
		super();
		this.userName = userName;
		this.password = password;
		this.address = address;
		this.sex = sex;
	}
	
	
}
