package cn.dawnland.dao;

import java.sql.SQLException;
import java.util.Date;

public interface InsertDao {
	
	/***
	 * 插入指定桌子的菜品 一个点菜订单插入1条以上的菜品信息
	 * @return boolean
	 * @throws Exception 
	 * @throws SQLException 
	 */
	public int InsertDetail(int foodid, int foodorderid, int count, String ordernumber) throws Exception;
	
	/***
	 * 插入桌子的点菜信息 (桌子id 点菜唯一编号 点菜时间 总价 付款状态 ) 一个点菜订单直插入一条
	 * @return
	 * @throws Exception 
	 */
	public int InsertOrder(String ordernumber, Date ordercreatetime, double totalprice, int orderstatus, int dinnertableid) throws Exception;
	
	/***
	 * 添加新桌
	 * @param bName
	 * @return
	 * @throws Exception
	 */
	public int InsertNewBoard(String bName) throws Exception;
	
	/***
	 * 添加新菜系
	 * @param cName
	 * @return
	 * @throws Exception
	 */
	public int InsertNewCategory(String cName) throws Exception;
	
	/***
	 * 添加新菜
	 * @param cName
	 * @return
	 * @throws Exception
	 */
	public int InsertNewFood(int cid, String foodName, int price, int mprice, String fooddesc) throws Exception;
}