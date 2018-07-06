package cn.dawnland.service;

import java.sql.SQLException;

public interface DeleteService {
	
	/***
	 * 结账时删除订单信息及订单内菜品
	 * @param foodOrderId
	 * @throws SQLException
	 */
	public void DeleteOrder(String ordernumber) throws SQLException;
	
	/***
	 * 删除桌子
	 * @param id
	 * @throws Exception
	 */
	public void DeleteTable(int id) throws Exception;
	
	/***
	 * 删除菜系
	 * @param id
	 * @throws Exception
	 */
	public void DeleteCategory(int id) throws Exception;
	
	/***
	 * 删除Food(修改Food.status为0)
	 * @param id
	 * @throws Exception
	 */
	public void DeleteFood(int id) throws Exception;
}
