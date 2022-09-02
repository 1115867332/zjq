package school.project.model;

public class GongYingShang {
	private String people;
	private String dz;
	private String tel;
	private String gys_name;
	public GongYingShang(String people, String dz, String tel, String gys_name) {
		super();
		this.people = people;
		this.dz = dz;
		this.tel = tel;
		this.gys_name = gys_name;
	}
	public GongYingShang() {
		super();
	}
	public String getPeople() {
		return people;
	}
	public void setPeople(String people) {
		this.people = people;
	}
	public String getDz() {
		return dz;
	}
	public void setDz(String dz) {
		this.dz = dz;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getGys_name() {
		return gys_name;
	}
	public void setGys_name(String gys_name) {
		this.gys_name = gys_name;
	}
	@Override
	public String toString() {
		return gys_name;
	}
	
}
