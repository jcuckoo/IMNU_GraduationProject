<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/pages/commons/taglibs.jsp"%>

<div class="modal-dialog">
	<div class="modal-content">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			<h4 class="modal-title">${weather.cityName }天气信息详情</h4>
		</div>
		<div class="modal-body">
			<table class="table table-bordered">
				<tr>
			  		<td>日期：</td>
			  		<td>${weather.date }</td>
			  	</tr>
			  	<tr>
			  		<td>最高温度：</td>
			  		<td>${weather.tmpMax }度</td>
			  	</tr>
			  	<tr>
			  		<td>最低温度：</td>
			  		<td>${weather.tmpMin }度</td>
			  	</tr>
			  	<tr>
			  		<td>白天天气状况：</td>
			  		<td>${weather.condTxtD }</td>
			  	</tr>
			  	<tr>
			  		<td>夜间天气状况：</td>
			  		<td>${weather.condTxtN }</td>
			  	</tr>
			  	<tr>
			  		<td>风向：</td>
			  		<td>${weather.windDir }</td>
			  	</tr>
			  	<tr>
			  		<td>风力：</td>
			  		<td>${weather.windSc }</td>
			  	</tr>
			  	<tr>
			  		<td>降水量：</td>
			  		<td>${weather.hum }</td>
			  	</tr>
			  	<tr>
			  		<td>可见度：</td>
			  		<td>${weather.vis }</td>
			  	</tr>
			  	<tr>
			  		<td>温馨提示：</td>
			  		<td>
			  			<c:if test="${weather.tmpMax > 30 }">高温天气，请预防中暑，尽量避免长期进行户外活动！</c:if>
			  			<c:if test="${weather.tmpMin < 12 }">天气转凉，请注意增加衣服，预防生病感冒！</c:if>
			  			<c:if test="${weather.tmpMin >= 12 and weather.tmpMax <= 30 }">天气状况舒适！</c:if>
			  		</td>
			  	</tr>
			</table>
		</div>
		<div class="modal-footer">
			<button type="button" class="btn btn-link" data-dismiss="modal">关闭</button>
		</div>
	</div>
</div>
