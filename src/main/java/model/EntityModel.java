package model;

public abstract class EntityModel {
<<<<<<< HEAD
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
=======
	protected String name;
	protected String detail;
	protected String link;
	protected EntityModel(String name, String detail,String link) {
		this.name = name;
>>>>>>> Phuc
		this.detail = detail;
		this.link = link;
	}

	public String getName() {
		return name;
	}
	
	public String getDetail() {
		return detail;
	}
<<<<<<< HEAD
=======
	
	public String getLink() {
		return link;
	}

>>>>>>> Phuc
}
