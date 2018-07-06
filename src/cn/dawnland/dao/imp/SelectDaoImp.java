package cn.dawnland.dao.imp;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.dawnland.dao.SelectDao;
import cn.dawnland.pojo.Category;
import cn.dawnland.pojo.Food;
import cn.dawnland.pojo.FoodTotal;
import cn.dawnland.pojo.OrderInfo;
import cn.dawnland.pojo.Table;
import cn.dawnland.pojo.TableOrder;
import cn.dawnland.utils.DataSourceUtils;

public class SelectDaoImp implements SelectDao{
	private QueryRunner queryrunner = new QueryRunner(DataSourceUtils.getDataSource());
	@Override
	public List<Category> SelectCategory() {
		String sql = "SELECT * FROM food_category";
		try {
			return queryrunner.query(sql, new BeanListHandler<Category>(Category.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public Category SelectCategory(int id) {
		String sql = "SELECT * FROM food_category WHERE id=?";
		try {
			return queryrunner.query(sql, new BeanHandler<Category>(Category.class), id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<Food> SelectFood() {
		String sql = "SELECT * FROM food WHERE status=1";
		try {
			return queryrunner.query(sql, new BeanListHandler<Food>(Food.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Food> SelectCategotyFood(int foodcategoryid) {
		String sql = "SELECT * FROM food WHERE foodcategoryid=? AND status=1";
		try {
			return queryrunner.query(sql, new BeanListHandler<Food>(Food.class), foodcategoryid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public OrderInfo SelectOrderInfo(int dinnertableid) {
		String sql = "SELECT * FROM food_order WHERE dinnertableid=?";
		try {
			return queryrunner.query(sql, new BeanHandler<OrderInfo>(OrderInfo.class), dinnertableid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Table> SelectAllTable() {
		String sql = "SELECT * FROM dinner_table WHERE tablestatus=0";
		try {
			return queryrunner.query(sql, new BeanListHandler<Table>(Table.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<TableOrder> SelectTableOrder(int foodorderid) {
		String sql = "SELECT * FROM order_detail WHERE foodorderid=?";
		try {
			return queryrunner.query(sql, new BeanListHandler<TableOrder>(TableOrder.class), foodorderid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int SelectFoodTotal() {
		String sql = "SELECT count(id) AS count FROM food WHERE status=1";
		FoodTotal foodTotal = null;
		try {
			foodTotal = queryrunner.query(sql, new BeanHandler<FoodTotal>(FoodTotal.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return foodTotal.getCount();
	}

	@Override
	public int SelectFootTotal(int foodcategoryid) {
		String sql = "SELECT count(id) AS count FROM food WHERE foodcategoryid=?";
		FoodTotal foodTotal = null;
		try {
			foodTotal = queryrunner.query(sql, new BeanHandler<FoodTotal>(FoodTotal.class), foodcategoryid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return foodTotal.getCount();
	}

	@Override
	public List<Food> SelectFootByName(String foodName) {
		String sql = "SELECT * FROM food WHERE foodname LIKE ?";
		foodName = "%" + foodName + "%";
		try {
			return queryrunner.query(sql, new BeanListHandler<Food>(Food.class) ,foodName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Food SelectFoot(int foodid) {
		String sql = "SELECT * FROM food WHERE id=?";
		try {
			return queryrunner.query(sql, new BeanHandler<Food>(Food.class) ,foodid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Food> SelectTableOrderFood(int tableid) {
		String sql = "SELECT fd.id, fd.foodname, fd.price, fd.vipprice, fd.fooddesc, fd.img, fd.foodcategoryid FROM food fd RIGHT OUTER JOIN (SELECT foodid FROM order_detail od RIGHT OUTER JOIN (SELECT id FROM food_order WHERE dinnertableid=?) foodorderid ON foodorderid.id=od.foodorderid) orderid ON orderid.foodid=fd.id";
		try {
			return queryrunner.query(sql, new BeanListHandler<Food>(Food.class), tableid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<OrderInfo> SelectAllOrder() {
		String sql = "SELECT fd.id,fd.ordernumber,fd.ordercreatetime,fd.totalprice,fd.orderstatus,fd.dinnertableid,dt.tablename FROM food_order fd LEFT JOIN dinner_table dt ON dt.id=fd.dinnertableid";
		try {
			return queryrunner.query(sql, new BeanListHandler<OrderInfo>(OrderInfo.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Table> SelectAllTableNoStatus() {
		String sql = "SELECT * FROM dinner_table";
		try {
			return queryrunner.query(sql, new BeanListHandler<Table>(Table.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Food> SelectOrderFoodByOrdernumber(int ordernumber) {
//		String sql = "SELECT fd.id,fd.foodname,fd.price,fd.vipprice,fd.fooddesc,fd.img,fd.foodcategoryid,temp.total FROM food fd RIGHT JOIN (SELECT foodid,od.count as total FROM order_detail od LEFT JOIN (SELECT id FROM food_order WHERE ordernumber=?) food_order_id ON food_order_id.id=od.foodorderid) temp ON temp.foodid=fd.id";
		String sql = "SELECT food.id,food.foodname,food.price,food.vipprice,food.fooddesc,food.img,food.foodcategoryid,temp.total FROM food INNER JOIN (SELECT foodid,count AS total,foodorderid FROM order_detail INNER JOIN (SELECT id FROM food_order WHERE ordernumber=?) temp ON temp.id=foodorderid) temp ON food.id=temp.foodid";
		try {
			return queryrunner.query(sql, new BeanListHandler<Food>(Food.class), ordernumber);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
