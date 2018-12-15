<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/pages/commons/taglibs.jsp" %>
<!-- 推荐菜系begin -->
<div class="es-box">
	<div class="es-box-heading">
		<h2>推荐菜系</h2>
		<a class="pull-right" href="${ctx }/menu/list.html">更多&gt;</a>
	</div>
	<div class="es-box-body">
		<ul class="es-ul-grids">
			<c:forEach var="var" items="${groomMenuList }">
				<li class="es-li-grid">
					<a href="${ctx }/menu/view/${var.id}.html" class="grid-body">
						<c:choose>
							<c:when test="${empty var.coverImg }">
								<img src="${ctx }/static/images/default.jpg" class="img-responsive thumb">
							</c:when>
							<c:otherwise>
								<img src="${ctx }/${var.coverImg}" class="img-responsive thumb">
							</c:otherwise>
						</c:choose>
						<span class="title">${var.name }</span> 
						<span class="metas clearfix">
							<div class="price-block">
								<span class="price-widget"> 
									<span class="price">
										<span class="price">${var.price } 元/份</span>
									</span> 
								</span>
							</div> 
							<span class="review-col pull-left" style="text-align: left;"> 
								<span class="meta-label"><strong>${var.hitCount }</strong>次预览</span> 
								<span class="review-rating">
									<span class="stars-${var.score }">&nbsp;</span> 
								</span> 
							</span> 
							<span class="num-col"> 
								<span class="meta-label">销量</span> 
								<span class="span-num">${var.buyCount }份</span>
							</span> 
						</span> 
					</a>
				</li>
			</c:forEach>
		</ul>
	</div>
</div>
<!-- 推荐菜系end -->

<!-- 最新菜系begin -->
<div class="es-box">
	<div class="es-box-heading">
		<h2>最新菜系</h2>
		<a class="pull-right" href="${ctx }/menu/list.html">更多&gt;</a>
	</div>
	<div class="es-box-body">
		<ul class="es-wide-list">
			<c:forEach var="var" items="${newestMenuList }">
				<li class="es-li-item clearfix">
					<a class="es-picture-link" href="${ctx }/menu/view/${var.id}.html">
						<c:choose>
							<c:when test="${empty var.coverImg }">
								<img class="es-picture" src="${ctx }/static/images/default.jpg" alt="${var.name }">								
							</c:when>
							<c:otherwise>
								<img class="es-picture" src="${ctx }/${var.coverImg}" alt="${var.name }">
							</c:otherwise>
						</c:choose>
					</a>
					<div class="es-body">
						<div class="es-price-info">
							<span class="es-price-widget">
								<span class="price">${var.price } 元/份</span>
							</span>
						</div>
						<h4 class="es-title">
							<a href="${ctx }/menu/view/${var.id}.html">${var.name }</a>
						</h4>
						<div class="es-about ellipsis">${var.menuType.name }</div>
						<div class="es-footer clearfix">
							<div class="es-div">
								<a href="javascript:void(0);">
									<img src="${ctx }/static/images/default.jpg" class="es-avatar"> 
								</a> 
								<a class="a-nickname ellipsis" href="javascript:void(0);">销量</a>
								<span class="span-title ellipsis">${var.buyCount }份</span>
							</div>
							<div class="es-metas">
								<span class="stars-${var.score }">&nbsp;</span> 
								<span class="divider"></span> 
								<span class="text-muted mrm mls"><strong>${var.hitCount } </strong>次预览</span>
							</div>
						</div>
					</div>
				</li>
			</c:forEach>
		</ul>
	</div>
</div>
<!-- 最新菜系end -->