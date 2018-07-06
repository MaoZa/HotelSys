package cn.dawnland.service.imp;

import java.sql.SQLException;

import cn.dawnland.dao.DeleteDao;
import cn.dawnland.dao.imp.DeleteDaoImp;
import cn.dawnland.service.DeleteService;

public class DeleteServiceImp implements DeleteService{
	DeleteDao deleteDao = new DeleteDaoImp();
	@Override
	public void DeleteOrder(String ordernumber) throws SQLException {
		deleteDao.DeleteOrder(ordernumber);
	}
	
	@Override
	public void DeleteTable(int id) throws Exception {
		deleteDao.DeleteTable(id);	
	}

	@Override
	public void DeleteCategory(int id) throws Exception {
		deleteDao.DeleteCategory(id);
	}

	@Override
	public void DeleteFood(int id) throws Exception {
		deleteDao.DeleteFood(id);
	}
}
