package cn.dawnland.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.dawnland.dao.DeleteDao;
import cn.dawnland.dao.imp.DeleteDaoImp;

/**
 * Servlet implementation class deleteCuisine
 */
public class deleteCuisine extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		DeleteDao deleteDao = new DeleteDaoImp();
		try {
			deleteDao.DeleteCategory(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/admin/sys/cuisineList").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
