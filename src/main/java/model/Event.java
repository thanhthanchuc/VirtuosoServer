package model;

public class Event extends EntityModel {
	public Event(String name, String detail, String time) {
		super(name, detail);
		this.time = time;
	}
	
	private String time;

	public String Time() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
}
