package cn.dawnland.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.dawnland.service.DeleteService;
import cn.dawnland.service.imp.DeleteServiceImp;

/**
 * Servlet implementation class deleteFood
 */
public class deleteFood extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		DeleteService deleteService = new DeleteServiceImp();
		try {
			deleteService.DeleteFood(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("sys/foodList").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
