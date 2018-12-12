package model;

public class Country extends EntityModel {
	public Country(String name, String detail, String link, String timeLink) {
		super(name, detail, link + " _ (" + timeLink + ").");
	}
}
