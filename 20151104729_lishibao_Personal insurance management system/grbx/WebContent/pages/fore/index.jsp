<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${pageTitle }</title>
<%@ include file="/pages/commons/taglibs.jsp"%>
<%@ include file="/pages/commons/top.jsp"%>
</head>
<body style="padding: 0px;">
	<!-- 头部begin -->
	<%@ include file="/pages/fore/menu_top.jsp" %>
	<!-- 头部end -->
	<!-- 内容区begin -->
	<div id="banner-container">
		<div class="homepage-feature homepage-feature-slides" style="position: relative; overflow: hidden;">
			<a href="#" target="_blank" class="cycle-slide" style="position: static; top: 0px; left: 0px; z-index: 97; opacity: 1; display: block; ">
				<img src="${ctx }/static/images/slider/slider1.jpg" alt="首页轮播图一" >
			</a>
			<a href="#" target="_blank" class="cycle-slide" style="position: absolute; top: 0px; left: 0px; z-index: 97; opacity: 1; display: none; ">
				<img src="${ctx }/static/images/slider/slider2.jpg" alt="首页轮播图二">
			</a>
			<a href="#" target="_blank" class="cycle-slide" style="position: absolute; top: 0px; left: 0px; z-index: 97; opacity: 1; display: none; ">
				<img src="${ctx }/static/images/slider/slider3.jpg" alt="首页轮播图三">
			</a>
			<a href="#" target="_blank" class="cycle-slide" style="position: absolute; top: 0px; left: 0px; z-index: 97; opacity: 1; display: none; ">
				<img src="${ctx }/static/images/slider/slider4.jpg" alt="首页轮播图三">
			</a>
			<a href="#" target="_blank" class="cycle-slide" style="position: absolute; top: 0px; left: 0px; z-index: 97; opacity: 1; display: none; ">
				<img src="${ctx }/static/images/slider/slider5.jpg" alt="首页轮播图三">
			</a>
		</div>
		<div class="cycle-pager">
			<span class="cycle-pager-active">•</span>
			<span class="">•</span>
			<span class="">•</span>
			<span class="">•</span>
			<span class="">•</span>
		</div>
	</div>
	<div class="container">
		<div class="hot-title row">
			<span class="span-left"></span>
			<span class="span-center">
				热卖推荐
				<span class="point">·</span>
				<span class="end">HOT RECOMMENDATION</span>
			</span>
			<span class="span-right"></span>
		</div>
		<div class="row">
			<c:forEach var="var" items="${insuranceList }" varStatus="status">
				<div class="col-sm-3 col-md-3 col-lg-3 es-row">
					<div class="thumbnail" style="height: 300px;position: relative;">
						<a href="${ctx }/insurance/view/${var.id}.html">
							<c:if test="${empty var.coverImg }">
								<img src="${ctx }/static/images/use0${status.index%2+1 }.jpg" style="width: 300px;height: 200px;">
							</c:if>
							<c:if test="${not empty var.coverImg }">
								<img src="${ctx }/${var.coverImg}" style="width: 300px;height: 200px;">
							</c:if>
						</a>
						<div class="type-tag">
							<p class="type-text">${var.insuranceType.name }</p>
						</div>
						<div class="shade">
							<a href="${ctx }/insurance/view/${var.id}.html" class="up-shade"></a>
							<div class="caption">
								<span class="cap-span">${var.title }</span>
								<span class="num">
		                            <span class="small">￥</span>
		                            <span>${var.money }</span>
		                            <span class="qi">起</span>
		                        </span>
		                        <a href="${ctx }/insurance/view/${var.id}.html" class="check">查看详情</a>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="link-box">
				<p class="p_link">合作伙伴
	                <span class="point">·</span>
	                <span class="wall">BRAND&nbsp;WALL</span>
	            </p>
			</div>
			<div class="blank">
				<ul class="bank_list fix">
                    <li>
                        <div class="logo_bank">
                            <a href="#"><img src="${ctx}/static/images/blank/bank01.png" alt="中国人寿"></a>
                        </div>
                        <div class="logo_bank">
                            <a href="#"><img src="${ctx}/static/images/blank/bank02.png" alt="渤海人寿"></a>
                        </div>
                    </li>
                    <li>
                        <div class="logo_bank">
                            <a href="#"><img src="${ctx}/static/images/blank/bank03.png" alt="安顺人寿"></a>
                        </div>
                        <div class="logo_bank">
                            <a href="#"><img src="${ctx}/static/images/blank/bank04.png" alt="国华人寿"></a>
                        </div>
                    </li>
                    <li>
                        <div class="logo_bank">
                            <a href="#"><img src="${ctx}/static/images/blank/bank05.png" alt="恒大人寿"></a>
                        </div>
                        <div class="logo_bank">
                            <a href="#"><img src="${ctx}/static/images/blank/bank06.png" alt="弘康人寿"></a>
                        </div>
                    </li>
                    <li>
                        <div class="logo_bank">
                            <a href=" #"><img src="${ctx}/static/images/blank/bank07.png" alt="华泰保险"></a>
                        </div>
                        <div class="logo_bank">
                            <a href="#"><img src="${ctx}/static/images/blank/bank08.png" alt="昆仑健康保险"></a>
                        </div>
                    </li>
                    <li>
                        <div class="logo_bank">
                            <a href="#"><img src="${ctx}/static/images/blank/bank09.png" alt="平安健康"></a>
                        </div>
                        <div class="logo_bank">
                            <a href="#"><img src="${ctx}/static/images/blank/bank10.png" alt="前海人寿"></a>
                        </div>
                    </li>
                    <li>
                        <div class="logo_bank">
                            <a href=" #"><img src="${ctx}/static/images/blank/bank11.png" alt="中国人民保险"></a>
                        </div>
                        <div class="logo_bank">
                            <a href=" #"><img src="${ctx}/static/images/blank/bank12.png" alt="泰康在线"></a>
                        </div>
                    </li>
                    <li>
                        <div class="logo_bank">
                            <a href=" #"><img src="${ctx}/static/images/blank/bank13.png" alt="阳光保险"></a>
                        </div>
                        <div class="logo_bank">
                            <a href=" #"><img src="${ctx}/static/images/blank/bank14.png" alt="珠江人寿"></a>
                        </div>
                    </li>
                </ul>
			</div>
		</div>
	</div>
	<!-- 内容区end -->
	<!-- 底部begin -->
	<div class="copyright">
		<div class="container footer">
            <div class="footer_nav pull-left">
                <p>
                    <a href="${ctx }/aboutus.html">关于大特保保险</a>
                    <span class="divider">|</span>
                    <a href="javascript:void(0);">联系我们</a>
                    <span class="divider">|</span>
                    <a href="javascript:void(0);">免责声明</a>
                </p>
                <p>Copyright © 2018-2028 大特保保险 版权所有<span class="divider">|</span>投资有风险，购买需谨慎</p>
            </div>
            <div class="footer_contact pull-right">
                <div class="f_contact_time">
                                                 联系我们<span>（09:00-22:00）</span>
                </div>
                <div class="f_contact_content">
                    <div class="f_cc_left">
                        <span class="f_cc_item">个人业务：400-098-8511</span>
                        <span class="f_cc_item">企业业务：400-088-8816</span>
                    </div>
                </div>
            </div>
        </div>
	</div>
	<!-- 底部end -->
	<!-- 底部js begin -->
	<%@ include file="/pages/commons/bottomjs.jsp" %>
	<script>app.controller="index/index";</script>
	<!-- 底部js end -->
</body>
</html>





				
