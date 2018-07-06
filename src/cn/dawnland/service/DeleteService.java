package cn.dawnland.service;

import java.sql.SQLException;

public interface DeleteService {
	
	/***
	 * ����ʱɾ��������Ϣ�������ڲ�Ʒ
	 * @param foodOrderId
	 * @throws SQLException
	 */
	public void DeleteOrder(String ordernumber) throws SQLException;
	
	/***
	 * ɾ������
	 * @param id
	 * @throws Exception
	 */
	public void DeleteTable(int id) throws Exception;
	
	/***
	 * ɾ����ϵ
	 * @param id
	 * @throws Exception
	 */
	public void DeleteCategory(int id) throws Exception;
	
	/***
	 * ɾ��Food(�޸�Food.statusΪ0)
	 * @param id
	 * @throws Exception
	 */
	public void DeleteFood(int id) throws Exception;
}
