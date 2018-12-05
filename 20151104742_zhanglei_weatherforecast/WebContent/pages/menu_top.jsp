<%@ page language='java' import='java.util.*' pageEncoding='utf-8'%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/pages/commons/taglibs.jsp" %>
<div class="navbar navbar-inverse navbar-fixed-top site-navbar">
	<div class="container">
    	<div class="navbar-header">
        	<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
	          	<span class="icon-bar"></span>
	          	<span class="icon-bar"></span>
	          	<span class="icon-bar"></span>
        	</button>
        	<a class="navbar-brand" href="${ctx }/index.do">
        		<img src="${ctx}/static/images/icon/logo.png" />
        	</a>
      	</div>
      	<div class="navbar-collapse collapse">
			<ul class="nav navbar-nav navbar-right" id="navbar-right">
				<li>
					<a href="${ctx }/index.html">
						<span class="glyphicon glyphicon-home"></span>&nbsp;返回主页
					</a>
				</li>
				<c:if test="${empty currentUser }">
					<li>
						<a href="javascript:void(0);" data-url="${ctx }/tologin.html" data-toggle="modal" data-target="#modal">
							<span class="glyphicon glyphicon-log-in"></span>&nbsp;登录
						</a>
					</li>
					<li>
						<a href="${ctx }/toregister.html">
							<span class="glyphicon glyphicon-registration-mark"></span>&nbsp;注册
						</a>
					</li>
				</c:if>
				<c:if test="${not empty currentUser }">
					<li class="dropdown">
		            	<a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown">
		            		<i class="glyphicon glyphicon-user"></i>&nbsp;${currentUser.name }&nbsp;
		            		<span class="glyphicon glyphicon-chevron-down"></span>
		            	</a>
		             	<ul class="dropdown-menu main-list">
		             		<li>
		             			<a href="javascript:void();" data-url="${ctx }/manage/user/toupdatepwd.do" data-toggle="modal" data-target="#modal">
		             				<i class="glyphicon glyphicon-edit"></i> 修改密码
		             			</a>
		             		</li>
		               		<li><a href="javascript:logout();"><i class="glyphicon glyphicon-off prs"></i>退出</a></li>
		             	</ul>
		           	</li>
				</c:if>
			</ul>
      	</div>
    </div>
</div>
<script type="text/javascript">
	//退出后台
	function logout(){
		layer.confirm("您确定要退出系统吗？", {title:'系统提示', icon:3}, function(){
			window.location.href = "${ctx}/logout.do";
		});
	}
</script>