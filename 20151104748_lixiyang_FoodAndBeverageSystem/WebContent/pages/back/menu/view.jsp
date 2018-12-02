<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/pages/commons/taglibs.jsp"%>

<div class="modal-dialog">
	<div class="modal-content">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			<h4 class="modal-title">菜单信息详情</h4>
		</div>
		<div class="modal-body">
			<table class="table table-bordered">
				<tr>
			  		<td>菜单名：</td>
			  		<td>${menu.name }</td>
			  	</tr>
			  	<tr>
			  		<td>价格：</td>
			  		<td>${menu.price }元/份</td>
			  	</tr>
			  	<tr>
			  		<td>售出量：</td>
			  		<td>${menu.buyCount }份</td>
			  	</tr>
			  	<tr>
			  		<td>所属菜系：</td>
			  		<td>${menu.menuType.name }</td>
			  	</tr>
			  	<tr>
			  		<td>创建时间：</td>
			  		<td><fmt:formatDate value="${menu.createTime }" type="date" pattern="yyyy-MM-dd HH:mm"/></td>
			  	</tr>
			  	<tr>
			  		<td>简介：</td>
			  		<td>${menu.content }</td>
			  	</tr>
			</table>
		</div>
		<div class="modal-footer">
			<button type="button" class="btn btn-link" data-dismiss="modal">关闭</button>
		</div>
	</div>
</div>
