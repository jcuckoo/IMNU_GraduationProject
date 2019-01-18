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
	<div class="navbar navbar-inverse navbar-fixed-top site-navbar">
		<div class="container ">
	    	<div class="navbar-header">
	        	<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
		          	<span class="icon-bar"></span>
		          	<span class="icon-bar"></span>
		          	<span class="icon-bar"></span>
	        	</button>
	        	<a class="navbar-brand" href="${ctx }/index.html" style="margin-top: -16px;">
	        		<img src="${ctx}/static/images/icon/logo.png" />
	        	</a>
	      	</div>
	      	<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right" id="navbar-right">
		            <li><a href="${ctx }/index.html"><i class="glyphicon glyphicon-home"></i>&nbsp;回到首页</a></li>
				</ul>
	      	</div>
	    </div>
	</div>
	<!-- 头部end -->
	
	<!-- 登录区begin -->
	<div id="content-container" class="container" style="margin-top: 80px;">
		<div class="col-md-6 col-md-offset-3">
			<div class="panel panel-default panel-page">
				<div class="panel-heading">
					<h2>登录</h2>
				</div>
				<form id="login-form" class="form-vertical" method="post" action="${ctx }/login.do">
					<div class="form-group">
						<label class="control-label" for="username">帐号</label>
						<div class="controls">
							<input class="form-control" id="username" type="text" name="username" value="" placeholder="登录账号">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label" for="password">密码</label>
						<div class="controls">
							<input class="form-control" id="password" type="password" name="password" value="" placeholder="登录密码">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label" for="validateCode">验证码</label>
						<div class="controls">
							<input class="form-control" id="validateCode" type="text" name="validateCode" value="" placeholder="登录验证码" maxlength="4">
							<img src="${ctx}/image.jsp" id="imageCode" class="pull-right" title="看不清，点击更换！" onclick="javascript:loadValidateCode();">
						</div>
					</div>
					<input type="hidden" name="userRole.id" value="1">
					<div class="form-group">
						<div class="controls">
							<button id="login-btn" type="submit" class="btn btn-fat btn-primary btn-large">登 录</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- 登录区end -->
	
	<!-- 底部begin -->
	<%@ include file="/pages/commons/bottomjs.jsp" %>
	<!-- 底部end -->
	<script type="text/javascript">
		// 验证码
		function loadValidateCode(){
			document.getElementById("imageCode").src="${ctx}/image.jsp?"+Math.random();
		}
		
		$(function(){
			$("#login-form").submit(function (e) {
	            var form = $(this);
	            // 阻止表单默认提交
	            e.preventDefault();
	            // 参数校验
				var username = $("#username").val();
				var password = $("#password").val();
				var validateCode = $("#validateCode").val();
				if (username == "" || username == null){
					layer.msg("用户名不能为空！", {icon:0, time:2000, shift:6, shade:[0.5, '#393D49']});
					$("#username").focus();
					return;
				}
				if (password == "" || password == null){
	                layer.msg("密码不能为空！", {icon:0, time:2000, shift:6, shade:[0.5, '#393D49']});
	                $("#password").focus();
	                return;
				}
				if (validateCode == "" || validateCode == null){
	                layer.msg("验证码不能为空！", {icon:0, time:2000, shift:6, shade:[0.5, '#393D49']});
	                return;
				}
	            //与后台交互
				var index;
	            $.ajax({
	                url:form.attr("action"),
	                type:"POST",
	                dataType:"JSON",
	                data:form.serialize(),
	                beforeSend: function () {
	                    index = layer.msg("登录中，请稍候...", {icon:16});
	                    // 禁用按钮防止重复提交
	                    $("#login-submit").attr({disabled: "disabled"});
	                },
	                success:function (data) {
	                    if(data.resultCode=="SUCCESS") {
	                    	layer.msg("登录成功，3秒后自动跳转！", {icon:6, time:3000, shade:[0.5, '#393D49']}, function(){
								location.href = "${ctx}/manage/index.do";
	                    	});
						}else {
							layer.msg(data.message, {icon:5, time:2000, shift:6, shade:[0.5, '#393D49']});
							$("#login-submit").removeAttr("disabled");
							loadValidateCode();
						}
	                },complete: function () {
	                    layer.close(index);
	                    $("#login-submit").removeAttr("disabled");
	                },error:function (data) {
	                    layer.msg(data.message, {icon:5,time:2000})
	                }
	            });
	        });
		});
	</script>
</body>
</html>