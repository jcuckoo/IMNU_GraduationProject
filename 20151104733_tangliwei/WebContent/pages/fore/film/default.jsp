<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/pages/commons/taglibs.jsp" %>
<!-- 菜单库begin -->
<div class="es-box">
	<div class="page-header" style="margin-top: 10px;padding-bottom: 10px;">
		<form class="well well-sm" action="${ctx }/film/list.html" method="post" id="search-from">
			<div style="float:left;">
				<select class="form-control searchSelect" name="filmType.id">
					<option value="">电影类别</option>
					<c:forEach var="var" items="${filmTypeList }">
						<option value="${var.id }">${var.name }</option>
					</c:forEach>
				</select>
			</div>
			<div class="input-group input-group-lg">
				<input type="text" class="form-control" name="title" value="" placeholder="请输入喜欢的电影名..."> 
				<span class="input-group-btn">
					<button class="btn btn-primary" type="submit">搜索</button> 
				</span>
			</div>
		</form>
	</div>
	<div class="es-box-body">
		<ul class="es-wide-list">
			<c:forEach var="var" items="${datalist }">
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
		<!-- 分页begin -->
		<div class="pagination-box">
			<ul class="pagination">
				${pageCode }
		  	</ul>
		</div>
		<!-- 分页end -->
	</div>
</div>
<!-- 影视库end -->