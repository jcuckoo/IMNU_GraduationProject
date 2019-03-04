<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${pageTitle }</title>
<%@ include file="/pages/commons/taglibs.jsp"%>
<%@ include file="/pages/commons/top.jsp"%>
</head>
<body>
	<!-- 头部begin -->
	<%@ include file="/pages/fore/menu_top.jsp" %>
	<!-- 头部end -->
	
	<!-- 内容区begin -->
	<div id="content-container" class="container">
		<div class="es-row-wrap container-gap" id="context-homepage">
			<div class="row">
				<div class="col-md-12">
					<div class="page-header">
						<h1 style="margin-bottom: 8px;">${navTitle }</h1>
					</div>
				</div>
			</div>
			
			<div class="row row-9-3">
				<div class="div-title" >
					<h3 class="title">
						<span>${film.title }</span>
					</h3>
					<p class="tags" >
						<span class="author"><i class="glyphicon glyphicon-user"></i>&nbsp;${film.creator.truename }</span>
						<span class="menuType"><i class="glyphicon glyphicon-bookmark"></i>&nbsp;${film.filmType.name }</span>
						<span class="time"><i class="glyphicon glyphicon-time"></i>&nbsp;<fmt:formatDate value="${film.createTime }" type="date" pattern="yyyy-MM-dd"/></span>
						<span class="price"><i class="glyphicon glyphicon-registration-mark"></i>&nbsp;${film.vip eq true ? 'VIP' : '免费' }</span>
						<span class="price"><i class="glyphicon glyphicon-eye-open"></i>&nbsp;${film.clickCount }次</span>
					</p>
				</div>
				
				<div class="col-sm-9">
					<jsp:include page="${mainPage }"/>
				</div>
				
			</div>
		</div>
	</div>
	<!-- 内容区end -->

	<!-- 底部js begin -->
	<%@ include file="/pages/commons/bottomjs.jsp" %>
	<script>app.controller="index/index";</script>
	<!-- 底部js end -->
</body>
</html>





				
