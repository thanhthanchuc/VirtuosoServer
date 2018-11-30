package model;

public abstract class EntityModel {
	//Test. Sau nay co file se add them field o day.
	protected String name;
	protected String detail;
	
	public String Detail() {
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
