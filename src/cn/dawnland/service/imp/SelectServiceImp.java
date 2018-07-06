package cn.dawnland.service.imp;

import java.util.List;

import cn.dawnland.dao.SelectDao;
import cn.dawnland.dao.imp.SelectDaoImp;
import cn.dawnland.pojo.Category;
import cn.dawnland.pojo.Food;
import cn.dawnland.pojo.OrderInfo;
import cn.dawnland.pojo.Table;
import cn.dawnland.pojo.TableOrder;
import cn.dawnland.service.SelectService;

public class SelectServiceImp implements SelectService{
	private SelectDao selectdao = new SelectDaoImp();
	@Override
	public List<Category> SelectCategory() {
		return selectdao.SelectCategory();
	}
	
	@Override
	public Category SelectCategory(int id) {
		return selectdao.SelectCategory(id);
	}
	
	@Override
	public List<Food> SelectFood() {
		return selectdao.SelectFood();
	}

	@Override
	public List<Food> SelectCategotyFood(int foodcategoryid) {
		return selectdao.SelectCategotyFood(foodcategoryid);
	}

	@Override
	public OrderInfo SelectOrderInfo(int dinnertableid) {
		return selectdao.SelectOrderInfo(dinnertableid);
	}

	@Override
	public List<Table> SelectAllTable() {
		return selectdao.SelectAllTable();
	}

	@Override
	public List<TableOrder> SelectTableOrder(int dinnertableid) {
		return selectdao.SelectTableOrder(dinnertableid);
	}

	@Override
	public int SelectFoodTotal() {
		return selectdao.SelectFoodTotal();
	}

	@Override
	public int SelectFootTotal(int foodcategoryid) {
		return selectdao.SelectFootTotal(foodcategoryid);
	}

	@Override
	public List<Food> SelectFootByName(String foodName) {
		return selectdao.SelectFootByName(foodName);
	}

	@Override
	public Food SelectFoot(int foodid) {
		return selectdao.SelectFoot(foodid);
	}

	@Override
	public List<Food> SelectTableOrderFood(int tableid) {
		return selectdao.SelectTableOrderFood(tableid);
	}

	@Override
	public List<OrderInfo> SelectAllOrder() {
		return selectdao.SelectAllOrder();
	}

	@Override
	public List<Table> SelectAllTableNoStatus() {
		return selectdao.SelectAllTableNoStatus();
	}

	@Override
	public List<Food> SelectOrderFoodByOrdernumber(int ordernumber) {
		return selectdao.SelectOrderFoodByOrdernumber(ordernumber);
	}

}
