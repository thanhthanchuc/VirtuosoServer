package model;

public class Organization extends EntityModel {
	public String headquarters;
	public Organization(String name, String detail, String hq) {
		super(name, detail);
		this.headquarters = hq;
	}
	
	public String Headquarters() {
		return this.headquarters;
	}
	
	public void setHeadquerters(String hq) {
		this.headquarters = hq;
	}
}
