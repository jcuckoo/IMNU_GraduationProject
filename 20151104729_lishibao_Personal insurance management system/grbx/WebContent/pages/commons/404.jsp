<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ include file="/pages/commons/taglibs.jsp"%>
<%@ taglib uri='/tag/page-tags' prefix='p'%>

<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="">
<!--<![endif]-->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="renderer" content="webkit">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta content="155c38cf7b586cb0ba16cedfd83f4324d7563c48" name="csrf-token">
<title>出错!-个人保险系统</title>
<%@ include file="top.jsp"%>
<style type="text/css">
#page body {margin: auto; padding:0px; font-family:"微软雅黑", Arial, "Trebuchet MS", Verdana, Georgia,Baskerville,Palatino,Times; font-size:16px;}
#page div{margin-left:auto; margin-right:auto;}
#page a {text-decoration: none; color: #1064A0;}
#page a:hover {color: #0078D2;}
img { border:none; }
#page h1,h2,h3,h4 {
/*	display:block;*/
	margin:0;
	font-weight:normal; 
	font-family: "微软雅黑", Arial, "Trebuchet MS", Helvetica, Verdana ; 
}
#page h1{font-size:44px; color:#0188DE; padding:20px 0px 10px 0px;}
#page h2{color:#0188DE; font-size:16px; padding:10px 0px 40px 0px;}
#page{width:80%; padding:20px 20px 40px 20px; margin-top:80px;margin-left: auto;margin-right: auto;}
.button{width:180px; height:28px; margin-left:0px; margin-top:10px; background:#009CFF; border-bottom:4px solid #0188DE; text-align:center;}
.button a{width:180px; height:28px; display:block; font-size:14px; color:#fff; }
.button a:hover{ background:#5BBFFF;}
</style>

</head>
<body>
	<!-- 头部begin -->
	<%@ include file="/pages/fore/menu_top.jsp" %>
	<!-- 头部end -->

	<div id="page" style="border-style:dashed;border-color:#e4e4e4;line-height:30px;background:url(sorry.png) no-repeat right;">
		<h1>抱歉，出错，或者找不到此页面~</h1>
		<h2>Sorry, the site now can not be accessed. </h2>
		<font color="#666666">你请求访问的页面，暂时找不到，或者出现错误，我们建议你返进行浏览，谢谢！</font><br /><br />
		<div class="button">
			<a href="<%=path %>/index.html" title="返回首页">返回首页</a>
		</div>
	</div>

	<%@ include file="bottomjs.jsp"%>
</body>

</html>

