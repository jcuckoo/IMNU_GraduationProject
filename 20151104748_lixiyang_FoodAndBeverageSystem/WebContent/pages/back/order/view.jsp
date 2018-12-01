<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/pages/commons/taglibs.jsp"%>

<div class="modal-dialog">
	<div class="modal-content">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			<h4 class="modal-title">点菜备注信息</h4>
		</div>
		<div class="modal-body">
			<table class="table table-bordered">
				<tr>
			  		<td>备注：</td>
			  		<td>${order.remark }</td>
			  	</tr>
			</table>
		</div>

		<div class="modal-footer">
			<button type="button" class="btn btn-link" data-dismiss="modal">取消</button>
		</div>
		
	</div>
</div>
