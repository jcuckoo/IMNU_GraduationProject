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
					<th>菜谱名</th>
					<th>创建时间</th>
					<th>价格</th>
					<th>预定量</th>
					<th>是否推荐</th>
					<th>所属菜系</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${datalist}" varStatus="status" var="var">
				<tr class="message-tr" id="table-tr-${status.index}" data-role="item" >
					<td>${status.index+1}</td>
					<td>${var.name}</td>
					<td><fmt:formatDate value="${var.createTime }" type="date" pattern="yyyy-MM-dd HH:mm" /></td>
					<td>${var.price }元/份</td>
					<td>${var.buyCount }次</td>
					<td>
						<c:if test="${var.groom eq true }"><span class="label label-primary" style="line-height: 24px;">已推荐</span></c:if>
						<c:if test="${var.groom eq false }"><span class="label label-info" style="line-height: 24px;">未推荐</span></c:if>
					</td>
					<td>${var.menuType.name }</td>
					<td>
					    <div class="btn-group">
							<a href="javascript:void(0);" data-url="${ctx}/manage/menu/view/${var.id }.do"
								data-toggle="modal" data-target="#modal" class="btn btn-default btn-sm">查看菜谱</a> 
							<a href="#" type="button" class="btn btn-default btn-sm dropdown-toggle" data-toggle="dropdown"> 
								<span class="caret" style="margin: 7px 0px;"></span> 
							</a>
							<ul class="dropdown-menu">
								<li>
									<a href="${ctx}/manage/menu/edit.do?id=${var.id}">
										<i class="glyphicon glyphicon-edit"></i> 编辑
									</a>
								</li>
								<li>
									<a href="javascript:" data-url="${ctx}/manage/menu/delete.do?id=${var.id}" 
										data-role="item-delete" data-name="菜单信息">
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