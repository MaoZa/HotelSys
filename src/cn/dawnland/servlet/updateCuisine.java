package cn.dawnland.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.dawnland.pojo.Category;
import cn.dawnland.service.SelectService;
import cn.dawnland.service.UpdateService;
import cn.dawnland.service.imp.SelectServiceImp;
import cn.dawnland.service.imp.UpdateServiceImp;

/**
 * Servlet implementation class updateCuisine
 */
public class updateCuisine extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String cid = request.getParameter("cid");
		if(name != null && cid != null) {
			UpdateService updateService = new UpdateServiceImp();
			name = new String(name.getBytes("ISO-8859-1"),"utf-8");
			try {
				updateService.UpdateCategroy(name, Integer.parseInt(cid));
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.getRequestDispatcher("/admin/sys/cuisineList").forward(request, response);
		}else {
			SelectService selectService = new SelectServiceImp();
			String id = request.getParameter("id");
			Category category = selectService.SelectCategory(Integer.parseInt(id));
			request.getSession().setAttribute("category", category);
			request.getRequestDispatcher("./sys/updateCuisine.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
