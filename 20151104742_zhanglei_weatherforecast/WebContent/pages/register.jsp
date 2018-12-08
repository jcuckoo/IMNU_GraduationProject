<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>${pageTitle }</title>
<%@ include file="/pages/commons/taglibs.jsp" %>
<%@ include file="/pages/commons/top.jsp" %>
<%@ include file="/pages/back_top.jsp" %>
</head>
<body>
	<!-- 导航-->
	<jsp:include page="/pages/menu_top.jsp"/>
	
	
	<!-- 注册-->
	<div id="content-container" class="container">
		<div class="col-md-6 col-md-offset-3 ptl">
			<div class="panel panel-default panel-page">
				<div class="panel-heading">
					<h2>注册</h2>
				</div>
				
				<form id="register-form" method="post" action="${ctx }/register.do">
					
					<div class="form-group">
						<label class="control-label required" for="username">用户名</label>
						<div class="controls">
							<input type="text" id="username" name="username" required="required" class="form-control" 
								data-url="${ctx }/check/username.do?username=" placeholder="登录账号，建议使用工号作为登录账号">
							<p class="help-block"></p>
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label" for="name">真实姓名</label>
						<div class="controls">
							<input type="text" id="name" name="name" required="required" class="form-control" placeholder="填写你的真实姓名">
							<p class="help-block"></p>
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label required" for="mobile">手机号</label>
						<div class="controls">
							<input type="text" id="mobile" name="mobile" required="required" class="form-control" placeholder="填写你的手机号">
							<p class="help-block"></p>
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label required" for="address">所属省市</label>
						<div class="controls">
							<input type="text" id="address" name="address" required="required" class="form-control" placeholder="所属省市信息">
							<p class="help-block"></p>
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label required" for="password">密码</label>
						<div class="controls">
							<input type="password" id="password" name="password" required="required" class="form-control" placeholder="4-20位英文、数字、符号，区分大小写" data-widget-cid="widget-2" data-explain="">
							<p class="help-block"></p>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label required" for="confirmPassword">确认密码</label>
						<div class="controls">
							<input type="password" id="confirmPassword" name="confirmPassword" required="required" class="form-control" placeholder="再输入一次密码">
							<p class="help-block"></p>
						</div>
					</div>
					
					<div class="form-group">
						<div class="controls">
							<button type="submit" id="register-btn" data-submiting-text="正在提交" class="btn btn-primary btn-large btn-block">注 册</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	
	
	<!-- 底部 -->
	<%@ include file="/pages/commons/bottomjs.jsp" %>
	<script>app.controller = 'user/register';</script>
	
</body>
</html>