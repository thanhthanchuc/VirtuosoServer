package model;

public class Person extends EntityModel {
	private String position;
<<<<<<< HEAD
	private String link;
=======
>>>>>>> Phuc
	public Person(String firstName, String lastName, String position, String detail, String link, String timeLink) {
		super(firstName + " " + lastName, detail , link + " _ ("+ timeLink + ").");
		this.position = position; 
	}

	public String getPosition() {
		return position;
	}
<<<<<<< HEAD
	public void setPosition(String position) {
		this.position = position;
	}

	public String getLink() {
		return link;
	}
=======
>>>>>>> Phuc
}
