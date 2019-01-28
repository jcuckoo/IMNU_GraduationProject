<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>${pageTitle }</title>
<%@ include file="/pages/commons/taglibs.jsp"%>
<%@ include file="/pages/commons/top.jsp" %>
<link href="${ctx}/static/css/login.css?${random}" rel="stylesheet"/>
</head>
<body>
	<!-- 头部begin -->
	<%@ include file="/pages/fore/menu_top.jsp" %>
	<!-- 头部end -->
	
	<!-- 登录区begin -->
	<div class="navbar-banner layout-no-margin-top">
		<div class="banner-container" style="padding-top: 80px;">
			<div class="container">
				<div class="row">
					<div class="col-md-7">
						<h1 class="banner-title">欢迎您的到来</h1>
						<p class="banner-tag">大特保，让保险更加健康！</p>
					</div>
					<div class="col-md-5">
						<form id="register-form" class="form-vertical" method="post" action="${ctx }/register.do">
							<div class="form-group">
								<label class="control-label required" for="username">用户名</label>
								<div class="controls">
									<input class="form-control" id="username" type="text" name="username" value="" 
										data-url="${ctx }/check/username.do?username=" placeholder="登录账号，建议使用英文">
									<p class="help-block"></p>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label required" for="truename">真实姓名</label>
								<div class="controls">
									<input type="text" id="truename" name="truename" class="form-control" placeholder="填写你的真实姓名">
									<p class="help-block"></p>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label required" for="mobile">手机号码</label>
								<div class="controls">
									<input type="text" id="mobile" name="mobile" class="form-control" placeholder="填写你的手机号">
									<p class="help-block"></p>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label required" for="address">住址</label>
								<div class="controls">
									<input type="text" id="address" name="address" class="form-control" placeholder="填写你的住址，如广东省广州市黄埔区...">
									<p class="help-block"></p>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label required" for="password">登录密码</label>
								<div class="controls">
									<input class="form-control" id="password" type="password" name="password" value="" placeholder="登录密码">
									<p class="help-block"></p>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label required" for="confirmPassword">确认密码</label>
								<div class="controls">
									<input type="password" id="confirmPassword" name="confirmPassword" class="form-control" placeholder="再输入一次密码">
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
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="introduce-unit col-sm-4 col-md-4">
                <div>
                	<a class="introduce-img">
                		<img src="${ctx }/static/images/gif/introduce1.gif">
                	</a>
                </div>
                <div><span class="introduce-span">服务高效/全面，有保障！</span></div>
            </div>
            <div class="introduce-unit col-sm-4 col-md-4">
                <div>
                	<a class="introduce-img">
                		<img src="${ctx }/static/images/gif/introduce2.gif">
                	</a>
                </div>
                <div><span class="introduce-span">业务内容丰富，涉及范围广泛！</span></div>
            </div>
            <div class="introduce-unit col-sm-4 col-md-4">
                <div>
                	<a class="introduce-img">
                		<img src="${ctx }/static/images/gif/introduce3.gif">
                	</a>
                </div>
                <div><span class="introduce-span">真诚服务，一切从用户角度出发！</span></div>
            </div>
		</div>
	</div>
	<!-- 登录区end -->
	
	<!-- 底部begin -->
	<%@ include file="/pages/commons/bottomjs.jsp" %>
	<script>app.controller = 'user/register';</script>
	<!-- 底部end -->
</body>
</html>