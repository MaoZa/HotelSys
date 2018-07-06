package cn.dawnland.dao;

import java.sql.SQLException;

public interface UpdateDao {
	
	/***
	 * ����ָ������status��Ϣ
	 * @param tableid
	 * @param tablestatus
	 */
	public void UpdataTableStatus(int tableid, int tablestatus) throws SQLException ;
	
	/***
	 * �����ƶ�����id����(�޸�orderstatus=0 Ϊ�ѽ���)
	 * @param orderId
	 * @throws SQLException
	 */
	public void UpdataOrderStatus(int orderId) throws SQLException ;
	
	/***
	 * ���²�ϵ��Ϣ
	 * @param name
	 * @param cid
	 * @throws SQLException
	 */
	public void UpdateCategroy(String name, int cid) throws SQLException;
	
	/***
	 * ���²���Ϣ
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
