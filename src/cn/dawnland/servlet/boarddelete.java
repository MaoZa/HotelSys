package cn.dawnland.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.dawnland.service.DeleteService;
import cn.dawnland.service.imp.DeleteServiceImp;

/**
 * Servlet implementation class boarddelete
 */
public class boarddelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DeleteService deleteService = new DeleteServiceImp();
		try {
			//É¾³ý×À×Ó
			deleteService.DeleteTable(Integer.parseInt(request.getParameter("tableid")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Ìø»Ø
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
