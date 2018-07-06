<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<!-- 包含公共的JSP代码片段 -->
	<title>无线点餐平台</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script type="text/javascript" src="./detail/style/js/jquery.js"></script>
	<script type="text/javascript" src="./detail/style/js/page_common.js"></script>
	<link href="./detail/style/css/common_style_blue.css" rel="stylesheet" type="text/css">
	<link rel="stylesheet" type="text/css" href="./detail/style/css/index_1.css" />
	<link href="./detail/style/css/index.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div id="all">
		<div id="menu">
			<!-- 显示菜品的div -->
			<div id="top">
				<ul>
					<!-- 循环列出餐品 -->
					<c:forEach items="${AllFood }" var="food" begin="0" end="${end - begin }">
						<li>
							<dl>
								<dt>
									<a href="caixiangxi.jsp?foodid=${food.id }">
										<img width="214px" height="145px" src="./style/images/huangbuchaodan.jpg" />
									</a>
								</dt>
								<dd class="f1">
									<a href="caixiangxi.html">${food.foodname }</a>
								</dd>
								<dd class="f2">
									<a href="caixiangxi.html">&yen;${food.price }</a>
								</dd>
							</dl>
						</li>
					
					</c:forEach>
				
				</ul>
			</div>
			
			<!-- 底部分页导航条div -->
			<div id="foot">
				
					
					
						<span
							style="float:left; line-height:53PX; margin-left:-50px; font-weight:bold; ">
							<span style="font-weight:bold">&lt;&lt;</span>
						</span>
					
				
				<div id="btn">
					<ul>
						<!-- 参看 百度, 谷歌是 左 5 右 4 -->
						<c:if test="${empty foodcategoryid }">
						<!-- foodcategoryid为空 -->
							<c:if test="${AllFoodCount / 6 > 1 }">
							<!-- AllFoodCount / 6 大于1 (一页以上) -->
								<c:forEach begin="${begin }" end="${AllFoodCount / 6}" var="i">
								<c:if test="${begin == 0 }">
									<c:if test="${i == 0 }">
										<li><a href="./caidan">${i + 1 }</a></li>
									</c:if>
									<c:if test="${i > 0 }">
										<li><a href="./caidan?begin=${i * 6 - 1 }&end=${i * 6 + 6 - 1 }">${i + 1 }</a></li>
									</c:if>
								</c:if>
								</c:forEach>
							</c:if>
							<c:if test="${AllFoodCount - begin / 6 <= 1 }">
							<!-- AllFoodCount / 6 小于或等于1 (正好六个菜品或者六个以下) -->
								<c:forEach begin="${begin }" end="" var="i">
								<c:if test="${begin == 0 }">
									<c:if test="${i == 0 }">
										<li><a href="./caidan">${i + 1 }</a></li>
									</c:if>
									<c:if test="${i > 0 }">
										<li><a href="./caidan?begin=${i * 6 - 1 }&end=${i * 6 + 6 - 1 }">${i + 1 }</a></li>
									</c:if>
								</c:if>
								</c:forEach>
							</c:if>
						</c:if>
						<c:if test="${!empty foodcategoryid }">
						<!-- foodcategoryid不为空 -->
							<c:if test="${AllFoodCount / 6 > 1 }">
							<c:forEach begin="${begin }" end="${AllFoodCount / 6 + 1 }" var="i">
							<c:if test="${begin == 0 }">
								<c:if test="${i == 0 }">
									<li><a href="./caidan?foodcategoryid=${foodcategoryid }">${i + 1 }</a></li>
								</c:if>
								<c:if test="${i > 0 }">
									<li><a href="./caidan?foodcategoryid=${foodcategoryid }&begin=${i * 6 -1 }&end=${i * 6 + 6 - 1 }">${i + 1 }</a></li>
								</c:if>
							</c:if>
							</c:forEach>
							</c:if>
							<c:if test="${AllFoodCount / 6 <= 1 }">
								<c:forEach begin="${begin }" end="${AllFoodCount / 6 + 1}" var="i">
								<c:if test="${begin == 0 }">
									<c:if test="${i == 0 }">
										<li><a href="./caidan?foodcategoryid=${foodcategoryid }">${i + 1 }</a></li>
									</c:if>
									<c:if test="${i > 0 }">
										<li><a href="./caidan?foodcategoryid=${foodcategoryid }&begin=${i * 6 -1 }&end=${i * 6 + 6 - 1 }">${i + 1 }</a></li>
									</c:if>
								</c:if>
							</c:forEach>
							</c:if>
						</c:if>
					</ul>
				</div>
				
					
						<span style="float:right; line-height:53px; margin-right:10px;  ">
							<a
							href="#"
							style=" text-decoration:none;color:#000000; font-weight:bold">&gt;&gt;</a>
						</span>
					
					
				
			</div>
			
		</div>

		<!-- 右边菜系列表，菜品搜索框  -->
		<div id="dish_class">
			<div id="dish_top">
				<ul>
				<li class="dish_num"></li>
					<li>
						<a href="clientOrderList.html">
							<img src="./detail/style/images/call2.gif" />
						</a>
					</li>
				</ul>
			</div>

			<div id="dish_2">
				<ul>
					
						<li>
							<a href="caidan?foodcategoryid=1">粤菜</a>
						</li>
					
						<li>
							<a href="caidan?foodcategoryid=2">川菜</a>
						</li>
					
						<li>
							<a href="caidan?foodcategoryid=3">湘菜</a>
						</li>
					
						<li>
							<a href="caidan?foodcategoryid=4">东北菜</a>
						</li>
					
				</ul>
			</div>
			<div id="dish_3">
				<!-- 搜索菜品表单  -->
				<form action="./caidan" method="post">
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
								<a href="#">
									<img src="style/images/look.gif" />
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