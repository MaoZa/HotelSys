package cn.dawnland.servlet;

import java.io.IOException;
import java.net.HttpCookie;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.dawnland.dao.SelectDao;
import cn.dawnland.dao.imp.SelectDaoImp;
import cn.dawnland.pojo.Category;
import cn.dawnland.pojo.Food;
import cn.dawnland.service.SelectService;
import cn.dawnland.service.imp.SelectServiceImp;

/**
 * Servlet implementation class CaiDanService
 */
public class CaiDanService extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SelectService selectService = new SelectServiceImp();
		List<Category> categoryList = selectService.SelectCategory();
		request.getSession().setAttribute("categoryList", categoryList);
		if(request.getParameter("tableid") != null) {
			request.getSession().setMaxInactiveInterval(10*60);
			int tableid = new Integer(request.getParameter("tableid"));
			System.out.println(request.getParameter("tableid")+"|"+request.getSession().getAttribute("tableid"));
			HttpSession session = request.getSession();
			session.setAttribute("tableid", tableid);
		}
		String foodcategoryid = request.getParameter("foodcategoryid");
		String foodname = request.getParameter("foodname");
		if(foodname == null || foodname == "")
		{
		//foodname为空
			if(foodcategoryid == null || foodcategoryid == "") {
			//foodcategoryid为空
				SelectDao selectDao = new SelectDaoImp();
				List<Food> list = selectDao.SelectFood();
				List<Food> list2 = new ArrayList<>();
				String begin = request.getParameter("begin");
				String end = request.getParameter("end");
				if (begin == null || begin =="" && end == null || end =="") {
				//begin end 为空
					request.setAttribute("begin", 0);
					request.setAttribute("page", request.getParameter("page"));
					request.setAttribute("end", 5);
					request.setAttribute("fornum", selectDao.SelectFoodTotal()/6+1);
					request.setAttribute("AllFood", list);
					request.setAttribute("AllFoodCount", selectDao.SelectFoodTotal());
					request.getRequestDispatcher("./detail/caidan.jsp").forward(request, response);
				}else {
				//begin end 不为空
					int begin1 = new Integer(begin);
					int end1 = new Integer(end);
					for (int i = begin1; i < list.size(); i++) {
						list2.add(list.get(i));
					}
					System.out.println(list.size() - begin1);
					System.out.println(list2);
					request.setAttribute("begin", begin1);
					request.setAttribute("page", request.getParameter("page"));
					request.setAttribute("end", end1);
					request.setAttribute("AllFood", list2);
					request.setAttribute("AllFoodCount", selectDao.SelectFoodTotal());
					request.getRequestDispatcher("./detail/caidan.jsp").forward(request, response);
				}
			}else {
			//foodcategoryid不为空
				SelectDao selectDao = new SelectDaoImp();
				List<Food> list = selectDao.SelectCategotyFood(new Integer(foodcategoryid));
				List<Food> list2 = new ArrayList<>();
				String begin = request.getParameter("begin");
				String end = request.getParameter("end");
				if (begin == null || begin =="" && end == null || end =="") {
					request.setAttribute("begin", 0);
					request.setAttribute("page", request.getParameter("page"));
					request.setAttribute("end", 5);
					request.setAttribute("AllFood", list);
					request.setAttribute("foodcategoryid", foodcategoryid);
					request.setAttribute("AllFoodCount", selectDao.SelectFootTotal(new Integer(foodcategoryid)));
					request.getRequestDispatcher("./detail/caidan.jsp?foodcategoryid="+foodcategoryid).forward(request, response);
				}else {
					int begin1 = new Integer(begin);
					int end1 = new Integer(end);
					for (int i = begin1; i < list.size(); i++) {
						list2.add(list.get(i));
				}
					request.setAttribute("begin", 0);
					request.setAttribute("page", request.getParameter("page"));
					request.setAttribute("end", list2.size());
					request.setAttribute("AllFood", list2);
					request.setAttribute("foodcategoryid", foodcategoryid);
					request.setAttribute("AllFoodCount", selectDao.SelectFootTotal(new Integer(foodcategoryid)));
					request.getRequestDispatcher("./detail/caidan.jsp?foodcategoryid="+foodcategoryid).forward(request, response);
				}
			}
		}else {
		//foodname不为空
			if(foodcategoryid == null || foodcategoryid == "") {
				SelectDao selectDao = new SelectDaoImp();
				List<Food> list = selectDao.SelectFootByName(foodname);
				List<Food> list2 = new ArrayList<>();
				String begin = request.getParameter("begin");
				String end = request.getParameter("end");
				if (begin == null || begin =="" && end == null || end =="") {
					request.setAttribute("begin", 0);
					request.setAttribute("page", request.getParameter("page"));
					request.setAttribute("end", 5);
					request.setAttribute("AllFood", list);
					request.setAttribute("AllFoodCount", list.size());
					request.getRequestDispatcher("./detail/caidan.jsp").forward(request, response);
				}else {
					int begin1 = new Integer(begin);
					int end1 = new Integer(end);
					for (int i = begin1; i < selectDao.SelectFoodTotal(); i++) {
						list2.add(list.get(i));
				}
					request.setAttribute("begin", 0);
					request.setAttribute("page", request.getParameter("page"));
					request.setAttribute("end", list2.size());
					request.setAttribute("AllFood", list2);
					request.setAttribute("AllFoodCount", list2.size());
					request.getRequestDispatcher("./detail/caidan.jsp").forward(request, response);
			}
			}else {
					SelectDao selectDao = new SelectDaoImp();
					List<Food> list = selectDao.SelectCategotyFood(new Integer(foodcategoryid));
					List<Food> list2 = new ArrayList<>();
					String begin = request.getParameter("begin");
					String end = request.getParameter("end");
					if (begin == null || begin =="" && end == null || end =="") {
						request.setAttribute("begin", 0);
						request.setAttribute("page", request.getParameter("page"));
						request.setAttribute("end", 5);
						request.setAttribute("AllFood", list);
						request.setAttribute("foodcategoryid", foodcategoryid);
						request.setAttribute("AllFoodCount", selectDao.SelectFootTotal(new Integer(foodcategoryid)));
						request.getRequestDispatcher("./detail/caidan.jsp?foodcategoryid="+foodcategoryid).forward(request, response);
					}else {
						int begin1 = new Integer(begin);
						int end1 = new Integer(end);
						for (int i = begin1; i < selectDao.SelectFoodTotal(); i++) {
							list2.add(list.get(i));
						}
						request.setAttribute("begin", 0);
						request.setAttribute("page", request.getParameter("page"));
						request.setAttribute("end", list2.size());
						request.setAttribute("AllFood", list2);
						request.setAttribute("foodcategoryid", foodcategoryid);
						request.setAttribute("AllFoodCount", selectDao.SelectFootTotal(new Integer(foodcategoryid)));
						request.getRequestDispatcher("./detail/caidan.jsp?foodcategoryid="+foodcategoryid).forward(request, response);
					}
				}
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
