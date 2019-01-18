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
					<th>保险编号</th>
					<th>保险名称</th>
					<th>创建时间</th>
					<th>金额</th>
					<th>所属类别</th>
					<th>所属公司</th>
					<th>是否推荐</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${datalist}" varStatus="status" var="var">
				<tr class="message-tr" id="table-tr-${status.index}" data-role="item" >
					<td>${status.index+1}</td>
					<td>${var.number}</td>
					<td>${var.title }</td>
					<td><fmt:formatDate value="${var.createTime }" type="date" pattern="yyyy-MM-dd HH:mm" /></td>
					<td>${var.money }</td>
					<td>${var.insuranceType.name }</td>
					<td>${var.company.name }</td>
					<td>
						<c:if test="${var.groom eq false}"><span class="label label-primary" style="line-height: 24px;">未推荐</span></c:if>
						<c:if test="${var.groom eq true}"><span class="label label-info" style="line-height: 24px;">已推荐</span></c:if>
					</td>
					<td>
						<a href="${ctx}/insurance/view/${var.id}.html" class="btn btn-sm btn-primary">
							<i class="glyphicon glyphicon-eye-open"></i> 查看
						</a>&nbsp;
						<a href="${ctx}/manage/insurance/edit.do?id=${var.id}" class="btn btn-sm btn-info">
							<i class="glyphicon glyphicon-edit"></i> 编辑
						</a>&nbsp;
						<a href="javascript:void(0);" data-url="${ctx}/manage/insurance/delete.do?id=${var.id}" 
							 class="btn btn-sm btn-warning" data-role="item-delete" data-name="保险信息">
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
		function check(id){
			layer.confirm('您确定通过审批吗？', {icon:3, title:'系统提示'}, function(){
				var url = "${ctx}/manage/insurance/check.do";
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