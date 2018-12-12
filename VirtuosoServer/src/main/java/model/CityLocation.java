package model;

public class CityLocation extends EntityModel {
	public CityLocation(String name, String detail, String link, String timeLink) {
		super(name, detail, link + " _ (" + timeLink + ").");
	}
}
