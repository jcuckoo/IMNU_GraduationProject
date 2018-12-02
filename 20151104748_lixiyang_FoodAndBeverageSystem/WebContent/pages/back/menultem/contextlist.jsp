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
					<th><input type="checkbox"	data-role="batch-select">序号</th>
					<th>菜谱名</th>
					<th>预订时间</th>
					<th>预订者</th>
					<th>价格</th>
					<th>付款状态</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${datalist}" varStatus="status" var="var">
				<tr class="message-tr" id="table-tr-${status.index}" data-role="item" >
					<td>
						<c:if test="${var.state == 0 }">
							<input value="${var.id}" type="checkbox" data-role="batch-item">
						</c:if>
						${status.index+1}
					</td>
					<td>${var.menuName}</td>
					<td><fmt:formatDate value="${var.createTime }" type="date" pattern="yyyy-MM-dd HH:mm" /></td>
					<td>${var.userName}</td>
					<td>${var.menuPrice }元/份</td>
					<td>
						<c:if test="${var.state == 0 }"><span class="label label-info" style="line-height: 24px;">未付款</span></c:if>
						<c:if test="${var.state == 1 }"><span class="label label-primary" style="line-height: 24px;">已付款</span></c:if>
					</td>
					<td>
						<a href="javascript:void();" data-url="${ctx}/manage/menuItem/edit.do?id=${var.id}"
							data-toggle="modal" data-target="#modal" class="btn btn-primary btn-sm" ${var.state == 1 ? 'disabled' : '' }>
							<i class="glyphicon glyphicon-edit"></i> 备注
						</a>&nbsp;&nbsp;
					    <a href="javascript:cancelOrder('${var.id }');" class="btn btn-info btn-sm" ${var.state == 1 ? 'disabled' : '' }>
							<i class="glyphicon glyphicon-folder-close"></i> 取消预订
						</a>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<div>
			<label class="checkbox-inline"><input type="checkbox" data-role="batch-select"> 全选</label>
			<button class="btn btn-primary btn-sm mlm" data-role="batch-pay"
				data-name="菜单明细" data-url="${ctx}/manage/order/save.do">
					<span class="glyphicon glyphicon-open"></span> 结算
			</button>
		</div>
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