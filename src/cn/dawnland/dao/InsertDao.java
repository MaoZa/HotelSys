package cn.dawnland.dao;

import java.sql.SQLException;
import java.util.Date;

public interface InsertDao {
	
	/***
	 * ����ָ�����ӵĲ�Ʒ һ����˶�������1�����ϵĲ�Ʒ��Ϣ
	 * @return boolean
	 * @throws Exception 
	 * @throws SQLException 
	 */
	public int InsertDetail(int foodid, int foodorderid, int count, String ordernumber) throws Exception;
	
	/***
	 * �������ӵĵ����Ϣ (����id ���Ψһ��� ���ʱ�� �ܼ� ����״̬ ) һ����˶���ֱ����һ��
	 * @return
	 * @throws Exception 
	 */
	public int InsertOrder(String ordernumber, Date ordercreatetime, double totalprice, int orderstatus, int dinnertableid) throws Exception;
	
	/***
	 * �������
	 * @param bName
	 * @return
	 * @throws Exception
	 */
	public int InsertNewBoard(String bName) throws Exception;
	
	/***
	 * ����²�ϵ
	 * @param cName
	 * @return
	 * @throws Exception
	 */
	public int InsertNewCategory(String cName) throws Exception;
	
	/***
	 * ����²�
	 * @param cName
	 * @return
	 * @throws Exception
	 */
	public int InsertNewFood(int cid, String foodName, int price, int mprice, String fooddesc) throws Exception;
}