package school.project.model;

public class SdeptUser {
	private String sdept;
	private String password;
	public SdeptUser(String sdept, String password) {
		super();
		this.sdept = sdept;
		this.password = password;
	}
	public SdeptUser() {
		super();
	}
	public String getSdept() {
		return sdept;
	}
	public void setSdept(String sdept) {
		this.sdept = sdept;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
