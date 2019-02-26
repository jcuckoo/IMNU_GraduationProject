<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>${pageTitle }</title>
<%@ include file="/pages/commons/taglibs.jsp"%>
<%@ include file="/pages/commons/top.jsp" %>
</head>
<body>
	<!-- 头部begin -->
	<%@ include file="/pages/fore/menu_top.jsp" %>
	<!-- 头部end -->
	
	<!-- 登录区begin -->
	<div id="content-container" class="container">
		<div class="col-md-6 col-md-offset-3">
			<div class="panel panel-default panel-page">
				<div class="panel-heading">
					<h2>登录</h2>
				</div>
				<form id="login-form" class="form-vertical" method="post" action="${ctx }/login.do">
					<div class="form-group">
						<label class="control-label" for="username">帐号</label>
						<div class="controls">
							<input class="form-control" id="username" type="text" name="username" value="" placeholder="用户名">
							<div class="help-block"></div>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label" for="password">密码</label>
						<div class="controls">
							<input class="form-control" id="password" type="password" name="password" value="" placeholder="密码">
							<div class="help-block" style="display:none;"></div>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label" for="userRole">用户类型</label>
						<div class="controls">
							<select class="form-control" id="userRole" name="userRole.id" style="width: 160px;">
								<option value="">请选择用户类型...</option>
								<c:forEach var="role" items="${roleList }">
									<option value="${role.id }">${role.name }</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<div class="controls">
							<button id="login-btn" type="submit" class="btn btn-fat btn-primary btn-large">登 录</button>
						</div>
					</div>
				</form>

				<div class="ptl" style="padding-top: 10px;">
					<span class="text-muted">还没有注册帐号？</span>
					<a href="${ctx }/toregister.html">立即注册</a>
				</div>
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
				var userRole = $("#userRole").val();
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
				if (userRole == "" || userRole == null){
	                layer.msg("请选择用户类型！", {icon:0, time:2000, shift:6, shade:[0.5, '#393D49']});
	                return;
				}
	            //与后台交互
				var index;
	            $.ajax({
	                url:"${pageContext.request.contextPath}/login.do",
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
	                    	layer.msg("登录成功！2秒后自动跳转！", {icon:6, time:2000, shade:[0.5, '#393D49']}, function(){
	                    		var userType = data.data.userType;
	                    		if (userType == "管理员") {
			                    	location.href = "${pageContext.request.contextPath}/manage/index.do";								
								}else {
									location.href = "${pageContext.request.contextPath}/index.html";
								}
	                    	});
						}else {
							layer.msg(data.message, {icon:5, time:2000, shift:6, shade:[0.5, '#393D49']});
							$("#login-submit").removeAttr("disabled");
						}
	                },complete: function () {
	                    layer.close(index);
	                    $("#login-submit").removeAttr("disabled");
	                },
					error:function (data) {
	                    layer.msg(data.message, {icon:5,time:2000})
	                }
	            });
	        });
		});
	</script>
</body>
</html>