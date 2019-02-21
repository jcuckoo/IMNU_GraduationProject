<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/pages/commons/taglibs.jsp"%>

<div class="modal-dialog">
	<div class="modal-content">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			<h4 class="modal-title">保单信息</h4>
		</div>
		<div class="modal-body">
			<table class="table table-bordered">
				<tr>
			  		<td>保单编号：</td>
			  		<td>${order.number }</td>
			  	</tr>
				<tr>
			  		<td>投保人姓名：</td>
			  		<td>${order.userName }</td>
			  	</tr>
			  	<tr>
			  		<td>投保人联系方式：</td>
			  		<td>${order.user.mobile }</td>
			  	</tr>
			  	<tr>
			  		<td>保险名称：</td>
			  		<td>${order.insuranceName }</td>
			  	</tr>
			  	<tr>
			  		<td>创建时间：</td>
			  		<td><fmt:formatDate value="${order.createTime }" type="date" pattern="yyyy-MM-dd HH:mm"/></td>
			  	</tr>
			  	<tr>
			  		<td>起始时间：</td>
			  		<td><fmt:formatDate value="${order.beginTime }" type="date" pattern="yyyy-MM-dd HH:mm"/></td>
			  	</tr>
			  	<tr>
			  		<td>结束时间：</td>
			  		<td><fmt:formatDate value="${order.endTime }" type="date" pattern="yyyy-MM-dd HH:mm"/></td>
			  	</tr>
			  	<tr>
			  		<td>投保金额：</td>
			  		<td>${order.money }（单位：元）</td>
			  	</tr>
			  	<tr>
			  		<td>投保公司：</td>
			  		<td>${order.insurance.company.name }</td>
			  	</tr>
			</table>
		</div>

		<div class="modal-footer">
			<button type="button" class="btn btn-link" data-dismiss="modal">取消</button>
		</div>
		
	</div>
</div>
