package cn.dawnland.dao.imp;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import cn.dawnland.dao.DeleteDao;
import cn.dawnland.utils.DataSourceUtils;

public class DeleteDaoImp implements DeleteDao{
	QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
	@Override
	public void DeleteOrder(String ordernumber) throws SQLException {
		String sql = "DELETE FROM order_detail WHERE order_detail.foodorderid=(SELECT id FROM food_order WHERE ordernumber=?)";
		String sql1 = "DELETE FROM food_order WHERE ordernumber=?";
		queryRunner.update(sql, ordernumber);
		queryRunner.update(sql1, ordernumber);
	}
	
	@Override
	public void DeleteTable(int id) throws Exception {
		String sql ="DELETE FROM dinner_table WHERE id=?";
		queryRunner.update(sql, id);
	}

	@Override
	public void DeleteCategory(int id) throws Exception {
		String sql = "DELETE FROM food_category WHERE id=?";
		queryRunner.update(sql, id);
		
	}

	@Override
	public void DeleteFood(int id) throws Exception {
		String sql = "UPDATE food SET status=0 WHERE id=?";
		queryRunner.update(sql, id);
	}

}
