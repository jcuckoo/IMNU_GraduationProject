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
			<!-- 轮播图begin -->
			<div class="homepage-feature homepage-feature-slides mbl" style="position: relative; overflow: hidden;">
				<a href="#" target="_blank" class="cycle-slide" style="position: static; top: 0px; left: 0px; z-index: 97; opacity: 1; display: block; ">
					<img src="${ctx }/static/images/banner/ad1.png" alt="首页轮播图一" >
				</a>
				<a href="#" target="_blank" class="cycle-slide" style="position: absolute; top: 0px; left: 0px; z-index: 97; opacity: 1; display: none; ">
					<img src="${ctx }/static/images/banner/ad2.png" alt="首页轮播图二">
				</a>
				<a href="#" target="_self" class="cycle-slide" style="position: absolute; top: 0px; left: 0px; z-index: 97; opacity: 1; display: none; ">
					<img src="${ctx }/static/images/banner/ad3.png" alt="首页轮播图三">
				</a>
			</div>
			<div class="cycle-pager">
				<span class="cycle-pager-active">•</span>
				<span class="">•</span>
				<span class="">•</span>
			</div>
			<!-- 轮播图end -->
			
			<!-- 精彩分享begin -->
			<div class="homepage-share-nav">精彩影片分享</div>
			<!-- 精彩分享end -->
			
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





				
