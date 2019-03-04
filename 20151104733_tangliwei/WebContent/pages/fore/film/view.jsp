<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<%@ include file="/pages/commons/taglibs.jsp"%>

    <link rel="stylesheet" href="${ctx}/static/depend/videoCT.css">


    <script type='text/javascript' src="${ctx}/static/depend/jquery.min.js"></script>

    <script type='text/javascript' src="${ctx}/static/depend/index.js"></script>
    
    <script type="text/javascript" src="${ctx }/static/js/jsmodern.min.js"></script>
    <link rel="stylesheet" href="${ctx}/static/css/jsmodern.min.css">

</head>
<body>
<div class="es-box">
	<div class="div-context">
		<div>${film.content }<br></div>
		<div id="video" style="width:600px;height: 300px;margin: 0px auto;">
		<input type="hidden" id="shipinUrl" value="${ctx }${film.videoUrl}"/>
			 <video width="100%" height="100%" id="video1" ></video>
		</div>
	</div>
</div>


</body>
</html>