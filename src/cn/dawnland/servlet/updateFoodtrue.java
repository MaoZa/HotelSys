package cn.dawnland.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.dawnland.service.UpdateService;
import cn.dawnland.service.imp.UpdateServiceImp;

/**
 * Servlet implementation class updateFoodtrue
 */
public class updateFoodtrue extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int foodid = Integer.parseInt(request.getParameter("foodid"));
		int cid = Integer.parseInt(request.getParameter("cid"));
		String foodname = new String(request.getParameter("foodName").getBytes("ISO-8859-1"),"utf-8");
		double price = Double.parseDouble(request.getParameter("price"));
		double mprice = Double.parseDouble(request.getParameter("mprice"));
		String fooddesc = new String(request.getParameter("introduce").getBytes("ISO-8859-1"),"utf-8");
		UpdateService updateService = new UpdateServiceImp();
		try {
			updateService.UpdateFood(foodid, foodname, price, mprice, fooddesc, cid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("./sys/foodList").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
