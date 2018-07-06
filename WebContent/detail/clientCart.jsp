<%@page import="java.util.List"%>
<%@page import="cn.dawnland.pojo.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="./detail/style/css/index.css" />
	<script type="text/javascript">
		//** // 删除菜品项
		function removeSorder(node) {
			var gid = node.lang;
			var tableid = ${tableid };
			window.location.href = "deletefood?tableid=" + tableid + "&gid=" + gid;
		}
		
		// 修改菜品项数量
		function alterSorder(node) {
			var total = node.value;
			var gid = node.lang;
			window.location.href = "sorder?gid=" + gid + "&total=" + total + "&tableid=" + ${tableid };
		}
		//*/
		// 下单
		function genernateOrder() {
			window.location.href = "clientOrderList?tableid=${tableid }";
		}
	</script>
	<%
		List<Food> list = (List<Food>)session.getAttribute("CardList");
		double totalCount = 0;
		for(Food food : list){
			totalCount += food.getPrice() * food.getTotal();
		}
		session.setAttribute("totalCount", totalCount);
	%>
</head>
<body style="text-align: center">
	<div id="all">
		<div id="menu">
			<!-- 餐车div -->
			<div id="count">
				<table align="center" width="100%">
					<tr height="40">
				 		<td align="center" width="20%">菜名</td>
				 		<td align="center" width="20%">单价</td>
				 		<td align="center" width="20%">数量</td>
				 		<td align="center" width="20%">小计</td>
				 		<td align="center" width="20%">操作</td>
				 	</tr>
				 	
				 	<c:forEach items="${CardList }" var="Food">
				 	
				 		<tr height="60">
					 		<td align="center" width="20%">${Food.foodname }</td>
					 		<td align="center" width="20%">￥${Food.price }</td>
					 		<td align="center" width="20%">
					 			<input type="text" value='<c:if test="${empty Food.total }">1</c:if><c:if test="${!empty Food.total }">${Food.total }</c:if>' size="3" lang="${Food.id }" onblur="alterSorder(this)"/>
					 		</td>
					 		<td align="center" width="20%">${Food.price * Food.total }</td>
					 		<td align="center" width="20%">
					 			<input type="button" value="删除" class="btn_next" lang="${Food.id }" onclick="removeSorder(this)" />
					 		</td>
				 		</tr>
				 	
				 	</c:forEach>
				 	
					<tr>
						<td colspan="6" align="right">总计:
							<span style="font-size:36px;">&yen;&nbsp;${totalCount }</span>
							<label
								id="counter" style="font-size:36px"></label>
						</td>
					</tr>
					<tr>
						<td colspan="6" style="margin-left: 100px; text-align: center;"align="right">
							<input type="hidden" name="bId" value="">
							
								
								
									<input type="button" value="下单" class="btn_next" onclick="genernateOrder()" />
								
							
						</td>
					</tr>
				</table>
			</div>
		</div>

		<!-- 右边菜系列表，菜品搜索框  -->
		<div id="dish_class">
			<div id="dish_top">
				<ul>
				<li class="dish_num"></li>
					<li>
						<a href="clientCart?tableid=${tableid }">
							<img src="./detail/style/images/call2.gif" />
						</a>
					</li>
				</ul>
			</div>

			<div id="dish_2">
				<ul>
					
						<li>
							<a href="caidan?foodcategoryid=1&page=1&tableid=${tableid }">粤菜</a>
						</li>
					
						<li>
							<a href="caidan?foodcategoryid=2&page=1&tableid=${tableid }">川菜</a>
						</li>
					
						<li>
							<a href="caidan?foodcategoryid=3&page=1&tableid=${tableid }">湘菜</a>
						</li>
					
						<li>
							<a href="caidan?foodcategoryid=4&page=1&tableid=${tableid }">东北菜</a>
						</li>
					
				</ul>
			</div>
			<div id="dish_3">
				<!-- 搜索菜品表单  -->
				<form action="#" method="post">
					<table width="166px">
						<tr>
							<td>
								<input type="text" id="dish_name" name="foodName" class="select_value" /> 
								<input type="hidden" value="selectFood" name="method">
							</td>
						</tr>
						<tr>
							<td><input type="submit" id="sub" value="" /></td>
						</tr>
						<tr>
							<td>
								<a href="./caidan?page=1&tableid=${tableid }">
									<img src="./detail/style/images/look.gif" />
								</a>
							</td>
						</tr>
					</table>
				</form>
			</div>
			
			
		</div>
	</div>
</body>
</html>