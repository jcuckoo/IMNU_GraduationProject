<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    ${msg}
    <form action="getUserInfo" method="post">
    
    用户名<input type="text" name="username" id="username"/>
    <input type="submit" value="提交"/>
    </form>
</body>
</html>