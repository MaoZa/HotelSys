package cn.dawnland.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.dawnland.service.InsertService;
import cn.dawnland.service.imp.InsertServiceImp;

/**
 * Servlet implementation class saveCuisine
 */
public class saveCuisine extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cName = new String(request.getParameter("cName").getBytes("ISO-8859-1"),"utf-8");
		InsertService insertService = new InsertServiceImp();
		try {
			insertService.InsertNewCategory(cName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("./sys/cuisineList").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
