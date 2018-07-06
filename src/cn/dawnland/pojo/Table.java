package cn.dawnland.pojo;

import java.util.Date;

public class Table {
	private int id;
	private String tablename;
	private int tablestatus;
	private Date presettime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTablename() {
		return tablename;
	}
	public void setTablename(String tablename) {
		this.tablename = tablename;
	}
	public int getTablestatus() {
		return tablestatus;
	}
	public void setTablestatus(int tablestatus) {
		this.tablestatus = tablestatus;
	}
	public Date getPresettime() {
		return presettime;
	}
	public void setPresettime(Date presettime) {
		this.presettime = presettime;
	}
	@Override
	public String toString() {
		return "Table [id=" + id + ", tablename=" + tablename + ", tablestatus=" + tablestatus + ", presettime="
				+ presettime + "]";
	}
	
}
