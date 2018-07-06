package cn.dawnland.pojo;

public class Food {
	private int id;
	private String foodname;
	private double price;
	private double vipprice;
	private String fooddesc;
	private String img;
	private int foodcategoryid;
	private int total = 1;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFoodname() {
		return foodname;
	}
	public void setFoodname(String foodname) {
		this.foodname = foodname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getVipprice() {
		return vipprice;
	}
	public void setVipprice(double vipprice) {
		this.vipprice = vipprice;
	}
	public String getFooddesc() {
		return fooddesc;
	}
	public void setFooddesc(String fooddesc) {
		this.fooddesc = fooddesc;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public int getFoodcategoryid() {
		return foodcategoryid;
	}
	public void setFoodcategoryid(int foodcategoryid) {
		this.foodcategoryid = foodcategoryid;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "Food [id=" + id + ", foodname=" + foodname + ", price=" + price + ", vipprice=" + vipprice
				+ ", fooddesc=" + fooddesc + ", img=" + img + ", foodcategoryid=" + foodcategoryid + "]";
	}
}
