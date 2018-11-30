package model;

public class Person extends EntityModel {
	private String position;
	
	public Person(String firstName, String lastName, String position, String detail) {
		this.name =  firstName + " " + lastName;
		this.position = position;
		this.detail = detail;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	
}
