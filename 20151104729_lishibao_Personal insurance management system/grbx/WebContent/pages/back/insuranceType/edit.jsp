<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/pages/commons/taglibs.jsp"%>

<div class="modal-dialog">
	<div class="modal-content">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			<h4 class="modal-title">${empty insurance ? '新增' : '编辑' }保险类别信息</h4>
		</div>
		<div class="modal-body">
			<form id="save-form" class="form-horizontal" method="post" action="${ctx}/manage/insuranceType/save.do">
				<input type="hidden" id="id" name="id" value="${insuranceType.id }" />
				<div class="row form-group">
					<div class="col-md-3 control-label">
						<label for="name">类别名称</label>
					</div>
					<div class="col-md-7 controls">
						<input type="text" id="name" name="name" class="form-control" value="${insuranceType.name }">
					</div>
				</div>
			</form>
		</div>

		<div class="modal-footer">
			<button type="button" class="btn btn-link" data-dismiss="modal">取消</button>
			<button id="save-btn" data-submiting-text="正在提交" type="submit" class="btn btn-primary"
				data-toggle="form-submit" data-target="#save-form">提交</button>
			<script>app.load('insuranceType/save-modal');</script>
		</div>
		
	</div>
</div>
