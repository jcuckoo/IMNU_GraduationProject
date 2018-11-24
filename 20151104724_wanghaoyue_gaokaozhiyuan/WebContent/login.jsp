<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/login.css" />
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/login.js"></script>
<title>登录</title>
</head>
<body>
<div id="slider-title">
		<img src="${pageContext.request.contextPath }/img/3.png" height="45" width="45" />
		<div id="title-logo">志愿填报
		 <span id="font"><font style="color: red;margin-left: 380px;margin-right: 20px;">会员中心</font></span>
         <span id="font" style="margin-right: 20px;">官方微博</span> <span id="font" style="margin-right: 20px;">问题反馈</span>
         <span id="font" style="margin-right: 20px;">商务合作</span><span id="font" style="margin-right: 20px;">客户端下载</span>
         <span id="font" style="margin-right: 20px;">关注我们</span>
         <span id="font" style="margin-right: 20px;"><font style="color:red" style="margin-right: 20px;">严打违规文件和盗版侵权传播</font></span>
		</div>
</div>
<div class="slider">
		<ul class="slider-main">
			<li class="slider-panel"><a href="login.jsp" ><img
					alt="志愿填报" title="志愿填报" src="${pageContext.request.contextPath }/img/10.jpg"></a></li>
			<li class="slider-panel"><a href="login.jsp" ><img
					alt="志愿填报"   src="${pageContext.request.contextPath }/img/5.jpg"></a></li>
			<li class="slider-panel"><a href="login.jsp" ><img
					alt="志愿填报" title="志愿填报" src="${pageContext.request.contextPath }/img/14.jpg"></a></li>
			<li class="slider-panel"><a href="login.jsp" ><img
					alt="志愿填报" title="志愿填报" src="${pageContext.request.contextPath }/img/7.jpg"></a></li>
		</ul>
<div class="slider-extra">
			<ul class="slider-nav">
				<li class="slider-item"></li>
				<li class="slider-item"></li>
				<li class="slider-item"></li>
				<li class="slider-item"></li>
			</ul>
		</div>
</div>
<div id="login">
		<form action="user/login.action" method="post">
			<div id="form-title">账号密码登录</div>
			<input type="text" placeholder="用户名" name="username" class="login-input" id="name" />
			<input type="password" placeholder="密码" name="password" class="login-input" /><br/>
<!-- 			<input type="checkbox" class="input" /><span class="ck_text">下次自动登录</span> -->
			<input type="submit" value="登录" class="login-btn" /><br/>
			<div id="a_div">
				<a href="#" class="a_login">登录遇到问题</a> <a class="a_login" href="#"
					id="phone">海外手机号</a>
			</div>
			<div id="bottom">
				<div id="inner">
					<div class="inner">
						<a href="#" class="a_inner">扫一扫登录</a>
					</div>
					<div class="img-login">
						<img src="${pageContext.request.contextPath }/img/weibo.png" width="25" height="25">
					</div>
					<div class="img-login">
						<img src="${pageContext.request.contextPath }/img/6.png" width="25" height="25">
					</div>
					<div class="img-login">
						<img src="${pageContext.request.contextPath }/img/qq.png" width="25" height="25">
					</div>
					<div>
						<input type="submit" onclick="return regist()" value="立即注册" class="submit">
					</div>
					  <div class="clearFloat"></div>
				</div>
			</div>
		</form>
	</div>
</body>
<script type="text/javascript">
	function regist(){
		window.location.href = "user/regist.action";
		return false;
	}
</script>
</body>
</html>