package cn.dawnland.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.dawnland.pojo.Table;
import cn.dawnland.service.SelectService;
import cn.dawnland.service.imp.SelectServiceImp;

/**
 * Servlet implementation class boardList
 */
public class boardList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SelectService selectService = new SelectServiceImp();
		//查询所有status为0的桌子
		List<Table> list = selectService.SelectAllTableNoStatus();
		request.setAttribute("AllTable", list);
		//跳回桌子列表jsp
		request.getRequestDispatcher("boardList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
