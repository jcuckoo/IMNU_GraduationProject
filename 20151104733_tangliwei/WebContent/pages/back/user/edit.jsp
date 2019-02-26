<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/pages/commons/taglibs.jsp"%>

<div class="modal-dialog">
	<div class="modal-content">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			<h4 class="modal-title">编辑用户信息</h4>
		</div>
		<div class="modal-body">
			<form id="save-form" class="form-horizontal" method="post" action="${ctx}/manage/user/save.do">
				<input type="hidden" id="id" name="id" value="${user.id }" />
				<div class="row form-group">
					<div class="col-md-3 control-label">
						<label for="truename">姓名</label>
					</div>
					<div class="col-md-7 controls">
						<input type="text" id="truename" name="truename" class="form-control" value="${user.truename }" readonly style="background: #fff;">
					</div>
				</div>

				<div class="row form-group">
					<div class="col-md-3 control-label">
						<label for="username">账号</label>
					</div>
					<div class="col-md-7 controls">
						<input type="text" id="username" name="username" class="form-control" value="${user.username }" readonly style="background: #fff;">
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
