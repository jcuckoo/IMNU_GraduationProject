<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/foot.css" type="text/css">
</head>
<body>
	<div>
		<a>关于易职</a> | 
		<a>网站地图</a> | 
		<a>友情链接</a> | 
		<a>网站统计</a>
		<br>
		<br><br>
		<span>copyright ©2018 easyjob.com. All Rights Reserved.</span>
	</div>
	<span id="disclaimer">免费服务热线：xxx-xxx-xxxx     免责声明：本网站内容的解释权归本站所有</span>
</body>
</html>