package model;

public class Location extends EntityModel {
	public Location(String name, String detail, String link, String timeLink) {
		super(name, detail, link + " _ (" + timeLink + ").");
	}
}
