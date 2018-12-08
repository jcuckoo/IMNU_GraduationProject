<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
${message }
<form action="register" method="post">
用户名<input type="text" name="user_name" id="user_name" required="required"/><br>
密码<input type="password" name="user_pass" id="user_pass" required="required"/><br>
电话<input type="text" name="user_phone" id="user_phone" required="required"/><br>
钱<input type="text" name="user_money" id="user_money" required="required"/><br>
<input type="submit" value="提交"/>
</form>
</body>
</html>