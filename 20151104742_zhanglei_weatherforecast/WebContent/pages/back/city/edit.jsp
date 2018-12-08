<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/pages/commons/taglibs.jsp"%>

<div class="modal-dialog">
	<div class="modal-content">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			<h4 class="modal-title">${empty city ? '新增' : '编辑' }城市信息</h4>
		</div>
		<div class="modal-body">
			<form id="save-form" class="form-horizontal" method="post" action="${ctx}/manage/city/save.do">
				<input type="hidden" id="id" name="id" value="${city.id }" />
				<div class="row form-group">
					<div class="col-md-3 control-label">
						<label for="name">城市名</label>
					</div>
					<div class="col-md-7 controls">
						<input type="text" id="name" name="name" class="form-control" value="${city.name }">
					</div>
				</div>

				<div class="row form-group">
					<div class="col-md-3 control-label">
						<label for="province">所属省份</label>
					</div>
					<div class="col-md-7 controls">
						<input type="text" id="province" name="province" class="form-control" value="${city.province }" placeholder="如：广东省">
					</div>
				</div>
			</form>
		</div>

		<div class="modal-footer">
			<button type="button" class="btn btn-link" data-dismiss="modal">取消</button>
			<button id="save-btn" data-submiting-text="正在提交" type="submit" class="btn btn-primary"
				data-toggle="form-submit" data-target="#save-form">提交</button>
			<script>app.load('city/save-modal');</script>
		</div>
		
	</div>
</div>
