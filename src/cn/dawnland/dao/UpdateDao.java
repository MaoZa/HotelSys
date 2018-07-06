package cn.dawnland.dao;

import java.sql.SQLException;

public interface UpdateDao {
	
	/***
	 * 更新指定桌子status信息
	 * @param tableid
	 * @param tablestatus
	 */
	public void UpdataTableStatus(int tableid, int tablestatus) throws SQLException ;
	
	/***
	 * 更新制定订单id结账(修改orderstatus=0 为已结账)
	 * @param orderId
	 * @throws SQLException
	 */
	public void UpdataOrderStatus(int orderId) throws SQLException ;
	
	/***
	 * 更新菜系信息
	 * @param name
	 * @param cid
	 * @throws SQLException
	 */
	public void UpdateCategroy(String name, int cid) throws SQLException;
	
	/***
	 * 更新菜信息
	 * @param foodid
	 * @param foodname
	 * @param price
	 * @param mprice
	 * @param fooddesc
	 * @param categoryid
	 * @throws SQLException
	 */
	public void UpdateFood(int foodid, String foodname, double price, double mprice, String fooddesc, int categoryid) throws SQLException;
}
