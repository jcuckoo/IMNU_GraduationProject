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
		<div class="banner-container">
			<div class="container">
				<div class="row">
					<div class="col-md-7">
						<h1 class="banner-title">欢迎您的到来</h1>
						<p class="banner-tag">大特保，让保险更加健康！</p>
					</div>
					<div class="col-md-5">
						<form id="login-form" class="form-vertical" method="post" action="${ctx }/login.do">
							<div class="form-group" style="margin-bottom: 26px;">
								<div class="controls">
									<input class="form-control" id="username" type="text" name="username" value="" placeholder="登录账号">
								</div>
							</div>
							<div class="form-group" style="margin-bottom: 26px;">
								<div class="controls">
									<input class="form-control" id="password" type="password" name="password" value="" placeholder="登录密码">
								</div>
							</div>
							<input type="hidden" name="userRole.id" value="2">
							<div class="form-group">
								<div class="controls">
									<button id="login-submit" type="submit" class="form-control">登 录</button>
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
	<!-- 底部end -->
	<script type="text/javascript">
		$(function(){
			$("#login-form").submit(function (e) {
	            var form = $(this);
	            // 阻止表单默认提交
	            e.preventDefault();
	            // 参数校验
				var username = $("#username").val().trim();
				var password = $("#password").val().trim();
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
								location.href = "${ctx}/index.html";
	                    	});
						}else {
							layer.msg(data.message, {icon:5, time:2000, shift:6, shade:[0.5, '#393D49']});
							$("#login-submit").removeAttr("disabled");
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