<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${pageTitle }</title>
<%@ include file="/pages/commons/taglibs.jsp"%>
<%@ include file="/pages/commons/top.jsp"%>
<style type="text/css">
	.metro-layout .box { float: left; position: relative; margin:3% 2%; width: 10em; height: 10em; text-decoration: none; cursor: pointer; overflow: hidden; z-index: 9;border: 1px #ccc solid;border-radius:5px;*background: #eee;color: #fff;opacity: 0.75; filter: alpha(opacity=75);}
	.metro-layout .box:hover { opacity: 1; filter: alpha(opacity=100);border: 1px #999 solid;background: #E2E2E2; }
	.metro-layout .box img.icon { width: 100%; height: 100%;margin-top:-5%; z-index: 7; }
	.metro-layout .box span { position: absolute; bottom: 0.1em; font-size: 1em; font-weight: normal; z-index: 8; width:100% ;padding:1% 5%;text-align: center;background: rgba(0, 0, 0, 0.6); }
	.metro-layout .box label { position: absolute; top: 0.2em; right: 0.2em; font-size: 1em; font-weight: normal; z-index: 8; padding:1% 5%;text-align: right; background: #BE8DF3;color: #fff;border-radius: 100%; }
	.es-row-wrap {border-radius: 5px;}
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
</head>
<body style="background-color:#eee; padding-top:3%">
	<!-- 头部begin -->
	<div class="navbar navbar-inverse navbar-fixed-top site-navbar">
		<div class="container ">
	    	<div class="navbar-header">
	        	<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
		          	<span class="icon-bar"></span>
		          	<span class="icon-bar"></span>
		          	<span class="icon-bar"></span>
	        	</button>
	        	<a class="navbar-brand" href="${ctx }/manage/index.do" style="margin-top: -16px;">
	        		<img src="${ctx}/static/images/icon/logo.png" />
	        	</a>
	      	</div>
	      	<div class="navbar-collapse collapse">
		      	<ul class="nav navbar-nav" id="firstMenu"></ul>
		        <ul class="nav navbar-nav navbar-right">
		          	<li class="dropdown">
		            	<a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown">
		            		<i class="glyphicon glyphicon-user"></i>&nbsp;${currentUser.truename }&nbsp;
		            		<span class="glyphicon glyphicon-chevron-down"></span>
		            	</a>
		             	<ul class="dropdown-menu main-list">
		             		<li>
		             			<a href="javascript:void();" data-url="${ctx }/manage/user/toupdatepwd.do" data-toggle="modal" data-target="#modal">
		             				<i class="glyphicon glyphicon-user prs"></i> 修改密码
		             			</a>
		             		</li>
		               		<li><a href="javascript:logout();"><i class="glyphicon glyphicon-off prs"></i>退出</a></li>
		             	</ul>
		           	</li>
		        </ul>
	      	</div>
	    </div>
	</div>
	<!-- 头部end -->
	<div class="container" id="context-homepage" style="margin-top:5%">
		<div class="row">	
			<div class="metro-layout">
				<div class="es-row-wrap container-gap userpage-header">
					<div class="row">
						<div class="col-md-12" id="menuImages">
							
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="/pages/commons/bottomjs.jsp" %>
</body>
<script type="text/javascript">
	$(document).ready(function(){
		jQuery.post('${ctx}/manage/navmenu/list.do', function(result){
	    	$('#menuImages').html("");
	    	var innerHTML = "";
	    	var data = result.data;
	    	for(var i = 0; i < data.menuList.length; i++){
	    		if(data.menuList[i].menuHref != "" && data.menuList[i].menuHref != null){		    		
		    		innerHTML+="<a class='box isotope-item' href='${ctx}"+data.menuList[i].menuHref+"' style='background:rgb(156,210,195)' >";
	    			innerHTML+="<span><strong>"+data.menuList[i].name+"</strong></span>";
	    			innerHTML+="<img class='icon' src='${ctx}"+data.menuList[i].menuImg+"'/>";
	    			innerHTML+="</a>";
	    		}
	    	}
	    	$('#menuImages').html(innerHTML);
	    }, 'json');	
	});

	// 退出后台
	function logout(){
		layer.confirm("您确定要退出系统吗？", {title:'系统提示', icon:3}, function(){
			window.location.href = "${ctx}/logout.do";
		});
	}
</script>
</html>





				
