<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/pages/commons/taglibs.jsp"%>

<div class="modal-dialog">
	<div class="modal-content">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			<h4 class="modal-title">登录</h4>
		</div>
		<div class="modal-body">
			<form id="login-form" class="form-vertical" method="post" action="${ctx }/login.do">
				<div class="form-group">
					<div class="controls">
						<input class="form-control" id="username1" type="text" name="username" placeholder="用户登录账号...">
						<div class="help-block"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="controls">
						<input class="form-control" id="password" type="password" name="password" placeholder="用户登录密码...">
						<div class="help-block" style="display:none;"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="controls">
						<select class="form-control" id="userType" name="userType" style="width: 220px;">
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
		</div>
		<div class="modal-footer">
			<div class="pull-left" style="padding-top: 0px;">
				<span class="text-muted">还没有注册帐号？</span>
				<a href="${ctx }/toregister.html">立即注册</a>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	$(function(){
		$("#login-form").submit(function (e) {
            var form = $(this);
            // 阻止表单默认提交
            e.preventDefault();
            // 参数校验
			var username = $("#username1").val().trim();
			var password = $("#password").val().trim();
			var userType = $("#userType").val();
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
			if (userType == "" || userType == null){
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
		                    	location.href = "${ctx}/manage/user/list.do";								
							}else if (userType == "普通用户") {
								location.href = "${ctx}/index.html";
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
