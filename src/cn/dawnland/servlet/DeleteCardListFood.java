package cn.dawnland.servlet;

import java.io.IOException;
import java.util.List;

import javax.management.modelmbean.RequiredModelMBean;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.dawnland.pojo.Food;

/**
 * Servlet implementation class DeleteCardListFood
 */
public class DeleteCardListFood extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡ��Ҫɾ�˵�gid
		int gid = Integer.parseInt(request.getParameter("gid"));
		List<Food> list = (List<Food>) request.getSession().getAttribute("CardList");
		String tableid = request.getParameter("tableid");
		double totalCount = (double) request.getSession().getAttribute("totalCount");
		for (Food food : list) {
			//�����ҵ���ǰ��
			if(food.getId()==gid) {
				//�Ӽ������Ƴ���ǰ��
				list.remove(food);
				//���¼����ܼ�
				totalCount -= food.getPrice() * food.getTotal();
				//����ֻ��ɾ��һ���� ֱ������ѭ��
				break;
			}
		}
		request.getSession().setAttribute("totalCount", totalCount);
		request.getSession().setAttribute("CardList", list);
		request.getSession().setAttribute("tableid", tableid);
		request.getRequestDispatcher("clientCart").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
