<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/pages/commons/taglibs.jsp" %>
<div class="es-box">
	<div class="div-title">
		<h3 class="title">
			<span>${insurance.title }</span>
			<button class="btn btn-info btn-sm pull-right" onclick="javascript:buy('${insurance.id}')">
				<i class="glyphicon glyphicon-shopping-cart"></i>&nbsp;立即购买
			</button>
		</h3>
		<p class="tags">
			<span class="author"><i class="glyphicon glyphicon-user"></i>&nbsp;${insurance.company.name }</span>
			<span class="insuranceType"><i class="glyphicon glyphicon-bookmark"></i>&nbsp;${insurance.insuranceType.name }</span>
			<span class="time"><i class="glyphicon glyphicon-time"></i>&nbsp;<fmt:formatDate value="${insurance.createTime }" type="date" pattern="yyyy-MM-dd"/></span>
			<span class="price"><i class="glyphicon glyphicon-registration-mark"></i>&nbsp;${insurance.money }元</span>
			<span class="dueTime"><i class="glyphicon glyphicon-dashboard"></i>&nbsp;期限：${insurance.dueTime }年</span>
		</p>
	</div>
	<div class="div-context">${insurance.content }</div>
</div>