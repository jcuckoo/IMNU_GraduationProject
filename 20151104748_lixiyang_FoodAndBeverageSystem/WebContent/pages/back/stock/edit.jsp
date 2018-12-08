<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/pages/commons/taglibs.jsp"%>

<div class="modal-dialog">
	<div class="modal-content">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			<h4 class="modal-title">${empty stock ? '新增' : '编辑'}产品库存信息</h4>
		</div>
		<div class="modal-body">
			<form id="save-form" class="form-horizontal" method="post" action="${ctx}/manage/stock/save.do">
				<input type="hidden" id="id" name="id" value="${stock.id }" />
				<div class="row form-group">
					<div class="col-md-3 control-label">
						<label for="productNo">产品编号</label>
					</div>
					<div class="col-md-7 controls">
						<input type="text" id="productNo" name="productNo" class="form-control inputStart" value="${stock.productNo }">
						<span class="points">*</span>
					</div>
				</div>
				
				<div class="row form-group">
					<div class="col-md-3 control-label">
						<label for="productName">产品名称</label>
					</div>
					<div class="col-md-7 controls">
						<input type="text" id="productName" name="productName" class="form-control inputStart" value="${stock.productName }">
						<span class="points">*</span>
					</div>
				</div>
				
				<div class="row form-group">
					<div class="col-md-3 control-label">
						<label for="stockNum">库存量</label>
					</div>
					<div class="col-md-7 controls">
						<input type="text" id="stockNum" name="stockNum" class="form-control inputStart" value="${stock.stockNum }">
						<span class="points">*</span>
					</div>
				</div>
			</form>
		</div>

		<div class="modal-footer">
			<button type="button" class="btn btn-link" data-dismiss="modal">取消</button>
			<button id="save-btn" data-submiting-text="正在提交" type="submit" class="btn btn-primary"
				data-toggle="form-submit" data-target="#save-form">提交</button>
			<script>app.load('stock/save-modal');</script>
		</div>
		
	</div>
</div>
