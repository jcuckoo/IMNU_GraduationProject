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
					<th>账号</th>
					<th>姓名</th>
					<th>注册时间</th>
					<th>所属角色</th>
					<th>联系方式</th>
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
					<td>${var.userRole.name }</td>
					<td>${var.mobile }</td>
					<td>
					    <div class="btn-group">
							<a href="javascript:void(0);" data-url="${ctx}/manage/user/view/${var.id }.do"
								data-toggle="modal" data-target="#modal" class="btn btn-default btn-sm">查看用户</a> 
							<a href="#" type="button" class="btn btn-default btn-sm dropdown-toggle" data-toggle="dropdown"> 
								<span class="caret" style="margin: 7px 0px;"></span> 
							</a>
							<ul class="dropdown-menu">
								<li>
									<a href="javascript:void(0);" data-url="${ctx}/manage/user/edit/${var.id}.do"
										data-toggle="modal" data-target="#modal">
										<i class="glyphicon glyphicon-edit"></i> 编辑
									</a>
								</li>
								<c:if test="${var.userType eq '普通用户' }">
									<li>
										<a href="javascript:upLevel('${var.id }');">
											<i class="glyphicon glyphicon-pencil"></i> 升级VIP
										</a>
									</li>
								</c:if>
								<li>
									<a href="javascript:" data-url="${ctx}/manage/user/delete.do?id=${var.id}" 
										data-role="item-delete" data-name="用户信息">
										<i class="glyphicon glyphicon-trash"></i> 删除
									</a>
								</li>
							</ul>
						</div>
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