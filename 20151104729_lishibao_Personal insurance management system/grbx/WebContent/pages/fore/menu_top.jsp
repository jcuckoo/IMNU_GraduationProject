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
	.sign-in{
		color: #fff;
	    background-color: #78a5f1;
	    border: 1px solid hsla(0,0%,100%,.5);
	    border-radius: 4px;
	    margin-top: 11px;
	    margin-right: 6px;
	}
	.sign-in:hover{
		background-color:#78a5f1;
		color: #fff;
	}
	.sign-up {
	    color: #fff;
	    background-color: #11aa8c;
	    border: 1px solid #11aa8c;
	    border-radius: 4px;
	    margin-top: 11px;
	}
	.sign-up:hover{
		background-color:#10be9d;
		color: #fff;
	}
	.site-navbar #firstMenu > li > a:hover{
		background-color: #096;
	}
</style>

<!-- 顶部菜单 -->
<div class="navbar navbar-inverse site-navbar" style="margin-bottom: 0px;border: none;">
	<div class="container">
    	<div class="navbar-header">
        	<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
	          	<span class="icon-bar"></span>
	          	<span class="icon-bar"></span>
	          	<span class="icon-bar"></span>
        	</button>
        	<a class="navbar-brand" style="margin-top: -16px;">
        		<img alt="大特保" src="${ctx }/static/images/icon/logo.png">
        	</a>
      	</div>
      	<div class="navbar-collapse collapse">
	      	<ul class="nav navbar-nav" id="firstMenu">
	      		<li class="navItem"><a href="${ctx}/index.html">首页</a></li>
	      		<li class="navItem"><a href="${ctx }/insurance/list.html">保险中心</a></li>
	      		<li class="navItem"><a href="${ctx }/aboutus.html">服务协议</a></li>
	        </ul>
	       
			<c:if test="${not empty currentUser }">
				<ul class="nav navbar-nav navbar-right" id="navbar-right">
					<li class="dropdown">
		            	<a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown">
		            		<i class="glyphicon glyphicon-user"></i>&nbsp;${currentUser.truename }&nbsp;<span class="glyphicon glyphicon-chevron-down"></span>
		            	</a>
		             	<ul class="dropdown-menu main-list">
		             		<li>
		             			<a href="${ctx }/manage/person/list.do">
		             				<i class="glyphicon glyphicon-user"></i>&nbsp;个人信息
		             			</a>
		             		</li>
		               		<li><a href="javascript:logout();"><i class="glyphicon glyphicon-off prs"></i>&nbsp;退出</a></li>
		             	</ul>
		           	</li>
				</ul> 
			</c:if>
			<c:if test="${empty currentUser }">
				<div class="navbar-right btns">
	                <a class="btn btn-default navbar-btn sign-in" href="${ctx }/tologin.html">登录</a>
	                <a class="btn btn-default navbar-btn sign-up" href="${ctx }/toregister.html">注册</a>
	            </div>
            </c:if>
            <div class="navbar-right btns" style="margin-top: 3px;margin-right: 10px;">
		        <a class="btn btn-info navbar-btn" href="${ctx }/manage/order/list.do">
		        	<span class="glyphicon glyphicon-shopping-cart"></span>&nbsp;我的保单
		        </a>
		    </div>
      	</div>
    </div>
</div>
<script type="text/javascript">
	function logout(){
		layer.confirm("您确定要退出系统吗？", {title:'系统提示', icon:3}, function(){
			window.location.href = "${ctx}/logout.do";
		});
	}
</script>