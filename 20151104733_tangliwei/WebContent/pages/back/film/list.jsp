<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>电影管理-滨海影视网</title>
<%@ include file="/pages/commons/taglibs.jsp"%>
<%@ taglib uri='/tag/page-tags' prefix='p'%>
<%@ include file="/pages/commons/top.jsp" %>
<script type="text/javascript">
	var Query = "${ctx}/manage/film/contextlist.do";
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
							<span class="glyphicon glyphicon-home"></span> 首页 &gt; 电影管理
						</h1>
						<div class="pull-right">
							<a class="btn btn-primary btn-sm" href="${ctx }/manage/film/edit.do">
								<span class="glyphicon glyphicon-plus"></span> 新增
							</a>
						</div>
					</div>
					
					<!-- 搜索栏 begin -->
					<div class="well well-sm">
						<div class="form-inline">
							<div class="form-group">
								<input type="text" id="search_title" name="search_title" class="form-control" placeholder="电影名称" value="">
							</div>
							<div class="form-group">
								<select class="form-control" name="search_typeId" id="search_typeId" >
									<option value="" selected="selected">--全部类别--</option>
									<c:forEach items="${filmTypeList }" var="filmType">
										<option value="${filmType.id }">${filmType.name }</option>
									</c:forEach>
								</select>
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
	<script>app.controller='film/list';</script>
	<script type="text/javascript">
		// 审核电影
		function push(id){
			layer.confirm("您确定要通过审核吗？", {title:'系统提示', icon:3}, function(){
				var url = "${ctx}/manage/film/push.do";
				$.post(url, {'id':id}, function(resp){
					if (resp.resultCode == "SUCCESS") {
						layer.msg("审核成功！", {icon:6});
						createPageList(1);
					}else {
						layer.msg(resp.message, {icon:5});
					}
				}, 'json');
			});
		}
	</script>
</body>
</html>