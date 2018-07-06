package cn.dawnland.service;

import java.util.List;

import cn.dawnland.pojo.Category;
import cn.dawnland.pojo.Food;
import cn.dawnland.pojo.OrderInfo;
import cn.dawnland.pojo.Table;
import cn.dawnland.pojo.TableOrder;

public interface SelectService {
	
	/***
	 * ��ѯ���в�ϵ
	 * @return List:Category
	 */
	public List<Category> SelectCategory();
	
	/***
	 * ��ѯĳ����ϵ��Ϣ
	 * @return List:Category
	 */
	public Category SelectCategory(int id);
	
	/***
	 * ��ѯ���в�Ʒ
	 * @return List:Food
	 */
	public List<Food> SelectFood();
	
	/***
	 * ��ѯ������ϵ���в�Ʒ
	 * @return List:Food
	 */
	public List<Food> SelectCategotyFood(int foodcategoryid);
	
	/***
	 * ��ѯĳ���Ķ�����Ϣ
	 * @return OrderInfo
	 */
	public OrderInfo SelectOrderInfo(int dinnertableid);
	
	/***
	 * ��ѯ���п���
	 * @return List:Table
	 */
	public List<Table> SelectAllTable();
	
	/***
	 * ��ѯĳ�����ӵĶ����б�
	 * @return List:TableOrder
	 */
	public List<TableOrder> SelectTableOrder(int dinnertableid);
	
	/***
	 * ͨ�������Ų�ѯ���������в�Ʒ
	 * @param ordernumber
	 * @return List:Food
	 */
	public List<Food> SelectOrderFoodByOrdernumber(int ordernumber);
	
	/***
	 * ��ѯ���в�Ʒ����
	 * @return int
	 */
	public int SelectFoodTotal();
	
	/***
	 * ��ѯĳ����ϵ��Ʒ����
	 * @param foodcategoryid
	 * @return int
	 */
	public int SelectFootTotal(int foodcategoryid);

	/***
	 * ͨ����Ʒ��������Ʒ
	 * @param foodName
	 * @return
	 */
	public List<Food> SelectFootByName(String foodName);
	
	/***
	 * ͨ��id��ѯ������Ʒ
	 * @param foodid
	 * @return Food
	 */
	public Food SelectFoot(int foodid);
	
	/***
	 * ͨ�����Ų�ѯ������˵����в�Ʒ
	 * @param tableid
	 * @return
	 */
	public List<Food> SelectTableOrderFood(int tableid);
	
	/***
	 * ��ѯ���ж���
	 * @return List:OrderInfo
	 */
	public List<OrderInfo> SelectAllOrder();
	
	/***
	 * ��ѯ����������Ϣ
	 * @return List:Table
	 */
	public List<Table> SelectAllTableNoStatus();
}
