package model;

public class Person extends EntityModel {
	private String position;
	private String link;
	public Person(String firstName, String lastName, String position, String detail, String link, String timeLink) {
		super(firstName + " " + lastName, detail);
		this.detail = detail;
		this.position = position;
		this.link = link + " _ ( "+ timeLink + " ).";
	}

	public String Position() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}

	public String getLink() {
		return link;
	}
}
