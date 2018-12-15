<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/pages/commons/taglibs.jsp" %>
<!-- 菜单库begin -->
<div class="es-box">
	<div class="page-header" style="margin-top: 10px;padding-bottom: 10px;">
		<form class="well well-sm" action="${ctx }/menu/list.html" method="post" id="search-from">
			<div style="float:left;">
				<select class="form-control searchSelect" name="menuType.id">
					<option value="">菜系类别</option>
					<c:forEach var="var" items="${menuTypeList }">
						<option value="${var.id }">${var.name }</option>
					</c:forEach>
				</select>
			</div>
			<div class="input-group input-group-lg">
				<input type="text" class="form-control" name="name" value="" placeholder="请输入喜欢的菜系名..."> 
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
								<span class="price">${var.price }</span>
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
		<!-- 分页begin -->
		<div class="pagination-box">
			<ul class="pagination">
				${pageCode }
		  	</ul>
		</div>
		<!-- 分页end -->
	</div>
</div>
<!-- 菜单库end -->