<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/pages/commons/taglibs.jsp" %>
<div class="es-box">
	<div class="div-title">
		<h3 class="title">
			<span>${menu.name }</span>
			<button class="btn btn-info btn-sm pull-right" onclick="javascript:book('${menu.id}')">
				<i class="glyphicon glyphicon-shopping-cart"></i>&nbsp;预订
			</button>
		</h3>
		<p class="tags">
			<span class="author"><i class="glyphicon glyphicon-user"></i>&nbsp;李锡洋</span>
			<span class="menuType"><i class="glyphicon glyphicon-bookmark"></i>&nbsp;${menu.menuType.name }</span>
			<span class="time"><i class="glyphicon glyphicon-time"></i>&nbsp;<fmt:formatDate value="${menu.createTime }" type="date" pattern="yyyy-MM-dd"/></span>
			<span class="price"><i class="glyphicon glyphicon-registration-mark"></i>&nbsp;${menu.price }元/份</span>
			<span class="price"><i class="glyphicon glyphicon-eye-open"></i>&nbsp;${menu.hitCount }次</span>
		</p>
	</div>
	<div class="div-context">${menu.content }</div>
</div>

<script type="text/javascript">
	// 预订菜单
	function book(id){
		var url = "${ctx}/check/login.do";
		$.post(url, function(data){
			if (data.resultCode != "SUCCESS") {
				layer.msg("您还没有登录，请先登录！", {icon:0,shift:6,shade:[0.5, '#393D49']});
			}else {
				url = "${ctx}/manage/menu/book.do";
				$.post(url, {'id':id}, function(data){
					if (data.resultCode == "SUCCESS") {
						layer.confirm("预订成功，立即结算？", {icon:6, btn:['确定', '取消'], title:'系统提示'}, 
							function(){
								window.location.href = "${ctx}/manage/menu/list.do";
							}, function(){
								window.location.href = "${ctx}/menu/list.html";
							}
						);
					}
				}, 'json');
			}
		}, 'json');
	}
</script>