<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/pages/commons/taglibs.jsp"%>

<div class="modal-dialog">
	<div class="modal-content">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			<h4 class="modal-title">${empty company ? '新增' : '编辑' }保险公司</h4>
		</div>
		<div class="modal-body">
			<form id="save-form" class="form-horizontal" method="post" action="${ctx}/manage/company/save.do">
				<input type="hidden" id="id" name="id" value="${company.id }" />
				<div class="row form-group">
					<div class="col-md-3 control-label">
						<label for="number">公司编号</label>
					</div>
					<div class="col-md-7 controls">
						<input type="text" id="number" name="number" class="form-control" 
							value="${company.number }" placeholder="公司编号，如20181010">
					</div>
				</div>
				
				<div class="row form-group">
					<div class="col-md-3 control-label">
						<label for="name">公司名称</label>
					</div>
					<div class="col-md-7 controls">
						<input type="text" id="name" name="name" class="form-control" 
							value="${company.name }"  placeholder="公司名称，如平安保险有限责任公司">
					</div>
				</div>
				
				<div class="row form-group">
					<div class="col-md-3 control-label">
						<label for="creator">创始人</label>
					</div>
					<div class="col-md-7 controls">
						<input type="text" id="creator" name="creator" class="form-control" 
							value="${company.creator }" placeholder="公司创始人">
					</div>
				</div>

				<div class="row form-group">
					<div class="col-md-3 control-label">
						<label for="mobile">公司电话</label>
					</div>
					<div class="col-md-7 controls">
						<input type="text" id="mobile" name="mobile" class="form-control" 
							value="${company.mobile }" placeholder="公司电话">
					</div>
				</div>
				
				<div class="row form-group">
					<div class="col-md-3 control-label">
						<label for="address">公司地址</label>
					</div>
					<div class="col-md-7 controls">
						<input type="text" id="address" name="address" class="form-control" 
							value="${company.address }" placeholder="公司详细地址，如广州天河区科学园">
					</div>
				</div>
				
				<div class="row form-group">
					<div class="col-md-3 control-label">
						<label for="remark">公司简介</label>
					</div>
					<div class="col-md-7 controls">
						<textarea id="remark" name="remark" class="form-control" rows="5">${company.remark }</textarea>
					</div>
				</div>
			</form>
		</div>

		<div class="modal-footer">
			<button type="button" class="btn btn-link" data-dismiss="modal">取消</button>
			<button id="save-btn" data-submiting-text="正在提交" type="submit" class="btn btn-primary"
				data-toggle="form-submit" data-target="#save-form">提交</button>
			<script>app.load('company/save-modal');</script>
		</div>
		
	</div>
</div>
