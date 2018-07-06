package cn.dawnland.pojo;

public class TableOrder {
	private int id;
	private int foodid;
	private int foodorderid;
	private int count;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFoodid() {
		return foodid;
	}
	public void setFoodid(int foodid) {
		this.foodid = foodid;
	}
	public int getFoodorderid() {
		return foodorderid;
	}
	public void setFoodorderid(int foodorderid) {
		this.foodorderid = foodorderid;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "TableOrderList [id=" + id + ", foodid=" + foodid + ", foodorderid=" + foodorderid + ", count=" + count
				+ "]";
	}
	
}
