<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="./detail/style/css/index.css" />
	<script type="text/javascript">
		// 通知服务员结账
		function callPay(node) {
			var orderId = node.lang;
			window.location.href = "jiezhang";
		}
	</script>
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
				 	</tr>
					<c:forEach items="${tableAllFood }" var="Food">
						<tr height="60">
					 		<td align="center" width="20%">${Food.foodname }</td>
					 		<td align="center" width="20%">￥${Food.price }</td>
					 		<td align="center" width="20%">${Food.total }</td>
					 		<td align="center" width="20%">${Food.price * Food.total }</td>
				 		</tr>
					</c:forEach>
					
					<tr>
						<td colspan="6" align="right">总计:
							<span style="font-size:36px;">&yen;</span>
							<label
								id="counter" style="font-size:36px">${totalCount }</label>
						</td>
					</tr>
					<tr>
						<td colspan="6" style="margin-left: 100px; text-align: center;"align="right">
							<input type="hidden" name="bId" value="">
							<input type="button" value="结账" class="btn_next" lang="" onclick="callPay(this)" />
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
						<a href="clientOrderList">
							<img src="./detail/style/images/call2.gif" />
						</a>
					</li>
				</ul>
			</div>

			<div id="dish_2">
				<ul>
					
						<li>
							<a href="caidan.html">粤菜</a>
						</li>
					
						<li>
							<a href="chuancai.html">川菜</a>
						</li>
					
						<li>
							<a href="chuancai.html">湘菜</a>
						</li>
					
						<li>
							<a href="chuancai.html">东北菜</a>
						</li>
					
				</ul>
			</div>
			<div id="dish_3">
				<!-- 搜索菜品表单  -->
				<form action="/wirelessplatform/food.html" method="post">
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