package cn.dawnland.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import cn.dawnland.dao.SelectDao;
import cn.dawnland.dao.imp.SelectDaoImp;
import cn.dawnland.pojo.Food;

/**
 * Servlet implementation class ClientCartServlet
 */
public class ClientCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Food> listold = (List<Food>) request.getSession().getAttribute("CardList");
		double totalCount;
			if(request.getParameter("foodid") != null) {
			//如果foodid不为空
				totalCount = 0;
				SelectDao selectDao = new SelectDaoImp();
				Food food = selectDao.SelectFoot(new Integer(request.getParameter("foodid")));
				listold = (List<Food>) request.getSession().getAttribute("CardList");
				boolean flag = false;
				if(listold != null) {
					for (Food food2 : listold) {
						if(food2.toString().equals(food.toString())) {//判断老集合内是否已有foodid菜
						//如果有 当前food2.total + 1
							food2.setTotal(food2.getTotal()+1);
							flag = true;//已存在 并且总数+1 修改flag为true
							break;
						}
					}
				}
				if(flag) {
					//如果flag为true代表 老集合已有当前菜 并且菜total已+1
					//直接将老集合存入session
					request.getSession().setAttribute("CardList", listold);
				}else {
					//如果flag为false代表老集合内没有当前菜 或者当前菜为第一道菜
					List<Food> listnew = new ArrayList<>();//new一个新集合
					//将当前菜添加到新集合
					listnew.add(food);
					//判断老集合是否为空 即当前菜是否为第一道菜
					if(listold != null) {
						//如果老集合不为空  将老集合追加到新集合
						listnew.addAll(listold);
					}
					//新集合存入session
					request.getSession().setAttribute("CardList", listnew);
				}
			}
		//跳回
		request.getRequestDispatcher("./detail/clientCart.jsp?tableid=" + request.getParameter("tableid")).forward(request, response);
	}
		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
