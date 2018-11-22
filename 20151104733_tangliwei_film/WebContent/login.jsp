<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    ${message}
    <form action="login" method="post">
    
    用户名<input type="text" name="username" id="username"/>
    密码<input type="password" name="userpass" id="userpass"/>
    <input type="submit" value="提交"/>
    </form>
</body>
</html>