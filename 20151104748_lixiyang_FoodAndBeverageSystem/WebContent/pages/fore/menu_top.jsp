<%@ page language='java' import='java.util.*' pageEncoding='utf-8'%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style type="text/css">
	.navbar-nav{
		font-family: "Helvetica Neue", Helvetica, "PingFang SC", "Hiragino Sans GB", "Microsoft YaHei", "微软雅黑", Arial, sans-serif;
		font-size: 15px;
	}
	
	.navItem{
		font-family: "Helvetica Neue", Helvetica, "PingFang SC", "Hiragino Sans GB", "Microsoft YaHei", "微软雅黑", Arial, sans-serif;
		font-size: 15px;
	    line-height: 1.42857143;
	    color: #616161;
	}
	
	#navbar-right>li>a{
		padding: 17px 10px;
	}
</style>

<!-- 顶部菜单 -->
<div class="navbar navbar-inverse navbar-fixed-top site-navbar">
	<div class="container ">
    	<div class="navbar-header">
        	<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
	          	<span class="icon-bar"></span>
	          	<span class="icon-bar"></span>
	          	<span class="icon-bar"></span>
        	</button>
        	<a class="navbar-brand" href="${ctx }/index.html">
        		<img src="${ctx}/static/images/icon/logo.png" />
        	</a>
      	</div>
      	<div class="navbar-collapse collapse">
	      	<ul class="nav navbar-nav" id="firstMenu">
	      		
	        </ul>
	       
			<c:if test="${empty currentUser }">
				<ul class="nav navbar-nav navbar-right" id="navbar-right">
					<li><a href="${ctx }/tologin.html"><span class="glyphicon glyphicon-log-in"></span>&nbsp;登录</a></li>
		            <li><a href="${ctx }/toregister.html"><span class="glyphicon glyphicon-log-out"></span>&nbsp;注册</a></li>
				</ul>
			</c:if>
			<c:if test="${not empty currentUser }">
		        <ul class="nav navbar-nav navbar-right">
		          	<li class="dropdown">
		            	<a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown"><i class="glyphicon glyphicon-user"></i>&nbsp;${currentUser.name }&nbsp;<span class="glyphicon glyphicon-chevron-down"></span></a>
		             	<ul class="dropdown-menu main-list">
		             		<li><a href="${ctx }/manage/index.do"><i class="glyphicon glyphicon-home"></i>&nbsp;进入后台</a></li>
		               		<li><a href="javascript:logout();"><i class="glyphicon glyphicon-off prs"></i>&nbsp;退出</a></li>
		             	</ul>
		           	</li>
		        </ul>
	        </c:if>
      	</div>
    </div>
</div>
<script type="text/javascript">
	$(document).ready(function(){
		var url = "${ctx}/navmenu/list.do";
		$.post(url, function(resp){
			var data = resp.data;
			$("#firstMenu").html();
			var innerHTML = "";
			for(var i=0;i<data.menuList.length;i++){
				innerHTML+="<li class='navItem'><a id='"+data.menuList[i].id+"'href='${ctx}"+data.menuList[i].menuHref+"'>"+data.menuList[i].name+"</a></li>";
			}
			$('#firstMenu').html(innerHTML);
		}, 'json');
	});
	
	function logout(){
		layer.confirm("您确定要退出系统吗？", {title:'系统提示', icon:3}, function(){
			window.location.href = "${ctx}/logout.do";
		});
	}
</script>