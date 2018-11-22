<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${pageTitle }</title>
<%@ include file="/pages/commons/taglibs.jsp" %>
<%@ include file="/pages/commons/top.jsp" %>
<%@ include file="/pages/back_top.jsp" %>
<link href="${ctx}/static/css/style.css?${random}" rel="stylesheet" />
</head>
<body>
	<!-- 导航栏 -->
	<jsp:include page="/pages/menu_top.jsp"/>
	
	<!-- 登录 -->
	<div class="container es-row-wrap">
		<div class="col-md-8 col-md-offset-2" style="padding-top: 65px;padding-bottom: 35px;">
			<div class="row">
				<div class="col-md-2"></div>
				<div class="col-md-8" align="center" id="search-box">
					<div class="input-group">
						<input type="text" class="form-control input-lg" id="cityName" placeholder="请输入要搜索的城市名...">
						<span class="input-group-addon btn btn-info" id="search">搜索一下</span>
					</div>
				</div>
				<div class="col-md-2"></div>
			</div>
			<div class="row" style="margin: 65px 10px 0px;">
				<div class="es-box">
					<div class="es-box-heading">
						<h2>最近三天</h2>
					</div>
					<div class="es-box-body">
						<c:if test="${not empty datalist }">
							<ul class="es-ul-grids">
								<c:forEach var="var" items="${datalist }">
									<li class="es-li-grid">
										<a class="grid-body" href="javascript:void(0);" data-url="${ctx }/view/${var.id}.html"
											data-toggle="modal" data-target="#modal">
											<c:if test="${var.state == 0 }">
												<img class="img-responsive thumb" src="${ctx }/static/images/sunny.png" />
											</c:if>
											<c:if test="${var.state == 1 }">
												<img class="img-responsive thumb" src="${ctx }/static/images/rainy.png" />
											</c:if>
											<c:if test="${var.state == 2 }">
												<img class="img-responsive thumb" src="${ctx }/static/images/snow.png" />
											</c:if>
											<c:if test="${var.state == 3 }">
												<img class="img-responsive thumb" src="${ctx }/static/images/light.png" />
											</c:if>
											<span class="title">${var.cityName }
												<span class="pull-right">${var.date }</span>
											</span>
											<span class="metas clearfix">
												<div class="info-block">
													<span class="es-info-widget">
														<span class="info">
															<span class="info">${var.condTxtD }</span>
														</span>
													</span>
												</div>
												<span class="review-col pull-left" style="text-align: left;"> 
													<span class="meta-label">
														<strong>风向：${var.windDir }</strong>
													</span> 
													<span class="review-rating" style="margin-top: 4px;display: block;">  
														<span>风力：${var.windSc }</span> 
													</span> 
												</span>
												<span class="span-col"> 
													<span class="meta-label">降水量：${var.pcpn }</span> 
													<span class="span-num">可见度：${var.vis }</span>
												</span>
											</span>
										</a>
									</li>
								</c:forEach>
							</ul>
						</c:if>
						<c:if test="${empty datalist}">
							<ul class="media-list conversation-list">
								<li class="empty">未查询到相关信息，换个城市名试试！</li>
							</ul>
						</c:if>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	
	
	
	<%@ include file="/pages/commons/bottomjs.jsp" %>
	<script type="text/javascript">
		$(function(){
			$("#search").click(function(){
				var cityName = $("#cityName").val().trim();
				if (cityName == null || cityName == "") {
					layer.msg("请输入要搜索的城市名！", {icon:0, shift:6, shade:[0.5, '#393D49']});
					return;
				}
				window.location.href = "${ctx}/search.html?cityName=" + cityName;
			});
		});
	</script>
</body>
</html>