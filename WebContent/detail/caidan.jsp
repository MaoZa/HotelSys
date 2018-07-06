<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<!-- 包含公共的JSP代码片段 -->
	
	<%
		pageContext.setAttribute("page", request.getAttribute("page"));
		session.setAttribute("tableid", request.getParameter("tableid"));
	%>
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
				
					<c:if test="${page == 0}">
						<c:forEach items="${AllFood }" var="food" begin="0" end="${end }">
						<li>
							<dl>
								<dt>
									<a href="caixiangqin?foodid=${food.id }">
										<img width="214px" height="145px" src="./${food.img }" />
									</a>
								</dt>
								<dd class="f1">
									<a href="caixiangqin?foodid=${food.id }">${food.foodname }</a>
								</dd>
								<dd class="f2">
									<a href="caixiangqin?foodid=${food.id }">&yen;${food.price }</a>
								</dd>
							</dl>
						</li>
					</c:forEach>
					</c:if>
					<c:if test="${page != 0 }">
						<c:forEach items="${AllFood }" var="food" begin="${(page-1) * 6 - (page-1) * 1}" end="${end + (page-1) * 6 - (page-1) * 1}">
						<li>
							<dl>
								<dt>
									<a href="caixiangqin?foodid=${food.id }">
										<img width="214px" height="145px" src="./${food.img }" />
									</a>
								</dt>
								<dd class="f1">
									<a href="caixiangqin?foodid=${food.id }">${food.foodname }</a>
								</dd>
								<dd class="f2">
									<a href="caixiangqin?foodid=${food.id }">&yen;${food.price }</a>
								</dd>
							</dl>
						</li>
					</c:forEach>
					</c:if>
				
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
						<c:if test="${empty foodcategoryid }">
							<c:forEach begin="0" end="${AllFoodCount / 6 }" var="i">
								<li><a href="./caidan?page=${i + 1}&tableid=${tableid }">${i + 1}</a></li>
							</c:forEach>
						</c:if>	
						
						<c:if test="${!empty foodcategoryid }">
							<c:forEach begin="0" end="${AllFoodCount / 6 }" var="i">
								<li><a href="./caidan?page=${i + 1}&foodcategoryid=${foodcategoryid }&tableid=${tableid }">${i + 1}</a></li>
							</c:forEach>
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
						<a href="clientCart">
							<img src="./detail/style/images/call2.gif" />
						</a>
					</li>
				</ul>
			</div>

			<div id="dish_2">
				<ul>
						<c:forEach items="${categoryList }" var="category">
							<li>
							<a href="caidan?foodcategoryid=${category.id }&page=1&tableid=${tableid }">${category.categoryname }</a>
						</li>
						</c:forEach>
					
				</ul>
			</div>
			<div id="dish_3">
				<!-- 搜索菜品表单  -->
				<form action="./caidan?tableid=${tableid }" method="post">
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