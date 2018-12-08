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
        	<a class="navbar-brand" href="${ctx }/manage/index.do">
        		<img src="${ctx}/static/images/icon/logo.png" />
        	</a>
      	</div>
      	<div class="navbar-collapse collapse">
	      	<ul class="nav navbar-nav" id="firstMenu">
	      		
	        </ul>
	       
	        <ul class="nav navbar-nav navbar-right">
	          	<li class="dropdown">
	            	<a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown">
	            		<i class="glyphicon glyphicon-user"></i>&nbsp;${currentUser.name }&nbsp;
	            		<span class="glyphicon glyphicon-chevron-down"></span>
	            	</a>
	             	<ul class="dropdown-menu main-list">
	             		<c:if test="${currentUser.userType eq '普通用户' }">
		             		<li>
		             			<a href="${ctx }/index.html"><i class="glyphicon glyphicon-home"></i> 回到首页</a>
		             		</li>
	             		</c:if>
	             		<c:if test="${currentUser.userType eq '管理员' }">
	            			<li>
		             			<a href="javascript:refresh();"><i class="glyphicon glyphicon-refresh"></i> 刷新缓存</a>
		             		</li>
	             		</c:if>
	             		<li>
	             			<a href="javascript:void();" data-url="${ctx }/manage/user/toupdatepwd.do" data-toggle="modal" data-target="#modal">
	             				<i class="glyphicon glyphicon-edit"></i> 修改密码
	             			</a>
	             		</li>
	               		<li><a href="javascript:logout();"><i class="glyphicon glyphicon-off prs"></i>退出</a></li>
	             	</ul>
	           	</li>
	        </ul>
      	</div>
    </div>
</div>

<script type="text/javascript">
	// 加载导航菜单
	$(document).ready(function(){
		var url = "${ctx}/manage/navmenu/list.do";
		$.post(url, function(result){
			$('#firstMenu').html("");
	    	var parentHTML = "";
	    	var data = result.data;
	    	for(var i = 0; i < data.menuList.length; i++){
                if(data.menuList[i].children != null){
                    parentHTML+="<li class='dropdown'>";
                    parentHTML+="<a href='javascript:void(0);' class='dropdown-toggle' data-toggle='dropdown'>"+data.menuList[i].name+"</a>";
                    parentHTML+="<ul class='dropdown-menu'>";
                    for(var j = 0; j < data.menuList[i].children.length; j++){
                        parentHTML+="<li class='navItem'><a href='${ctx}"+data.menuList[i].children[j].menuHref+"'>"+data.menuList[i].children[j].name+"</a></li>";
                    }
                    parentHTML+="</ul>"
                    parentHTML+="</li>";
                }else {
                    parentHTML+="<li class='navItem'><a href='${ctx}"+data.menuList[i].menuHref+"'>"+data.menuList[i].name+"</a></li>";
                }
            }
            $('#firstMenu').html(parentHTML);
		});
	});
	
	// 刷新系统缓存
	function refresh(){
		layer.confirm("您确定要刷新缓存吗？", {title:'系统提示', icon:3}, function(){
			var url = "${ctx}/manage/refresh.do";
			$.post(url, function(data){
				if (data.resultCode == "SUCCESS") {
					layer.msg("刷新完成！", {icon:6});
				}
			}, 'json');
		});
	}
	
	// 退出后台
	function logout(){
		layer.confirm("您确定要退出系统吗？", {title:'系统提示', icon:3}, function(){
			window.location.href = "${ctx}/logout.do";
		});
	}
</script>


