<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
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
<h2>登录</h2>
<form action="admir" method="post">
<table width="400" border="0" class="center loginbox">
  <tr>
    <td>用户名：</td>
    <td><input type="text" name="admir" class="in1" required="required"/></td>
  </tr>
  <tr>
    <td>密码：</td>
    <td><input type="password" name="password" class="in1" required="required"/></td>
  </tr>


<tr>
    <td></td>
    <td><input type="submit" value="登陆" name="type" /></td>

</table>
</form>

</div>
</body>
</html>