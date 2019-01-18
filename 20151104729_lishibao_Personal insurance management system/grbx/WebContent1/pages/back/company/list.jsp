<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>${pageTitle }</title>
<%@ include file="/pages/commons/taglibs.jsp"%>
<%@ taglib uri='/tag/page-tags' prefix='p'%>
<%@ include file="/pages/commons/top.jsp" %>
<script type="text/javascript">
	var Query = "${ctx}/manage/company/contextlist.do";
</script>
</head>
<body>
	<!-- 头部begin -->
	<%@ include file="/pages/back/header.jsp" %>
	<!-- 头部end -->
	
	<!-- 内容区begin -->
	<div class="container" style="margin-top: 75px;">
		<div class="es-row-wrap container-gap">
			<div class="row">
				<div class="col-md-12" id="rigthContextDiv">
					<div class="page-header clearfix" style="margin-top: 15px;">
						<h1 class="pull-left" style="margin-bottom: 4px; font-size: 18px;">
							<span class="glyphicon glyphicon-home"></span> 首页 &gt; 保险公司管理
						</h1>
						<div class="pull-right">
							<a class="btn btn-primary btn-sm" href="javascript:void();" data-url="${ctx }/manage/company/edit.do" 
								data-toggle="modal" data-target="#modal">
								<span class="glyphicon glyphicon-edit"></span> 新增
							</a>
						</div>
					</div>
					
					<!-- 搜索栏 begin -->
					<div class="well well-sm">
						<div class="form-inline">
							<div class="form-group">
								<input type="text" id="search_number" class="form-control" placeholder="公司编号">
							</div>
							<div class="form-group">
								<input type="text" id="search_name" class="form-control" placeholder="公司名称">
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
	<script>app.controller='company/list';</script>
</body>
</html>