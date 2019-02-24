<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/pages/commons/taglibs.jsp"%>

<div class="modal-dialog">
	<div class="modal-content">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			<h4 class="modal-title">${empty user ? '新增' : '编辑' }用户信息</h4>
		</div>
		<div class="modal-body">
			<form id="save-form" class="form-horizontal" method="post" action="${ctx}/manage/user/save.do">
				<div class="alert alert-info">
					<ul style="list-style: none;">
						<li>系统提示：用户姓名/账号不可进行编辑！</li>
					</ul>
				</div>
				<input type="hidden" id="id" name="id" value="${user.id }" />
				<div class="row form-group">
					<div class="col-md-3 control-label">
						<label for="truename">姓名</label>
					</div>
					<div class="col-md-7 controls">
						<input type="text" id="truename" name="truename" class="form-control" value="${user.truename }"
							disabled="disabled" style="background: #fff;">
					</div>
				</div>

				<div class="row form-group">
					<div class="col-md-3 control-label">
						<label for="username">账号</label>
					</div>
					<div class="col-md-7 controls">
						<input type="text" id="username" name="username" class="form-control" value="${user.username }" 
							disabled="disabled" style="background: #fff;">
					</div>
				</div>
				
				<div class="row form-group">
					<div class="col-md-3 control-label">
						<label for="mobile">联系方式</label>
					</div>
					<div class="col-md-7 controls">
						<input type="text" id="mobile" name="mobile" class="form-control" value="${user.mobile }">
					</div>
				</div>
				
				<div class="row form-group">
					<div class="col-md-3 control-label">
						<label for="email">邮箱地址</label>
					</div>
					<div class="col-md-7 controls">
						<input type="text" id="email" name="email" class="form-control" value="${user.email }">
					</div>
				</div>
				
				<div class="row form-group">
					<div class="col-md-3 control-label">
						<label for="address">住址</label>
					</div>
					<div class="col-md-7 controls">
						<input type="text" id="address" name="address" class="form-control" value="${user.address }">
					</div>
				</div>
			</form>
		</div>

		<div class="modal-footer">
			<button type="button" class="btn btn-link" data-dismiss="modal">取消</button>
			<button id="save-btn" data-submiting-text="正在提交" type="submit" class="btn btn-primary"
				data-toggle="form-submit" data-target="#save-form">提交</button>
			<script>app.load('user/save-modal');</script>
		</div>
		
	</div>
</div>
