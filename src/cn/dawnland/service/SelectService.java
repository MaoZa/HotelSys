package cn.dawnland.service;

import java.util.List;

import cn.dawnland.pojo.Category;
import cn.dawnland.pojo.Food;
import cn.dawnland.pojo.OrderInfo;
import cn.dawnland.pojo.Table;
import cn.dawnland.pojo.TableOrder;

public interface SelectService {
	
	/***
	 * 查询所有菜系
	 * @return List:Category
	 */
	public List<Category> SelectCategory();
	
	/***
	 * 查询某个菜系信息
	 * @return List:Category
	 */
	public Category SelectCategory(int id);
	
	/***
	 * 查询所有菜品
	 * @return List:Food
	 */
	public List<Food> SelectFood();
	
	/***
	 * 查询单个菜系所有菜品
	 * @return List:Food
	 */
	public List<Food> SelectCategotyFood(int foodcategoryid);
	
	/***
	 * 查询某桌的订单信息
	 * @return OrderInfo
	 */
	public OrderInfo SelectOrderInfo(int dinnertableid);
	
	/***
	 * 查询所有空桌
	 * @return List:Table
	 */
	public List<Table> SelectAllTable();
	
	/***
	 * 查询某个桌子的订单列表
	 * @return List:TableOrder
	 */
	public List<TableOrder> SelectTableOrder(int dinnertableid);
	
	/***
	 * 通过订单号查询订单内所有菜品
	 * @param ordernumber
	 * @return List:Food
	 */
	public List<Food> SelectOrderFoodByOrdernumber(int ordernumber);
	
	/***
	 * 查询所有菜品总数
	 * @return int
	 */
	public int SelectFoodTotal();
	
	/***
	 * 查询某个菜系菜品总数
	 * @param foodcategoryid
	 * @return int
	 */
	public int SelectFootTotal(int foodcategoryid);

	/***
	 * 通过菜品名搜索菜品
	 * @param foodName
	 * @return
	 */
	public List<Food> SelectFootByName(String foodName);
	
	/***
	 * 通过id查询单个菜品
	 * @param foodid
	 * @return Food
	 */
	public Food SelectFoot(int foodid);
	
	/***
	 * 通过桌号查询该桌点菜单所有菜品
	 * @param tableid
	 * @return
	 */
	public List<Food> SelectTableOrderFood(int tableid);
	
	/***
	 * 查询所有订单
	 * @return List:OrderInfo
	 */
	public List<OrderInfo> SelectAllOrder();
	
	/***
	 * 查询所有桌子信息
	 * @return List:Table
	 */
	public List<Table> SelectAllTableNoStatus();
}
