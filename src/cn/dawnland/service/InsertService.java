package cn.dawnland.service;

import java.util.Date;

public interface InsertService {
	
	/***
	 * ����ָ�����ӵĲ�Ʒ һ����˶�������1�����ϵĲ�Ʒ��Ϣ
	 * @return boolean
	 */
	public boolean InsertDetail(int foodid, int foodorderid, int count, String ordernumber);
	
	/***
	 * �������ӵĵ����Ϣ (����id ���Ψһ��� ���ʱ�� �ܼ� ����״̬ ) һ����˶���ֱ����һ��
	 * @return boolean
	 */
	public boolean InsertOrder(String ordernumber, Date ordercreatetime, double totalprice, int orderstatus, int dinnertableid);
	
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
