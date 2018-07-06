package cn.dawnland.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.dawnland.dao.SelectDao;
import cn.dawnland.dao.imp.SelectDaoImp;
import cn.dawnland.pojo.Food;

/**
 * Servlet implementation class CaiXianQin
 */
public class CaiXiangQin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SelectDao selectDao = new SelectDaoImp();
		int foodid = new Integer(request.getParameter("foodid"));
		Food food = selectDao.SelectFoot(foodid);
		request.setAttribute("Food", food);
		request.getRequestDispatcher("./detail/caixiangqin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
