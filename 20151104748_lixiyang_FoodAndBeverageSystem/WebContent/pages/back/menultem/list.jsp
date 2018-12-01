<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>菜单管理-新食尚餐饮系统</title>
<%@ include file="/pages/commons/taglibs.jsp"%>
<%@ taglib uri='/tag/page-tags' prefix='p'%>
<%@ include file="/pages/commons/top.jsp" %>
<script type="text/javascript">
	var Query = "${ctx}/manage/menuItem/contextlist.do";
</script>
</head>
<body>
	<!-- 头部begin -->
	<%@ include file="/pages/back/header.jsp" %>
	<!-- 头部end -->
	
	<!-- 内容区begin -->
	<div class="container">
		<div class="es-row-wrap container-gap">
			<div class="row">
				<div class="col-md-12" id="rigthContextDiv">
					<div class="page-header clearfix" style="margin-top: 15px;">
						<h1 class="pull-left" style="margin-bottom: 4px; font-size: 18px;">
							<span class="glyphicon glyphicon-home"></span> 首页 &gt; 菜单管理
						</h1>
					</div>
					
					<!-- 搜索栏 begin -->
					<div class="well well-sm">
						<div class="form-inline">
							<div class="form-group">
								<input type="text" id="menuName" name="menuName" class="form-control" placeholder="菜单名" value="">
							</div>
							<a type="submit" class="btn btn-primary" onclick="createPageList(1)">搜索</a>
						</div>
					</div>
					<!-- 搜索栏  end -->
					<div id="context-table-container" style="min-height: 340px; margin-bottom: 10px;">
					
					</div>
				</div>
			</div>
		</div>
	</div>			
	<!-- 底部begin -->
	<%@ include file="/pages/commons/bottomjs.jsp" %>
	<script>app.controller='menuItem/list';</script>
	<script type="text/javascript">
		// 取消预订
		function cancelOrder(id) {
			layer.confirm("您确定要取消预订吗？", {icon:3, btn:['确定', '取消'], title:'系统提示'}, function(){
				var url = "${ctx}/manage/menuItem/delete.do";
				$.post(url, {'id':id}, function(data){
					if (data.resultCode == "SUCCESS") {
						layer.msg("成功取消预订！", {icon:6,shade:[0.4,'#000']});
						createPageList(1);
					}
				}, 'json');
			});
		}
	</script>
</body>
</html>