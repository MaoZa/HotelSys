package cn.dawnland.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.dawnland.pojo.Food;

/**
 * Servlet implementation class sorder
 */
public class sorder extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int gid = Integer.parseInt(request.getParameter("gid"));
		int total = Integer.parseInt(request.getParameter("total"));
		List<Food> list = (List<Food>) request.getSession().getAttribute("CardList");
		for (Food food : list) {
			if (food.getId() == gid) {
				food.setTotal(total);
			}
		}
		request.getRequestDispatcher("/clientCart?tableid=" + request.getParameter("tableid")).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
