<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/pages/commons/taglibs.jsp" %>
<!-- 推荐电影begin -->
<div class="es-box">
	<div class="es-box-heading">
		<h2>推荐电影</h2>
		<a class="pull-right" href="${ctx }/film/list.html">更多&gt;</a>
	</div>
	<div class="es-box-body">
		<ul class="es-ul-grids">
			<c:forEach var="var" items="${groomFilmList }">
				<li class="es-li-grid">
					<a href="javascript:view('${var.id }');" class="grid-body">
						<c:choose>
							<c:when test="${empty var.coverImg }">
								<img src="${ctx }/static/images/default.jpg" class="img-responsive thumb">
							</c:when>
							<c:otherwise>
								<img src="${ctx }/${var.coverImg}" class="img-responsive thumb">
							</c:otherwise>
						</c:choose>
						<span class="title">${var.title }</span> 
						<span class="metas clearfix">
							<div class="price-block">
								<span class="price-widget"> 
									<span class="price">
										<span class="price">${var.vip eq true ? 'VIP' : '免费' }</span>
									</span> 
								</span>
							</div> 
							<span class="review-col pull-left" style="text-align: left;"> 
								<span class="meta-label"><strong>${var.clickCount }</strong>次预览</span> 
								<span class="review-rating">
									<span class="stars-${var.score }">&nbsp;</span> 
								</span> 
							</span> 
							<span class="num-col"> 
								<span class="meta-label">上传者</span> 
								<span class="span-num">${var.creator.truename }</span>
							</span> 
						</span> 
					</a>
				</li>
			</c:forEach>
		</ul>
	</div>
</div>
<!-- 推荐电影end -->

<!-- 最新电影begin -->
<div class="es-box">
	<div class="es-box-heading">
		<h2>最新电影</h2>
		<a class="pull-right" href="${ctx }/film/list.html">更多&gt;</a>
	</div>
	<div class="es-box-body">
		<ul class="es-wide-list">
			<c:forEach var="var" items="${newestFilmList }">
				<li class="es-li-item clearfix">
					<a class="es-picture-link" href="javascript:view('${var.id }');">
						<c:choose>
							<c:when test="${empty var.coverImg }">
								<img class="es-picture" src="${ctx }/static/images/default.jpg" alt="${var.title }">								
							</c:when>
							<c:otherwise>
								<img class="es-picture" src="${ctx }/${var.coverImg}" alt="${var.title }">
							</c:otherwise>
						</c:choose>
					</a>
					<div class="es-body">
						<div class="es-price-info">
							<span class="es-price-widget">
								<span class="price">${var.vip eq true ? 'VIP' : '免费' }</span>
							</span>
						</div>
						<h4 class="es-title">
							<a href="javascript:view('${var.id }');">${var.title }</a>
						</h4>
						<div class="es-about ellipsis">简介：${var.summary }</div>
						<div class="es-footer clearfix">
							<div class="es-div">
								<a href="javascript:void(0);">
									<img src="${ctx }/static/images/default.jpg" class="es-avatar"> 
								</a> 
								<a class="a-nickname ellipsis" href="javascript:void(0);">上传者</a>
								<span class="span-title ellipsis">${var.creator.truename}</span>
							</div>
							<div class="es-metas">
								<span class="stars-${var.score }">&nbsp;</span> 
								<span class="divider"></span> 
								<span class="text-muted mrm mls"><strong>${var.clickCount } </strong>次预览</span>
							</div>
						</div>
					</div>
				</li>
			</c:forEach>
		</ul>
	</div>
</div>
<!-- 最新电影end -->