package cn.dawnland.dao.imp;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import cn.dawnland.dao.UpdateDao;
import cn.dawnland.utils.DataSourceUtils;

public class UpdateDaoImp implements UpdateDao{
	QueryRunner queryRunner = new QueryRunner();
	@Override
	public void UpdataTableStatus(int tableid, int tablestatus) throws SQLException {
		Connection conn = DataSourceUtils.getConnection();
		String sql;
		if (tablestatus == 1) {
			sql = "UPDATE dinner_table SET tablestatus=1,presettime=NOW() WHERE id=?";
		}else {
			sql = "UPDATE dinner_table SET tablestatus=0,presettime=null WHERE id=?";
		}
		Object[] post = {tableid};
		queryRunner.update(conn, sql, post);
	}
	
	@Override
	public void UpdataOrderStatus(int orderId) throws SQLException {
		Connection conn = DataSourceUtils.getConnection();
		String sql = "UPDATE food_order SET orderstatus=0 WHERE ordernumber=?";
		queryRunner.update(conn, sql, orderId);
	}

	@Override
	public void UpdateCategroy(String name, int cid) throws SQLException {
		Connection conn = DataSourceUtils.getConnection();
		String sql = "UPDATE food_category SET categoryname=? WHERE id=?";
		Object[] post = {name, cid};
		queryRunner.update(conn, sql, post);
	}

	@Override
	public void UpdateFood(int foodid, String foodname, double price, double mprice, String fooddesc,int categoryid) throws SQLException {
		Connection conn = DataSourceUtils.getConnection();
		System.out.println("foodid="+foodid);
		String sql = "UPDATE food SET foodname=?,price=?,vipprice=?,fooddesc=?,foodcategoryid=? WHERE id=?";
		Object[] post = {foodname, price, mprice, fooddesc, categoryid, foodid};
		queryRunner.update(conn, sql, post);
	}
	
}
