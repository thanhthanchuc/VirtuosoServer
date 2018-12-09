package model;

public class Person extends EntityModel {
	private String position;
	public Person(String firstName, String lastName, String position, String detail, String link, String timeLink) {
		super(firstName + " " + lastName, detail , link + " _ ("+ timeLink + ").");
		this.position = position; 
	}

	public String getPosition() {
		return position;
	}
}
