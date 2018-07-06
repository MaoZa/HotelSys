package cn.dawnland.service.imp;

import java.sql.SQLException;
import java.util.Date;

import cn.dawnland.dao.InsertDao;
import cn.dawnland.dao.imp.InsertDaoImp;
import cn.dawnland.service.InsertService;
import cn.dawnland.utils.DataSourceUtils;

public class InsertServiceImp implements InsertService{
	InsertDao insertDao = new InsertDaoImp();
	@Override
	public boolean InsertDetail(int foodid, int foodorderid, int count, String ordernumber) {
		try {
			DataSourceUtils.startTransaction();
			int temp = insertDao.InsertDetail(foodid, foodorderid, count, ordernumber);
			if (temp > 0 ) {
				System.out.println("InsertDetail¥¢¥Ê≥…π¶:"+ foodorderid);
				return true;
			}
		} catch (Exception e) {
			try {
				DataSourceUtils.rollback();
				System.out.println("InsertDetail¥¢¥Ê ß∞‹:"+ foodorderid);
				return false;
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				DataSourceUtils.commitAndRelease();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("InsertDetail¥¢¥Ê ß∞‹:"+ foodorderid);
		return false;
	}

	@Override
	public boolean InsertOrder(String ordernumber, Date ordercreatetime, double totalprice, int orderstatus, int dinnertableid) {
		try {
			DataSourceUtils.startTransaction();
			int temp = insertDao.InsertOrder(ordernumber, ordercreatetime, totalprice, orderstatus, dinnertableid);
			if (temp > 0) {
				System.out.println("InsertOrder¥¢¥Ê≥…π¶:" + dinnertableid);
				return true;
			}
		} catch (Exception e) {
			try {
				DataSourceUtils.rollback();
				e.printStackTrace();
				return false;
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			try {
				DataSourceUtils.commitAndRelease();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("InsertOrder¥¢¥Ê ß∞‹:" + dinnertableid);
		return false;
	}

	@Override
	public int InsertNewBoard(String bName) throws Exception {
		int temp = insertDao.InsertNewBoard(bName);
		if(temp > 0) {
			System.out.println("ÃÌº”≥…π¶");
		}else {
			System.out.println("ÃÌº” ß∞‹");
		}
		return temp;
	}

	@Override
	public int InsertNewCategory(String cName) throws Exception {
		return insertDao.InsertNewCategory(cName);
	}

	@Override
	public int InsertNewFood(int cid, String foodName, int price, int mprice, String fooddesc) throws Exception {
		return insertDao.InsertNewFood(cid, foodName, price, mprice, fooddesc);
	}
	
	
}
