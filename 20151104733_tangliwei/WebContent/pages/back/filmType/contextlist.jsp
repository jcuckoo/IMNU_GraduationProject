<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/pages/commons/taglibs.jsp"%>
<%@ taglib uri='/tag/page-tags' prefix='p'%>

<html>
<head></head>
<body>
	<c:if test="${not empty datalist}">
		<table class="table table-striped table-hover" id="message-table">
			<thead>
				<tr>
					<th>序号</th>
					<th>电影类别名</th>
					<th>创建时间</th>
					<th>备注信息</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${datalist}" varStatus="status" var="var">
					<tr class="message-tr" id="table-tr-${status.index}" data-role="item" >
						<td>${status.index+1}</td>
						<td>${var.name}</td>
						<td><fmt:formatDate value="${var.createTime }" type="date" pattern="yyyy-MM-dd HH:mm" /></td>
						<td>${fn:substring(var.remark, 0, 25) }</td>
						<td>
							<a href="javascript:void();" data-url="${ctx}/manage/filmType/edit.do?id=${var.id}"
								data-toggle="modal" data-target="#modal" class="btn btn-info btn-sm">
								<i class="glyphicon glyphicon-edit"></i> 编辑
							</a>&nbsp;&nbsp;
							<a href="javascript:" data-url="${ctx}/manage/filmType/delete.do?id=${var.id}" 
								data-role="item-delete" data-name="电影类别信息" class="btn btn-warning btn-sm">
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