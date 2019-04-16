<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/pages/commons/taglibs.jsp" %>
<link rel="stylesheet" href="${ctx}/static/css/jsmodern.min.css">
<script type="text/javascript" src="${ctx }/static/js/jsmodern.min.js"></script>
<div class="es-box">
	<div class="div-title">
		<h3 class="title">
			<span>${film.title }</span>
		</h3>
		<p class="tags">
			<span class="author"><i class="glyphicon glyphicon-user"></i>&nbsp;${film.creator.truename }</span>
			<span class="menuType"><i class="glyphicon glyphicon-bookmark"></i>&nbsp;${film.filmType.name }</span>
			<span class="time"><i class="glyphicon glyphicon-time"></i>&nbsp;<fmt:formatDate value="${film.createTime }" type="date" pattern="yyyy-MM-dd"/></span>
			<span class="price"><i class="glyphicon glyphicon-registration-mark"></i>&nbsp;${film.vip eq true ? 'VIP' : '免费' }</span>
			<span class="price"><i class="glyphicon glyphicon-eye-open"></i>&nbsp;${film.clickCount }次</span>
		</p>
	</div>
	<div class="div-context">
		<div>${film.content }<br></div>
		<div id="video" style="width:720px;height: 340px;margin: 0 auto;">
			<video src="${ctx }${film.videoUrl}"></video>
		</div>
	</div>
</div>
<script type="text/javascript">
	$(function(){
		jsModern.video("#video");
	});
</script>