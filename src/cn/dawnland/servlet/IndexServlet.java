package cn.dawnland.servlet;

import java.io.IOException;
import java.net.HttpCookie;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.dawnland.pojo.Table;
import cn.dawnland.service.SelectService;
import cn.dawnland.service.imp.SelectServiceImp;

/**
 * Servlet implementation class IndexServlet
 */
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SelectService selectService = new SelectServiceImp();
		List<Table> list = selectService.SelectAllTable();
		request.setAttribute("AllTable", list);
		Cookie cookie = new Cookie("JSESSIONID", request.getSession().getId());
		cookie.setMaxAge(30*60);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		request.getSession().setMaxInactiveInterval(10*60);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
