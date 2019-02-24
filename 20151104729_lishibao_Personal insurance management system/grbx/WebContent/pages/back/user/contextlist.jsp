<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/pages/commons/taglibs.jsp"%>
<%@ taglib uri='/tag/page-tags' prefix='p'%>
<style type="text/css">
	#message-table tr th{
		text-align: center;
	}
	#message-table tr td{
		text-align: center;
	}
</style>
<html>
<head></head>
<body>
	<c:if test="${not empty datalist}">
		<table class="table table-bordered" id="message-table">
			<thead>
				<tr>
					<th>序号</th>
					<th>账号</th>
					<th>姓名</th>
					<th>创建时间</th>
					<th>联系邮箱</th>
					<th>所属角色</th>
					<th>住址</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${datalist}" varStatus="status" var="var">
				<tr class="message-tr" id="table-tr-${status.index}" data-role="item" >
					<td>${status.index+1}</td>
					<td>${var.username}</td>
					<td>${var.truename }</td>
					<td><fmt:formatDate value="${var.createTime }" type="date" pattern="yyyy-MM-dd HH:mm" /></td>
					<td>${var.mobile }</td>
					<td>${var.userRole.name }</td>
					<td style="overflow: hidden;">${var.address }</td>
					<td>
						<a href="javascript:void(0);" data-url="${ctx}/manage/user/view/${var.id}.do"
							class="btn btn-primary btn-sm" data-toggle="modal" data-target="#modal">
							<i class="glyphicon glyphicon-eye-open"></i> 查看
						</a>&nbsp;
						<a href="javascript:void(0);" data-url="${ctx}/manage/user/edit/${var.id}.do"
							class="btn btn-info btn-sm" data-toggle="modal" data-target="#modal">
							<i class="glyphicon glyphicon-edit"></i> 编辑
						</a>&nbsp;
						<a href="javascript:void(0);" data-url="${ctx}/manage/user/delete.do?id=${var.id}" 
							class="btn btn-warning btn-sm" data-role="item-delete" data-name="用户信息">
							<i class="glyphicon glyphicon-trash"></i> 删除
						</a>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
	<c:if test="${empty datalist}">
		<ul class="media-list conversation-list">
			<li class="empty">暂无相关信息</li>
		</ul>
	</c:if>
	
	<!-- 分页begin -->
	<div>
		<p:PageNav />
	</div>
	<!-- 分页end -->
</body>
</html>