package cn.dawnland.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.dawnland.pojo.Food;
import cn.dawnland.service.InsertService;
import cn.dawnland.service.imp.InsertServiceImp;
import cn.dawnland.service.imp.SelectServiceImp;
import cn.dawnland.utils.DataSourceUtils;

/**
 * Servlet implementation class ClientOrderList
 */
public class ClientOrderList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ȡ������˼���
		List<Food> list = (List<Food>) request.getSession().getAttribute("CardList");
		//��ʼ��totalPriceΪ0
		double totalPrice = 0;
		//������˵�����
		for (Food food : list) {
			//�ܼۼӵ�ǰ�˼�*������
			totalPrice += food.getPrice() * food.getTotal();
		}
		//ȡ������
		String stringtableid = (String) request.getSession().getAttribute("tableid");
		//�������Ϊ�� ������ҳ���µ��
		if (stringtableid == null || stringtableid == "") {
			response.sendRedirect("/");
		}
		//������Ų�Ϊ�ռ���ִ�� ��string��������ת��Ϊint����
		int tableid = new Integer(stringtableid);
		InsertService insertService = new InsertServiceImp();
		Random random = new Random();
		//����8Ϊ����� ��Ϊordernumber
		String iRandom = random.nextInt(10000000)+"";
		if(tableid == 0) {
			System.out.println("����Ϊ��:"+tableid);
		}else {
			try {
				DataSourceUtils.startTransaction();
				//���� orderdetail
				boolean b = insertService.InsertOrder(iRandom , new Date(), totalPrice, 1, tableid);
				//ѭ������food_order
				for (Food food : list) {
					boolean b1 = insertService.InsertDetail(food.getId(), tableid , food.getTotal(), iRandom);
				}
			} catch (SQLException e) {
				try {
					DataSourceUtils.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			}finally {
				try {
					DataSourceUtils.commitAndRelease();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
		request.getSession().setAttribute("tableAllFood", list);
		request.getSession().setAttribute("totalCount", totalPrice);
		request.getRequestDispatcher("./detail/clientOrderList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
