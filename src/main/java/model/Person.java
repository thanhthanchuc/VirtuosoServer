package model;

public class Person extends EntityModel {
	private String position;
	
	public Person(String firstName, String lastName, String position, String detail) {
		super(firstName + " " + lastName, detail);
		this.detail = detail;
		this.position = position;
	}

	public String Position() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	
}
