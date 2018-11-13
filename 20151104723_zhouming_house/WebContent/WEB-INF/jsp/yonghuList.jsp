<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<html>
<head>
<!-- 包含公共的JSP代码片段 -->

<title>点餐平台</title>



<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="style/js/jquery.js"></script>
<script type="text/javascript" src="style/js/page_common.js"></script>
<link href="style/css/common_style_blue.css" rel="stylesheet"
	type="text/css">
<link rel="stylesheet" type="text/css" href="style/css/index_1.css" />
</head>
<body>
	<!-- 页面标题 -->
	<div id="TitleArea">
		<div id="TitleArea_Head"></div>
		<div id="TitleArea_Title">
			<div id="TitleArea_Title_Content">
				<img border="0" width="13" height="13"
					src="style/images/title_arrow.gif" /> 用户列表
			</div>
		</div>
		<div id="TitleArea_End"></div>
	</div>


	<!-- 过滤条件 -->
	<div id="QueryArea">
		<form action="selectUser" method="post">
			<input type="hidden" name="method" value="search"> <input
				type="text" name="keyword" title="请输入用户名称"> <input
				type="submit" value="搜索">
		</form>
	</div>


	<!-- 主内容区域（数据列表或表单显示） -->
	<div id="MainArea">
		<table class="MainArea_Content" cellspacing="0" cellpadding="0">
			<!-- 表头-->
			<tr align="center" valign="middle" id="TableTitle">
				<td>编号</td>
				<td>姓名</td>
				<td>电话</td>
				<td>操作</td>
			</tr>
			
			<c:if test="${userInfoList.size()>0}">

				<c:forEach items="${userInfoList }" var="userSingle">

					<tr align="center">
						<td>${userSingle.user_id }</td>
						<td>${userSingle.user_name }</td>
						<td>${userSingle.user_phone }</td>
						<td><a href="UpdateUserInfo?id=${userSingle.user_id }
									&name=${userSingle.user_name }
									&phone=${userSingle.user_phone }">修改</a> 
						<a href="DeleteUser?id=${userSingle.user_id }">删除</a></td>
					</tr>
				</c:forEach>


			</c:if>

			
		</table>

		<!-- 其他功能超链接 -->
		<div id="TableTail" align="center">
			<div class="FunctionButton">
				<a href="saveuser.html">添加</a>
			</div>
		</div>
	</div>
</body>
</html>
