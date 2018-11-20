<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
<style>
* {
	margin: 0;
	padding: 0;
}
html {
	width: 100%;
	height: 100%;
}
body {
	width: 100%;
	height: 100%;

}

.footer {
	height: 200px;

	margin-top: 30px;
	text-align: center;
	color: green;
}
.footer table {
	margin: auto;
}
.footer a {
	color: #fff;
}

.loginbox{
	line-height:35px;	
}
.in1{
	height:40px;
	width:240px;	
}

</style>
</head>

<body style="background: url(image/4.jpg)">

<br /><br /><br />

<div class="footer">
<h2>注册</h2>
<form action="register" method="post">
<table width="400" border="0" class="center loginbox">
  <tr>
    <td>用户名：</td>
    <td><input type="text" name="username" class="in1" required="required"/></td>
  </tr>
  <tr>
    <td>密码：</td>
    <td><input type="password" name="userpass" class="in1" required="required"/></td>
  </tr>
  <tr>
   <td>电话: </td>
    <td><input type="text" name="usernumber" class="in1" required="required"/></td>
  </tr>
    <tr>
   <td>收货地址: </td>
    <td><input type="text" name="useraddress" class="in1" required="required"/></td>
  </tr>

<tr>
    <td><a href="login.jsp">去登录</a></td>
    <td><input type="submit" value="注 册" name="type" />&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="重 置" /></td>

</table>
</form>

</div>
</body>
</html>