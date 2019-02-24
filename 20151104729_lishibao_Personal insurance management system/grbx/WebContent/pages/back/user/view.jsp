<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/pages/commons/taglibs.jsp"%>

<div class="modal-dialog">
	<div class="modal-content">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			<h4 class="modal-title">个人信息</h4>
		</div>
		<div class="modal-body">
			<table class="table table-bordered">
				<tr>
			  		<td>用户名：</td>
			  		<td>${user.username }</td>
			  	</tr>
				<tr>
			  		<td>姓名：</td>
			  		<td>${user.truename }</td>
			  	</tr>
			  	<tr>
			  		<td>联系方式：</td>
			  		<td>${user.mobile }</td>
			  	</tr>
			  	<tr>
			  		<td>联系邮箱：</td>
			  		<td>${user.email }</td>
			  	</tr>
			  	<tr>
			  		<td>创建时间：</td>
			  		<td><fmt:formatDate value="${user.createTime }" type="date" pattern="yyyy-MM-dd HH:mm"/></td>
			  	</tr>
			  	<tr>
			  		<td>住址：</td>
			  		<td>${user.address }</td>
			  	</tr>
			  	<tr>
			  		<td>所属角色：</td>
			  		<td>${user.userRole.name }</td>
			  	</tr>
			  	<tr>
			  		<td>用户头像：</td>
			  		<td>
			  			<c:if test="${empty user.picImg }">
			  				<img alt="${user.truename }" src="${ctx }/static/images/avatar.png" style="width: 60px;height: 60px;">
			  			</c:if>
			  			<c:if test="${not empty picImg }">
				  			<img alt="${user.truename }" src="${ctx }/${user.picImg}" style="width: 60px;height: 60px;">			  				
			  			</c:if>
			  		</td>
			  	</tr>
			</table>
		</div>

		<div class="modal-footer">
			<button type="button" class="btn btn-link" data-dismiss="modal">取消</button>
		</div>
		
	</div>
</div>
