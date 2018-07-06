package cn.dawnland.service.imp;

import java.sql.SQLException;

import cn.dawnland.dao.UpdateDao;
import cn.dawnland.dao.imp.UpdateDaoImp;
import cn.dawnland.service.UpdateService;

public class UpdateServiceImp implements UpdateService{
	UpdateDao updateDap = new UpdateDaoImp();
	@Override
	public void UpdataTableStatus(int tableid, int tablestatus) {
		try {
			updateDap.UpdataTableStatus(tableid, tablestatus);
			System.out.println("修改桌号:" + tableid + "状态为:" + tablestatus);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void UpdataOrderStatus(int orderId) throws SQLException {
		updateDap.UpdataOrderStatus(orderId);
		System.out.println(orderId+"订单已结账");
	}
	@Override
	public void UpdateCategroy(String name, int cid) throws SQLException {
		updateDap.UpdateCategroy(name, cid);
	}
	@Override
	public void UpdateFood(int foodid, String foodname, double price, double mprice, String fooddesc,int categoryid) throws SQLException {
		updateDap.UpdateFood(foodid, foodname, price, mprice, fooddesc, categoryid);
	}

}
