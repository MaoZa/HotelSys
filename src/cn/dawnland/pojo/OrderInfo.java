package cn.dawnland.pojo;

import java.util.Date;

public class OrderInfo {
	private int id;
	private String ordernumber;
	private Date ordercreatetime;
	private double totalprice;
	private int orderstatus;
	private int dinnertableid;
	private String tablename;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrdernumber() {
		return ordernumber;
	}
	public void setOrdernumber(String ordernumber) {
		this.ordernumber = ordernumber;
	}
	public Date getOrdercreatetime() {
		return ordercreatetime;
	}
	public void setOrdercreatetime(Date ordercreatetime) {
		this.ordercreatetime = ordercreatetime;
	}
	public double getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}
	public int getOrderstatus() {
		return orderstatus;
	}
	public void setOrderstatus(int orderstatus) {
		this.orderstatus = orderstatus;
	}
	public int getDinnertableid() {
		return dinnertableid;
	}
	public void setDinnertableid(int dinnertableid) {
		this.dinnertableid = dinnertableid;
	}
	
	public String getTablename() {
		return tablename;
	}
	public void setTablename(String tablename) {
		this.tablename = tablename;
	}
	@Override
	public String toString() {
		return "OrderInfo [id=" + id + ", ordernumber=" + ordernumber + ", ordercreatetime=" + ordercreatetime
				+ ", totalprice=" + totalprice + ", orderstatus=" + orderstatus + ", dinnertableid=" + dinnertableid
				+ "]";
	}
}
