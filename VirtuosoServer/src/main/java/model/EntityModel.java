package model;

public abstract class EntityModel {
	protected String name;
	protected String detail;
	protected String link;
	protected EntityModel(String name, String detail,String link,String timeLink) {
		this.name = name;
		this.detail = detail;
		this.link = link + " _ ("+ timeLink + ").";
	}

	public String getName() {
		return name;
	}
	
	public String getDetail() {
		return detail;
	}
	
	public String getLink() {
		return link;
	}

}
