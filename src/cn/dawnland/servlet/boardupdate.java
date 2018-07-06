package cn.dawnland.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.dawnland.dao.DeleteDao;
import cn.dawnland.service.DeleteService;
import cn.dawnland.service.UpdateService;
import cn.dawnland.service.imp.DeleteServiceImp;
import cn.dawnland.service.imp.UpdateServiceImp;
import cn.dawnland.utils.DataSourceUtils;

/**
 * Servlet implementation class boardupdate
 */
public class boardupdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//			DataSourceUtils.startTransaction();
			UpdateService updateService = new UpdateServiceImp();
			String tableid = request.getParameter("tableid");
			String tablestatus = request.getParameter("tablestatus");
			//更新桌子状态
			updateService.UpdataTableStatus(Integer.parseInt(tableid), Integer.parseInt(tablestatus));
			String food_order_number = (String) request.getParameter("food_order_number");
			if (food_order_number != null) {
				try {
					updateService.UpdataOrderStatus(Integer.parseInt(food_order_number));
					//deleteService.DeleteOrder(food_order_number);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			//跳回
			request.getRequestDispatcher("/admin/sys/boardList").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
