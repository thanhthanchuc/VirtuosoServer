package model;

public class Organization extends EntityModel {
	public String headquarters;

	public Organization(String name, String hq, String detail, String link, String timeLink) {
		super(name, detail, link, timeLink);
		this.headquarters = hq;
	}

	public String getHeadquarters() {
		return this.headquarters;
	}
}
