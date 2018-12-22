package model;

public class Event extends EntityModel {
	private String time;

	public Event(String name, String detail, String link, String timeLink, String time) {
		super(name, detail, link, timeLink);
		this.time = time;
	}

	public String getTime() {
		return time;
	}
}
