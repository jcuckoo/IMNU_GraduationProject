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
					<th>保单编号</th>
					<th>保险名称</th>
					<th>创建时间</th>
					<th>金额</th>
					<th>投保人</th>
					<th>投保公司</th>
					<th>审核状态</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${datalist}" varStatus="status" var="var">
				<tr class="message-tr" id="table-tr-${status.index}" data-role="item" >
					<td>${status.index+1}</td>
					<td>${var.number}</td>
					<td>${var.insuranceName }</td>
					<td><fmt:formatDate value="${var.createTime }" type="date" pattern="yyyy-MM-dd HH:mm" /></td>
					<td>${var.money }元</td>
					<td>${var.userName }</td>
					<td>${var.insurance.company.name }</td>
					<td>
						<c:if test="${var.state == 0}"><span class="label label-info" style="line-height: 24px;">未审核</span></c:if>
						<c:if test="${var.state == 1}"><span class="label label-primary" style="line-height: 24px;">已审核</span></c:if>
					</td>
					<td>
						<a href="javascript:void(0);" data-url="${ctx}/manage/order/view/${var.id}.html" 
							class="btn btn-sm btn-primary" data-toggle="modal" data-target="#modal">
							<i class="glyphicon glyphicon-eye-open"></i> 查看
						</a>&nbsp;
						<c:if test="${currentUser.userRole.name eq '管理员' }">
							<a href="javascript:approve(${var.id });" class="btn btn-sm btn-info" ${var.state==1 ? 'disabled' : '' }>
								<i class="glyphicon glyphicon-edit"></i> 审核
							</a>&nbsp;
						</c:if>
						<a href="javascript:void(0);" data-url="${ctx}/manage/order/delete.do?id=${var.id}" ${var.state==1 ? 'disabled' : '' }
							 class="btn btn-sm btn-warning" data-role="item-delete" data-name="保单信息">
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
	<script type="text/javascript">
		function approve(id){
			layer.confirm('您确定通过审核吗？', {icon:3, title:'系统提示'}, function(){
				var url = "${ctx}/manage/order/approve.do";
				$.post(url, {'id':id}, function(data){
					if (data.resultCode == 'SUCCESS') {
						layer.msg('审批成功！', {icon:6});
						createPageList(1);
					}else {
						layer.msg(data.message, {icon:5});
					}
				}, 'json');
			});
		}
	</script>
</body>
</html>