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

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String Name() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
