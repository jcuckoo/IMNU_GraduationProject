<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/pages/commons/taglibs.jsp" %>
<ul class="insu-wide-list">
	<c:forEach var="var" items="${datalist }">
		<li class="insu-item clearfix">
			<a href="${ctx }/insurance/view/${var.id}.html" class="insu-picture-link">
				<c:if test="${empty var.coverImg }">
					<img class="insu-picture" src="${ctx }/static/images/default.png" alt="${var.title }">
				</c:if>
				<c:if test="${not empty var.coverImg }">
					<img class="insu-picture" src="${ctx }/${var.coverImg}" alt="${var.title }">
				</c:if>
			</a>
			<div class="insu-body">
				<div style="float:right;" class="text-muted">
					<span class="insu-price-widget"> 
						<span class="price">发布时间：<fmt:formatDate value="${var.createTime }" type="date" pattern="yyyy年MM月dd日 HH:mm"/></span>
					</span>
				</div>
				<h4 class="course-title">
					<a href="${ctx }/insurance/view/${var.id}.html">${var.title }</a>
				</h4>
				<div class="insu-about">
					简介：
					<c:if test="${empty var.summary }">暂无介绍！</c:if>
					<c:if test="${not empty var.summary }">${var.summary }...</c:if>
				</div>
				<div class="insu-footer clearfix">
					<div class="insu-metas">
						<span>期限：<strong>${var.dueTime }</strong> 年</span>
						<span class="divider"></span>
						<a href="javascript:buy(${var.id });" class="btn btn-info btn-sm">立即购买</a>
						<a href="${ctx }/insurance/view/${var.id}.html" class="btn btn-primary btn-sm">查看详情</a>
					</div>
				</div>
			</div>
		</li>
	</c:forEach>
</ul>
<!-- 分页begin -->
<div class="pagination-box">
	<ul class="pagination">${pageCode }</ul>
</div>
<!-- 分页end -->