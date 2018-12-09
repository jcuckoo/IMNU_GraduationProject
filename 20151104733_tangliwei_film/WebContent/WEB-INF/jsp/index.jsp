<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>基于JavaWeb的滨海影视网站的设计与实现</title>
<link type="text/css" rel="stylesheet" href="css/zhuyelogo.css" />

<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="js/imageslide.js"></script> 
</head>
<body>

<h1>111111111</h1>
<a href="login.jsp">登录</a>
<form action="register" method="post">
<a href="register.jsp">注册</a>
</form>
<br>
<form action="logout" method="post">
<input type="submit" value="退出"/>
</form>
<script type="text/javascript">
$('#mFocus1').ImgSlide({
	loop : true,
	timeout : 15e3,
	data : [{
		p:"images/sohu01.jpg",
		p1:"images/sohu001.jpg",
		l:"http://www.baidu.com",
		t:"《17173动漫嘉年华》",
		t_:"九阴真经17173第十届游戏动漫嘉年华",
		t1:"　　九阴真经17173第十届游戏动漫嘉年华报道，采取各地巡回表演的形式……",
		mtype:[{"t":"动漫嘉年华"}],
		mdirector:[{"t":"动漫嘉年华"}],         
		mactor:[{"t":"动漫嘉年华"}]
	},{
		p:"images/sohu01.jpg",
		p1:"images/sohu001.jpg",
		l:"http://www.baidu.com",
		t:"《反恐精英：全球攻势》",
		t_:"《反恐精英：全球攻势》独家CG预告",
		t1:"　　Valve的最新力作《CS：GO》并未在今年的科隆游戏展2012上透露什么具体消息，但即将发售的本作也绝对不会自甘寂寞……",
		mtype:[{"t":"第一人称射击"}],
		mdirector:[{"t":"Valve Software"}],         
		mactor:[{"t":"Valve Software"}]
	},{
		p:"images/sohu02.jpg",
		p1:"images/sohu002.jpg",
		
		l:"http://www.baidu.com",
		t:"《弹雨狂奔》",
		t_:"索尼FPS新作《弹雨狂奔》科隆展预告",
		t1:"　　索尼在线娱乐公布了一款名为《子弹飞舞(Bullet Run)》的网游新作。 据官方介绍，本作为第一人称射击类型，采用免费模式运营……",
		mtype:[{"t":"3D/射击游戏/FPS射击"}],
		mdirector:[{"t":"ACONYGAMES"}],         
		mactor:[{"t":"暂无"}]
	},{
		p:"images/sohu01.jpg",
		p1:"images/sohu001.jpg",
		
		l:"http://www.baidu.com",
		t:"《QQ炫舞》",
		t_:"炫歌之王《QQ炫舞》明星争霸赛",
		t1:"　　QQ炫舞炫歌之王明星争霸赛是17173QQ炫舞视频站与官方合作的QQ炫舞3.0演唱会版本的歌曲翻唱大赛……",
		mtype:[{"t":"3D/运动/休闲/音乐游戏"}],
		mdirector:[{"t":"永航科技"}],         
		mactor:[{"t":"腾讯"}]
	},{
		p:"images/sohu01.jpg",
		p1:"images/sohu001.jpg",
		
		l:"http://www.baidu.com",
		t:"《战争前线》",
		t_:"中文字幕《战争前线》场景是怎样炼成的",
		t1:"　　孤岛危机游戏开发商Crytek针对亚洲用户打造的FPS网络游戏。中国大陆代理商腾讯游戏表示…………",
		mtype:[{"t":"3D/射击游戏/FPS射击"}],
		mdirector:[{"t":"Crytek"}],         
		mactor:[{"t":"腾讯"}]
	},{
		p:"images/sohu02.jpg",
		p1:"images/sohu002.jpg",
		
		l:"http://www.baidu.com",
		t:"《地下城强袭者》",
		t_:"《地下城强袭者》帅气火炮手宣传视频",
		t1:"　　游戏具有快速而爽快的动作，简单而方便的操作，超过19种职业的转职系统等内容…………",
		mtype:[{"t":"3D/角色扮演/奇幻游戏"}],
		mdirector:[{"t":"EYEDENTITY"}],         
		mactor:[{"t":"盛大游戏"}]
	},{
		p:"images/sohu01.jpg",
		p1:"images/sohu001.jpg",
		
		l:"http://www.baidu.com",
		t:"《幽灵行动OL》",
		t_:"未来风格TPS《幽灵行动OL》新宣传片",
		t1:"　　 育碧开发的一款近未来风格的第三人称射击游戏，为著名射击游戏《幽灵行动》的网络版…………",
		mtype:[{"t":"3D/射击游戏/TPS射击"}],
		mdirector:[{"t":"育碧"}],         
		mactor:[{"t":"育碧"}]
	},{
		p:"images/sohu02.jpg",
		p1:"images/sohu002.jpg",
		
		l:"http://www.baidu.com",
		t:"《逆战》",
		t_:"《逆战》生存祭坛英雄 17173解说",
		t1:"　　腾讯以虚幻3引擎自主研发的FPS网络游戏。游戏上手简单，支持爽快淋漓的多人对战，在独特PVE模式中…………",
		mtype:[{"t":"3D/射击游戏/FPS射击"}],
		mdirector:[{"t":"腾讯"}],         
		mactor:[{"t":"腾讯"}]
	}]
	
});
</script>
</body>
</html>