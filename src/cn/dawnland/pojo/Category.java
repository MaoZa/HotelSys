package cn.dawnland.pojo;

public class Category {
	private int id;
	private String categoryname;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", categoryname=" + categoryname + "]";
	}
	
}
