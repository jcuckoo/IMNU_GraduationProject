<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/pages/commons/taglibs.jsp"%>

<div class="modal-dialog">
	<div class="modal-content">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			<h4 class="modal-title">${user.name }信息详情</h4>
		</div>
		<div class="modal-body">
			<table class="table table-bordered">
				<tr>
			  		<td>账号：</td>
			  		<td>${user.username }</td>
			  	</tr>
			  	<tr>
			  		<td>姓名：</td>
			  		<td>${user.name }</td>
			  	</tr>
			  	<tr>
			  		<td>所属角色：</td>
			  		<td>${user.userRole.name }</td>
			  	</tr>
			  	<tr>
			  		<td>联系方式：</td>
			  		<td>${user.mobile }</td>
			  	</tr>
			  	<tr>
			  		<td>注册日期：</td>
			  		<td><fmt:formatDate value="${user.createTime }" type="date" pattern="yyyy-MM-dd HH:mm"/></td>
			  	</tr>
			</table>
		</div>
		<div class="modal-footer">
			<button type="button" class="btn btn-link" data-dismiss="modal">关闭</button>
		</div>
	</div>
</div>
