package cn.dawnland.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.dawnland.service.InsertService;
import cn.dawnland.service.imp.InsertServiceImp;

/**
 * Servlet implementation class SaveFoodtrue
 */
public class SaveFoodtrue extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cid = Integer.parseInt(request.getParameter("cid"));
		String foodName = request.getParameter("foodName");
		int price = Integer.parseInt(request.getParameter("price"));
		int mprice = Integer.parseInt(request.getParameter("mprice"));
		String fooddesc = request.getParameter("introduce");
		InsertService insertService = new InsertServiceImp();
		try {
			insertService.InsertNewFood(cid, foodName, price, mprice, fooddesc);
		} catch (Exception e) {
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
