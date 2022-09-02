package school.project.model;

public class Publish {
	int id;
	String cbsName;
	String cbsTel;
	String cbsCp;
	String cbsDz;
	public Publish(int id, String cbsName, String cbsTel, String cbsCp, String cbsDz) {
		super();
		this.id = id;
		this.cbsName = cbsName;
		this.cbsTel = cbsTel;
		this.cbsCp = cbsCp;
		this.cbsDz = cbsDz;
	}
	
	public Publish(String cbsName, String cbsTel, String cbsCp, String cbsDz) {
		super();
		this.cbsName = cbsName;
		this.cbsTel = cbsTel;
		this.cbsCp = cbsCp;
		this.cbsDz = cbsDz;
	}

	public Publish() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCbsName() {
		return cbsName;
	}
	public void setCbsName(String cbsName) {
		this.cbsName = cbsName;
	}
	public String getCbsTel() {
		return cbsTel;
	}
	public void setCbsTel(String cbsTel) {
		this.cbsTel = cbsTel;
	}
	public String getCbsCp() {
		return cbsCp;
	}
	public void setCbsCp(String cbsCp) {
		this.cbsCp = cbsCp;
	}
	public String getCbsDz() {
		return cbsDz;
	}
	public void setCbsDz(String cbsDz) {
		this.cbsDz = cbsDz;
	}

	@Override
	public String toString() {
		return cbsName;
	}
	
}
