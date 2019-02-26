<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<c:set var="ctx" value="<%=path%>" />
<c:set var="contextPath" value="<%=basePath%>" />
<c:set var="hostName" value="127.0.0.1" />
<c:set var="hostPort" value="8080" />
<c:set var="random" value="1.1.5" />
