package cn.dawnland.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.dawnland.pojo.Food;
import cn.dawnland.service.SelectService;
import cn.dawnland.service.imp.SelectServiceImp;

/**
 * Servlet implementation class orderDetail
 */
public class orderDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ordernumber = request.getParameter("ordernumber");
		SelectService selectService = new SelectServiceImp();
		List<Food> list = selectService.SelectOrderFoodByOrdernumber(Integer.parseInt(ordernumber));
		request.setAttribute("AllFood", list);
		request.getRequestDispatcher("orderDetail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
