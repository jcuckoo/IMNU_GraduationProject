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
					<th>电影名称</th>
					<th>创建时间</th>
					<th>是否开放</th>
					<th>点击量</th>
					<th>是否推荐</th>
					<th>审核状态</th>
					<th>所属类别</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${datalist}" varStatus="status" var="var">
				<tr class="message-tr" id="table-tr-${status.index}" data-role="item" >
					<td>${status.index+1}</td>
					<td>${var.title}</td>
					<td><fmt:formatDate value="${var.createTime }" type="date" pattern="yyyy-MM-dd HH:mm" /></td>
					<td>
						<c:if test="${var.vip eq true }"><span class="label label-info" style="line-height: 24px;">VIP</span></c:if>
						<c:if test="${var.vip eq false }"><span class="label label-warning" style="line-height: 24px;">免费</span></c:if>
					</td>
					<td>${var.clickCount }次</td>
					<td>
						<c:if test="${var.groom eq true }"><span class="label label-primary" style="line-height: 24px;">已推荐</span></c:if>
						<c:if test="${var.groom eq false }"><span class="label label-info" style="line-height: 24px;">未推荐</span></c:if>
					</td>
					<td>
						<c:if test="${var.status == 0 }"><span class="label label-primary" style="line-height: 24px;">未审核</span></c:if>
						<c:if test="${var.status == 1 }"><span class="label label-info" style="line-height: 24px;">已审核</span></c:if>
					</td>
					<td>${var.filmType.name }</td>
					<td>
					    <div class="btn-group">
							<a href="javascript:void(0);" data-url="${ctx}/manage/film/view/${var.id }.do"
								data-toggle="modal" data-target="#modal" class="btn btn-default btn-sm">查看电影</a> 
							<a href="#" type="button" class="btn btn-default btn-sm dropdown-toggle" data-toggle="dropdown"> 
								<span class="caret" style="margin: 7px 0px;"></span> 
							</a>
							<ul class="dropdown-menu">
								<li>
									<a href="${ctx}/manage/film/edit.do?id=${var.id}">
										<i class="glyphicon glyphicon-edit"></i> 编辑
									</a>
								</li>
								<c:if test="${currentUser.userType eq '管理员' && var.status==0}">
									<li>
										<a href="javascript:push('${var.id }');">
											<i class="glyphicon glyphicon-pencil"></i> 审核
										</a>
									</li>
								</c:if>
								<li>
									<a href="javascript:" data-url="${ctx}/manage/film/delete.do?id=${var.id}" 
										data-role="item-delete" data-name="电影信息">
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