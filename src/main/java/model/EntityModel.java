package model;

public abstract class EntityModel {

	protected EntityModel(String name, String detail) {
		this.name = name;
		this.detail = detail;
	}

	// Test. Sau nay co file se add them field o day.
	protected String name;
	protected String detail;
//	protected String link;

	public String getDetail() {
		return detail;
	}


	protected EntityModel(String name, String detail,String link) {
		this.name = name;
		this.detail = detail;
		this.link = link;
	}
}
