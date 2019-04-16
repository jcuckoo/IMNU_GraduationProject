<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/pages/commons/taglibs.jsp"%>

<div class="modal-dialog">
	<div class="modal-content">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			<h4 class="modal-title">修改密码</h4>
		</div>
		<div class="modal-body">
			<form id="save-form" class="form-horizontal" method="post" action="${ctx}/manage/user/updatepwd.do">
				<input type="hidden" id="id" name="id" value="${user.id }">
				<div class="row form-group">
					<div class="col-md-2 control-label">
						<label for="truename">用户姓名</label>
					</div>
					<div class="col-md-8 controls">
						<input type="text" id="truename" name="truename" class="form-control" readonly="readonly"
							placeholder="用户姓名" value="${user.truename }" style="background-color: #fff;">
					</div>
				</div>
				
				<div class="row form-group">
					<div class="col-md-2 control-label">
						<label for="password">原密码</label>
					</div>
					<div class="col-md-8 controls">
						<input type="password" id="password" name="password" class="form-control" 
							placeholder="新密码">
					</div>
					<span class="points">*</span>
				</div>
				
				<div class="row form-group">
					<div class="col-md-2 control-label">
						<label for="newPassword">新密码</label>
					</div>
					<div class="col-md-8 controls">
						<input type="password" id="newPassword" name="newPassword" class="form-control" 
							placeholder="新密码">
					</div>
					<span class="points">*</span>
				</div>
				
				<div class="row form-group">
					<div class="col-md-2 control-label">
						<label for="confirmPassword">确认密码</label>
					</div>
					<div class="col-md-8 controls">
						<input type="password" id="confirmPassword" name="confirmPassword" class="form-control" 
							placeholder="确认密码">
					</div>
					<span class="points">*</span>
				</div>
				
			</form>
		</div>
		<div class="modal-footer">
			<button type="button" class="btn btn-link" data-dismiss="modal">取消</button>
			<button id="save-btn" data-submiting-text="密码正在修改" type="submit" class="btn btn-primary"
				data-toggle="form-submit" data-target="#save-form">确定</button>
			<script>
				app.load('user/editPwd');
			</script>
		</div>
		
	</div>
</div>
