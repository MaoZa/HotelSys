<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 	<!-- 包含公共的JSP代码片段 -->
	
	<title>无线点餐平台</title>
	
	
	
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script type="text/javascript" src="${pageContext.request.contextPath }/admin/sys/style/js/jquery.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/admin/sys/style/js/page_common.js"></script>
	<link href="${pageContext.request.contextPath }/admin/sys/style/css/common_style_blue.css" rel="stylesheet" type="text/css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/admin/sys/style/css/index_1.css" />
</head>
<body>
<!-- 页面标题 -->
	<div id="TitleArea">
		<div id="TitleArea_Head"></div>
		<div id="TitleArea_Title">
			<div id="TitleArea_Title_Content">
				<img border="0" width="13" height="13" src="${pageContext.request.contextPath }/admin/sys/style/images/title_arrow.gif"/> 餐桌列表
			</div>
	    </div>
		<div id="TitleArea_End"></div>
	</div>
	
	
	<!-- 过滤条件 -->
	<div id="QueryArea">
		<form action="/wirelessplatform/board.html" method="get">
			<input type="hidden" name="method" value="search">
			<input type="text" name="keyword" title="请输入餐桌名称">
			<input type="submit" value="搜索">
		</form>
	</div>
	
	
	<!-- 主内容区域（数据列表或表单显示） -->
	<div id="MainArea">
	    <table class="MainArea_Content" cellspacing="0" cellpadding="0">
	        <!-- 表头-->
	        <thead>
	            <tr align="center" valign="middle" id="TableTitle">
					<td>编号</td>
					<td>桌名</td>
					<td>状态</td>
					<td>预定时间</td>
					<td>操作</td>
				</tr>
			</thead>	
			<!--显示数据列表 -->
	        <tbody id="TableData">
				
				<c:forEach items="${AllTable }" var="table">
				<tr class="TableDetail1">
					<td align="center">${table.id }&nbsp;</td>
					<td align="center"> ${table.tablename }&nbsp;</td>
					<td align="center">
						<c:if test="${table.tablestatus == 0 }">未预定</c:if>
						<c:if test="${table.tablestatus == 1 }">已预订</c:if>
					</td>
					<td align="center">${table.presettime }</td>
					<td>
						<c:if test="${table.tablestatus == 1 }">
							<a href="${pageContext.request.contextPath }/admin/boardupdate?tableid=${table.id }&tablestatus=0" class="FunctionButton">退桌</a>
						</c:if>		
						<c:if test="${table.tablestatus == 0 }">
							<a href="${pageContext.request.contextPath }/admin/boardupdate?tableid=${table.id }&tablestatus=1" class="FunctionButton">预定</a>
						</c:if>			
						<a href="${pageContext.request.contextPath }/admin/boarddelete?tableid=${table.id }" onClick="return delConfirm();"class="FunctionButton">删除</a>				
					</td>
				</tr>
	        	</c:forEach>
	        	
	        </tbody>
	    </table>
		
	   <!-- 其他功能超链接 -->
		<div id="TableTail" align="center">
			<div class="FunctionButton"><a href="${pageContext.request.contextPath }/admin/sys/saveBoard.jsp">添加</a></div>
	    </div> 
	</div>
</body>
</html>