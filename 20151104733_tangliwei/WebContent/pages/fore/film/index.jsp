<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
				<div class="col-sm-9">
					<jsp:include page="${mainPage }"/>
				</div>
				<div class="col-sm-3">
					<div class="es-box es-tag">
						<div class="es-box-heading">
							<h2>电影类别</h2>
						</div>
						<div class="es-box-body">
							<div class="tag-list">
								<c:forEach var="var" items="${filmTypeCountList }">
									<a href="${ctx }/film/list.html?filmType.id=${var.id}">${var.name }(${var.filmCount })</a>
								</c:forEach>
							</div>
						</div>
					</div>
					<div class="es-box es-rank">
						<div class="es-box-heading">
							<h2>热门电影</h2>
						</div>
						<div class="es-box-body">
							<ul class="media-list">
								<c:forEach var="var" items="${hotFilmList }">
									<li class="media">
										<a href="javascript:view('${var.id }');">
											<div class="es-item">
												<c:choose>
													<c:when test="${empty var.coverImg }">
														<img alt="${var.title }" src="${ctx }/static/images/default.jpg" class="img-responsive thumb pull-left">														
													</c:when>
													<c:otherwise>
														<img alt="${var.title }" src="${ctx }/${var.coverImg}" class="img-responsive thumb pull-left">
													</c:otherwise>
												</c:choose>
												<div class="es-title" style="line-height:32px">${var.title }</div>
											</div>
										</a>
									</li>
								</c:forEach>
							</ul>
						</div>
					</div>
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





				
