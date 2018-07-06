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
		//取得所点菜集合
		List<Food> list = (List<Food>) request.getSession().getAttribute("CardList");
		//初始化totalPrice为0
		double totalPrice = 0;
		//遍历点菜单集合
		for (Food food : list) {
			//总价加当前菜价*菜数量
			totalPrice += food.getPrice() * food.getTotal();
		}
		//取得桌号
		String stringtableid = (String) request.getSession().getAttribute("tableid");
		//如果桌号为空 跳回主页重新点菜
		if (stringtableid == null || stringtableid == "") {
			response.sendRedirect("/");
		}
		//如果桌号不为空继续执行 将string类型桌号转换为int类型
		int tableid = new Integer(stringtableid);
		InsertService insertService = new InsertServiceImp();
		Random random = new Random();
		//生成8为随机数 作为ordernumber
		String iRandom = random.nextInt(10000000)+"";
		if(tableid == 0) {
			System.out.println("桌号为空:"+tableid);
		}else {
			try {
				DataSourceUtils.startTransaction();
				//插入 orderdetail
				boolean b = insertService.InsertOrder(iRandom , new Date(), totalPrice, 1, tableid);
				//循环插入food_order
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
