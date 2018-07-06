package cn.dawnland.dao.imp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import javax.print.DocFlavor.STRING;
import javax.xml.transform.Templates;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.mysql.fabric.xmlrpc.base.Data;

import cn.dawnland.dao.InsertDao;
import cn.dawnland.pojo.OrderInfo;
import cn.dawnland.service.SelectService;
import cn.dawnland.utils.DataSourceUtils;

public class InsertDaoImp implements InsertDao{
	
	@Override
	public int InsertDetail(int foodid, int foodorderid, int count, String ordernumber) throws Exception{
		Connection conn = DataSourceUtils.getConnection();
		QueryRunner queryRunner = new QueryRunner();
		OrderInfo orderInfo = queryRunner.query(conn, "SELECT * FROM food_order WHERE ordernumber=?", new BeanHandler<OrderInfo>(OrderInfo.class), ordernumber);
		String sql = "INSERT INTO order_detail(foodid, foodorderid, count) VALUES(?,?,?)";
		Object[] post = {foodid, orderInfo.getId(), count};
		return queryRunner.update(conn, sql, post);
	}

	@Override
	public int InsertOrder(String ordernumber, Date ordercreatetime, double totalprice, int orderstatus, int dinnertableid) throws Exception{
		QueryRunner queryRunner = new QueryRunner();
		String sql = "INSERT INTO food_order(ordernumber, ordercreatetime, totalprice, orderstatus, dinnertableid) VALUES(?,?,?,?,?)";
		String sql1 = "UPDATE dinner_table SET tablestatus=? WHERE id=?";
		Connection conn = DataSourceUtils.getConnection();
		Object[] post = {ordernumber, ordercreatetime, totalprice, orderstatus,dinnertableid};
		Object[] post1 = {1, dinnertableid};
		queryRunner.update(conn, sql, post);
		return queryRunner.update(conn, sql1, post1);
	}

	@Override
	public int InsertNewBoard(String bName) throws Exception {
		QueryRunner queryRunner = new QueryRunner();
		Connection conn = DataSourceUtils.getConnection();
		String sql = "INSERT INTO dinner_table(tablename) VALUES(?)";
		return queryRunner.update(conn, sql, bName);
	}

	@Override
	public int InsertNewCategory(String cName) throws Exception {
		QueryRunner queryRunner = new QueryRunner();
		Connection conn = DataSourceUtils.getConnection();
		String sql = "INSERT INTO food_category(categoryname) VALUES(?)";
		return queryRunner.update(conn, sql, cName);
	}

	@Override
	public int InsertNewFood(int cid, String foodName, int price, int mprice, String fooddesc) throws Exception {
		QueryRunner queryRunner = new QueryRunner();
		Connection conn = DataSourceUtils.getConnection();
		String sql = "INSERT INTO food(foodname, price, vipprice, fooddesc, foodcategoryid) VALUES(?,?,?,?,?)";
		Object[] post = {foodName, price, mprice ,fooddesc, cid};
		return queryRunner.update(conn, sql, post);
	}
}
