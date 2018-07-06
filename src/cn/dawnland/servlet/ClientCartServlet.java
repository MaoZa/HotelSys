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
			//���foodid��Ϊ��
				totalCount = 0;
				SelectDao selectDao = new SelectDaoImp();
				Food food = selectDao.SelectFoot(new Integer(request.getParameter("foodid")));
				listold = (List<Food>) request.getSession().getAttribute("CardList");
				boolean flag = false;
				if(listold != null) {
					for (Food food2 : listold) {
						if(food2.toString().equals(food.toString())) {//�ж��ϼ������Ƿ�����foodid��
						//����� ��ǰfood2.total + 1
							food2.setTotal(food2.getTotal()+1);
							flag = true;//�Ѵ��� ��������+1 �޸�flagΪtrue
							break;
						}
					}
				}
				if(flag) {
					//���flagΪtrue���� �ϼ������е�ǰ�� ���Ҳ�total��+1
					//ֱ�ӽ��ϼ��ϴ���session
					request.getSession().setAttribute("CardList", listold);
				}else {
					//���flagΪfalse�����ϼ�����û�е�ǰ�� ���ߵ�ǰ��Ϊ��һ����
					List<Food> listnew = new ArrayList<>();//newһ���¼���
					//����ǰ����ӵ��¼���
					listnew.add(food);
					//�ж��ϼ����Ƿ�Ϊ�� ����ǰ���Ƿ�Ϊ��һ����
					if(listold != null) {
						//����ϼ��ϲ�Ϊ��  ���ϼ���׷�ӵ��¼���
						listnew.addAll(listold);
					}
					//�¼��ϴ���session
					request.getSession().setAttribute("CardList", listnew);
				}
			}
		//����
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
