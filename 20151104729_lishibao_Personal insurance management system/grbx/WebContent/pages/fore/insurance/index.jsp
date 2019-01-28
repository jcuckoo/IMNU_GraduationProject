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
	<div class="container" style="margin-top: 18px;">
		<div class="row">
			<!-- 左侧菜单开始 -->
			<div class="col-md-2" id="menu_left">
				<div class="list-firstgroup">全部保险类别</div>
				<div class="list-group">
					<c:forEach var="var" items="${insuranceTypeList }">
						<a class="list-group-item ${var.id==insuranceTypeId ? 'active' : '' }" href="${ctx }/insurance/list.html?insuranceType.id=${var.id}">${var.name }</a>
					</c:forEach>
				</div>
			</div>
			<!-- 左侧菜单结束 -->
		
			<div class="col-md-10" id="rightDiv">
				<div class="page-header clearfix" style="margin-top: 10px;">
					<h1 class="pull-left" style="font-size: 20px;padding-bottom: 6px;">${navTitle }</h1>
				</div>
				
				<!-- 内容区域开始 -->
				<div id="context-container">
					<jsp:include page="${mainPage }"/>
				</div>
				<!-- 内容区域结束 -->
			</div>
		</div>
	</div>

	<!-- 底部js begin -->
	<%@ include file="/pages/commons/bottomjs.jsp" %>
	<script type="text/javascript">
		// 立即购买
		function buy(id){
			var url = "${ctx}/check/login.do";
			$.post(url, function(data){
				if (data.resultCode != "SUCCESS") {
					layer.msg("您还没有登录，请先登录！", {icon:5,shift:6,shade:[0.5, '#393D49']});
				}else {
					url = "${ctx}/manage/insurance/buy.do";
					$.post(url, {'id':id}, function(data){
						if (data.resultCode == "SUCCESS") {
							layer.confirm("购买成功，是否查看保单？", {icon:6, btn:['确定', '取消'], title:'系统提示'}, 
								function(){
									window.location.href = "${ctx}/manage/order/list.do";
								}, function(){
									window.location.href = "${ctx}/order/list.html";
								}
							);
						}
					}, 'json');
				}
			}, 'json');
		}
	</script>
	<!-- 底部js end -->
</body>
</html>