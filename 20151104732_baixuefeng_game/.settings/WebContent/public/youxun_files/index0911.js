 /*懒加载*/
    $(function() {
        $("img.lazy").lazyload();
    });

//图片导航
$('.pic_show a').hover(function() {
	$(this).find('em').animate({
		'bottom': '30%'
	}, 200);
	$(this).find('b').animate({
		'height': '100%'
	}, 200);
}, function() {
	$(this).find('em').animate({
		'bottom': '0px'
	}, 200);
	$(this).find('b').animate({
		'height': '22px'
	}, 200);
});


(function() {
jq('#sbox').banqh({
	box:"#sbox",//总框架
	pic:"#simg",//大图框架
	pnum:"#simg_s",//小图框架
	//prev_btn:"#prev_btn1",//小图左箭头
	//next_btn:"#next_btn1",//小图右箭头
	//pop_prev:"#prev2",//弹出框左箭头
	//pop_next:"#next2",//弹出框右箭头
	prev:"#prev1",//大图左箭头
	next:"#next1",//大图右箭头
	//pop_div:"#demo2",//弹出框框架
	//pop_pic:"#ban_pic2",//弹出框图片框架
	//pop_xx:".pop_up_xx",//关闭弹出框按钮
	//mhc:".mhc",//朦灰层
	autoplay:true,//是否自动播放
	interTime:3000,//图片自动切换间隔
	delayTime:300,//切换一张图片时间
	//pop_delayTime:400,//弹出框切换一张图片时间
	order:0,//当前显示的图片（从0开始）
	picdire:true,//大图滚动方向（true为水平方向滚动）
	mindire:true,//小图滚动方向（true为水平方向滚动）
	min_picnum:4,//小图显示数量
	pop_up:false//大图是否有弹出框
})

})();


$(function(){
    $(".wy_center ul li").eq(5).addClass("pt11");
    $(".wy_kaice .kc5").slice(0,3).addClass("top");
    $(".bdcon").each(function(){
        $(".bd_n1 i").eq(0).addClass("t1");
        $(".bd_n1 i").eq(1).addClass("t2");
        $(".bd_n1 i").eq(2).addClass("t3");
        $(".bd_n1 i").eq(16).addClass("t1");
        $(".bd_n1 i").eq(17).addClass("t2");
        $(".bd_n1 i").eq(18).addClass("t3");
        $(".bd_n1 i").eq(32).addClass("t1");
        $(".bd_n1 i").eq(33).addClass("t2");
        $(".bd_n1 i").eq(34).addClass("t3");
    })
    $(".sygame_rank ul li b").eq(0).addClass("t1");
    $(".sygame_rank ul li b").eq(1).addClass("t2");
    $(".sygame_rank ul li b").eq(2).addClass("t3");
    $(".sygame_rank ul li b").eq(11).addClass("t1");
    $(".sygame_rank ul li b").eq(12).addClass("t2");
    $(".sygame_rank ul li b").eq(13).addClass("t3");
    $(".sygame_rank ul li b").eq(22).addClass("t1");
    $(".sygame_rank ul li b").eq(23).addClass("t2");
    $(".sygame_rank ul li b").eq(24).addClass("t3");
    $(".sygame_rank ul li b").eq(33).addClass("t1");
    $(".sygame_rank ul li b").eq(34).addClass("t2");
    $(".sygame_rank ul li b").eq(35).addClass("t3");
    $(".rbc_list ul li").eq(0).addClass("open");

    $(".nav_con ul").eq(0).css("width","287px");
    $(".nav_con ul").eq(1).css("width","245px");

    $(".pc_list ul li").eq(1).removeClass("gray");
    $(".pc_list ul li").eq(3).removeClass("gray");
    $(".pc_list ul li").eq(5).removeClass("gray");
    $(".pc_list ul li").eq(7).removeClass("gray");
})

/*tab切换*/
function tab_down(tab_k, tab_con, tab_dz) {
	var $div_li = $(tab_k);
	var timeout
	if (tab_dz == "click") {
		$div_li.click(function() {
			$(this).addClass("hover").siblings().removeClass("hover");
			var index = $div_li.index(this);
			$(tab_con).eq(index).show().siblings().hide();
		})
	} else if (tab_dz == "mouseover") {
		$div_li.hover(function() {
			var ts = $(this)
			timeout = setTimeout(function() {
				ts.addClass("hover").siblings().removeClass("hover");
				var index = ts.index();
				$(tab_con).eq(index).show().siblings().hide();
			}, 200)
		}, function() {
			clearTimeout(timeout);
		})
	}

}

tab_down("#game_cate .tab>a", ".boxcon >#hotbox", "mouseover");
tab_down(".pc_tab >a", "#dj >.djcon", "mouseover");
tab_down(".pc_top >a", ".rank_tj >.pc_rank", "mouseover");
tab_down(".wy_kaice_tit >a", ".wy_kaice_list >.kaice_list_con", "mouseover");
tab_down(".tuijian_tab >a", ".sy_box >.sy_box_con", "mouseover");
tab_down(".sytab1 >a", ".sygame_box >.sycon1", "mouseover");
tab_down(".sytab2 >a", ".rjbox >.sycon2", "mouseover");
tab_down(".sydown_tab >a", "#shouji >.shoujicon", "mouseover");
tab_down(".rbc_list ul> li", ".libao_info > .sy_libao_pic", "mouseover");
tab_down(".el_tab> a", ".pc_change > .pcbox", "mouseover");
//手机软件
tab_down(".sstab1 >a", ".ssgame_box >.sscon1", "mouseover");
tab_down(".sstab2 >a", ".rsbox >.sscon2", "mouseover");
tab_down(".sysoft_tab >a", "#shoujisoft >.shoujicon", "mouseover");
// tab_down(".p_ico ul >li", "#pager >.pcon", "mouseover");

//单机专题合集
$(".dj_slide .zs_jdgame").jCarouselLite({
	btnNext: ".dj_slide .zs_jdgame_btn .zs_next",
	btnPrev: ".dj_slide .zs_jdgame_btn .zs_prev",
	visible: 4
});

//手游专题合集
$(".sy_ios_slide .zs_jdgame").jCarouselLite({
	btnNext: ".sy_ios_slide .zs_jdgame_btn .zs_next",
	btnPrev: ".sy_ios_slide .zs_jdgame_btn .zs_prev",
	visible: 4
});
//手机软件专题合集
$(".ss_ios_slide .zs_jdgame").jCarouselLite({
	btnNext: ".ss_ios_slide .zs_jdgame_btn .zs_next",
	btnPrev: ".ss_ios_slide .zs_jdgame_btn .zs_prev",
	visible: 4
});



//手游礼包
var open_mub, set_box
$(".rbc_list ul li").hover(function() {
	open_mub = $(this).index()
	set_box = $(this).parent().parent().index()
	$(".rbc_list:eq(" + set_box + ") ul li").removeClass("open")
	$(this).addClass("open")
})

$(".rbc_list ul li").hover(function() {
	$(".rbc_list ul li").removeClass("open")
	$(this).addClass("open")
})

$(".rbc_list ul li").hover(function() {
	$(".rbc_list ul li").removeClass("open")
	$(this).addClass("open")
})

$(".pcon").eq(1).hide();
$(".pcon").eq(2).hide();

//手游开测
var open_mub, set_box
$(".sy_kaice ul li").hover(function() {
	open_mub = $(this).index()
	set_box = $(this).parent().parent().index()
	$(".sy_kaice:eq(" + set_box + ") ul li").removeClass("open")
	$(this).addClass("open")
})

$(".sy_kaice ul li").hover(function() {
	$(".sy_kaice ul li").removeClass("open")
	$(this).addClass("open")
})

$(".sy_kaice ul li").hover(function() {
	$(".sy_kaice ul li").removeClass("open")
	$(this).addClass("open")
})


//网游开测

var open_mub, set_box
$(".wy_kaice_list1 ul li").hover(function() {
	open_mub = $(this).index()
	set_box = $(this).parent().parent().index()
	$(".wy_kaice_list1 ul li:eq(" + set_box + ") ul li").removeClass("open")
	$(this).addClass("open")
})

$(".wy_kaice_list1 ul li").hover(function() {
	$(".wy_kaice_list1 ul li").removeClass("open")
	$(this).addClass("open")
})

$(".wy_kaice_list1 ul li").hover(function() {
	$(".wy_kaice_list1 ul li").removeClass("open")
	$(this).addClass("open")
})



/*通栏 目录导航*/
$(".navBar .dh").hover(function() {
	$(".tl-bar_box").show();
}, function() {
	$(".tl-bar_box").hide();
})

/*通栏 二维码*/
$(".tl-phone").hover(function() {
	$(".tl-bar-qrcode").show();
}, function() {
	$(".tl-bar-qrcode").hide();
})

/*加入收藏*/
$('.sc_bar').click(function() {
	AddFavorite(document.location.href, document.title);
});

function AddFavorite(sURL, sTitle) {
	try {
		window.external.addFavorite(sURL, sTitle);
	} catch (e) {
		try {
			window.sidebar.addPanel(sTitle, sURL, "");
		} catch (e) {
			alert("加入收藏失败，请使用Ctrl+D进行添加！");
		}
	}
}



//网游推荐专区
	$('.gather a').hover(function() {
		$(this).find('img').animate({'width':'103%', 'height': '108%', 'opacity':'80'}, 200);
	}, function() {
		$(this).find('img').animate({'width':'100%', 'height': '100%','margin-top':'0','margin-left':'0'}, 200);
	});


$('.wl_tj_img').hover(function() {
	$(this).find('img').animate({'width':'105%', 'height': '105%', 'opacity':'90'}, 200);
}, function() {
	$(this).find('img').animate({'width':'100%', 'height': '100%','margin-top':'0','margin-left':'0'}, 200);
});

/*鼠标放上图片透明度*/
$('img:not(.shadom_img,.left_850x120 img,.right_250x370 img)').hover(function() {
	$(this).animate({
		'opacity': '0.8'
	}, 300)
}, function() {
	$(this).animate({
		'opacity': '1.0'
	}, 300)
})

/*热门活动*/
//$(function() {
//    var lilen=function(){
//         var z=$(".hot_hd .carousel ul li").length;
//         var c=[];
//         for(var y=1;y<=z;y++){
//            c.push(".hot_hd ."+y+"")
//         }
//         return c
//    };
//    // console.log(lilen())
//    var lilist=[];
//    $(".hot_hd .carousel ul li").each(function(){
//        lilist.push($(this).find("img").attr("src"));
//    })
//    console.log(lilist)
//
//    var lieach=function(y){
//        var a=$(".hot_hd .carousel ul li");
//        var hk=0;
//        if(y<-((a.length-1)*250)){
//            y=-500
//        }
//        a.each(function(){
//            var i=$(this).position().left;
//            if(i==-y){
//                var imgsrc=$(this).find("img").attr("src");
//                // console.log(imgsrc);
//                for(var iu=0;iu<lilist.length;iu++){
//                    if(lilist[iu]==imgsrc){
//                        hk=iu;
//                        break;
//                    }
//                }
//            }
//        })
//        return hk;
//    };
//
//    $(".hot_hd .carousel").jCarouselLite({
//        btnNext: ".hot_hd .next",
//        btnPrev: ".hot_hd .prev",
//        visible: 1,
//        auto: 3000,
//        speed: 500,
//	    btnGo:lilen(),
//        beforeStart:function(){
//           var a=$(".hot_hd .carousel ul").position().left;
//           // console.log()
//           $(".hot_hd .pagenav a").removeClass("onpage");
//           $(".hot_hd .pagenav a:eq("+lieach(a-250)+")").addClass("onpage");
//        }
//    });
//
//    var a=$(".hot_hd .carousel ul").position().left;
//    $(".hot_hd .pagenav a").removeClass("onpage");
//    $(".hot_hd .pagenav a:eq("+lieach(-250)+")").addClass("onpage");
//});
$(function() {
    $(".hot_hd .carousel").jCarouselLite({
        btnNext: ".hot_hd .next",
        btnPrev: ".hot_hd .prev",
        visible: 1,
        speed: 500,
        auto: 5000
    });
});

/*轮播广告大图*/
/*$(function() {
    $("#slides .carousel").jCarouselLite({
        btnNext: "#slides .next",
        btnPrev: "#slides .prev",
        visible: 1,
        speed: 500,
        auto: 5000
    });
});*/

/*1920尺寸广告*/
// $(function() {
//     $(".gg .carousel").jCarouselLite({
//         btnNext: ".gg .next",
//         btnPrev: ".gg .prev",
//         visible: 1,
//         speed: 500,
//         auto: 5000
//     });
// });

//热点资讯底部三栏-切换   
function news_three_qh(){
    
    var $obj = $(".pcon");
    var len  = $obj.length;
    var i = 0;
    
     $(".p_ico .next").click(function(){
          i++;
          if(i==len){
            i = 0;
          }
          $obj.stop(true,true).hide().eq(i).show();

          if(i==0){
            $(".prev").removeAttr('href');
          }
          
          
          $(".news-three-"+i+"").addClass("hover").siblings().removeClass("hover");
          return false;
     });    
     $(".p_ico .prev").click(function(){
          i--;
          if(i==-1){
            i = len-1;
          }
          $obj.stop(true,true).hide().eq(i).show();
          
          $(".news-three-"+i+"").addClass("hover").siblings().removeClass("hover");
          return false;
     });
     
     $(".p_ico ul li").click(function(){
        
        var ci = $(this).attr("data-i");
        i = ci;
        $(".pcon:eq("+ci+")").show().siblings(".pcon").hide();
        $(this).addClass("hover").siblings().removeClass("hover");
 
     });
    
}

news_three_qh();

/*网游tab切换*/
    function tabs() {
        $.fn.extend({
            magnifier: function() {
                var width = {
                    wide: {
                        normal: 100,
                        active: 166,
                        gap: 68
                    },
                    narrow: {
                        normal: 68,
                        active: 117,
                        gap: 49
                    }
                },
                height = {
                    wide: {
                        normal: 42,
                        active: 86
                    }
                },
                gap = {
                    wide: {
                        horizontal: 2,
                        vertical: 2
                    },
                    narrow: {
                        horizontal: 2,
                        vertical: 2
                    }
                },
                item_inline = 3,
                item_status = "wide",
                self = this.each(function() {
                    var topic = $(this),
                    list = topic.find(".wy_tab_list").css({
                        position: "relative"
                    }),
                    item = list.find(".ui-topic__item").css({
                        position: "absolute"
                    }),
                    item_active = item.filter(".tab-active"),
                    isMoving = !1;
                    item_active.css({
                        top: 0,
                        left: 0,
                        width: width[item_status].active,
                        height: height[item_status].active
                    }).attr("data-x", "0").attr("data-y", "*"),
                    item.not(item_active).each(function(i) {
                        var y = i >= item_inline ? 1 : 0,
                        x = y ? i - item_inline: i;
                        $(this).css({
                            top: i >= item_inline ? height[item_status].normal + gap[item_status].vertical: 0,
                            left: x * (width[item_status].normal + gap[item_status].horizontal) + width[item_status].active + gap[item_status].horizontal,
                            width: width[item_status].normal,
                            height: height[item_status].normal
                        }).attr("data-x", x + 1).attr("data-y", y)
                    });
                    var getPosition = function(target) {
                        return {
                            x: target.attr("data-x"),
                            y: target.attr("data-y")
                        }
                    },
                    reflow = function(item_prev, item_active) {
                        var pos_prev = getPosition(item_prev),
                        pos_active = getPosition(item_active),
                        temp = pos_prev.y;
                        pos_prev.y = pos_active.y,
                        pos_active.y = temp,
                        item_prev.attr("data-y", pos_prev.y),
                        item_active.attr("data-y", pos_active.y);
                        var min = Math.min(pos_prev.x, pos_active.x),
                        max = Math.max(pos_prev.x, pos_active.x),
                        item_group = item.not(item_prev).not(item_active).filter(function() {
                            var pos_current = getPosition($(this));
                            return pos_current.y != pos_prev.y && pos_current.x >= min && pos_current.x <= max
                        }),
                        fixed = pos_active.x < pos_prev.x ? 1 : -1;
                        item_group.each(function() {
                            $(this).attr("data-x", $(this).attr("data-x") - 0 + fixed)
                        })
                    };
                    topic.on("mouseover mousemove", ".ui-topic__item:not(.tab-active)",
                    function() {
                        if (!isMoving) {
                            isMoving = !0;
                            var item_prev = item_active.removeClass("tab-active");
                            item_active = $(this).addClass("tab-active"),
                            reflow(item_prev, item_active);
                            var pos_prev = getPosition(item_prev),
                            pos_active = getPosition(item_active);
                            item_prev.css({
                                zIndex: ""
                            }).stop().animate({
                                top: (height[item_status].normal + gap[item_status].vertical) * pos_prev.y,
                                left: (width[item_status].normal + gap[item_status].horizontal) * pos_prev.x + (pos_prev.x < pos_active.x ? 0 : width[item_status].gap),
                                width: width[item_status].normal,
                                height: height[item_status].normal
                            },
                            function() {
                                isMoving = !1
                            }),
                            item_active.css({
                                zIndex: 9
                            }).stop().animate({
                                top: 0,
                                left: (width[item_status].normal + gap[item_status].horizontal) * pos_active.x,
                                width: width[item_status].active,
                                height: height[item_status].active
                            }),
                            item.not(item_prev).not(item_active).each(function() {
                                var pos_current = getPosition($(this));
                                $(this).css({
                                    width: width[item_status].normal,
                                    height: height[item_status].normal
                                }).stop().animate({
                                    top: (height[item_status].normal + gap[item_status].vertical) * pos_current.y,
                                    left: (width[item_status].normal + gap[item_status].horizontal) * pos_current.x + (pos_current.x < pos_active.x ? 0 : width[item_status].gap)
                                })
                            })
                        }
                    }).on("magnifier:update",
                    function() {
                        var pos_active = getPosition(item_active);
                        item.not(item_active).each(function() {
                            var pos_current = getPosition($(this));
                            $(this).css({
                                width: width[item_status].normal,
                                height: height[item_status].normal,
                                top: (height[item_status].normal + gap[item_status].vertical) * pos_current.y,
                                left: (width[item_status].normal + gap[item_status].horizontal) * pos_current.x + (pos_current.x < pos_active.x ? 0 : width[item_status].gap)
                            })
                        }),
                        item_active.css({
                            left: (width[item_status].normal + gap[item_status].horizontal) * pos_active.x,
                            width: width[item_status].active,
                            height: height[item_status].active
                        })
                    })
                }),
                update = function() {
                    $(this).trigger("magnifier:update")
                };
                return $(window).on("resize:narrow",
                function() {
                    item_status = "narrow",
                    self.each(update)
                }).on("resize:wide",
                function() {
                    item_status = "wide",
                    self.each(update)
                }),
                this
            }
        }),
        $(".wy_tab_con").magnifier()
    } ;
tabs()

/*背投*/
$(function() {
    $(document).on("click", "#closebg", function() {
        $("#adbg").hide();
        $(this).hide();
        $("body").css({
            "background": "url(http://www.yxdown.com/new_img/yxdown_home/background_old.jpg) no-repeat center 0px"
        })
    })
    var adbox = $("#adbg")
    $(window).scroll(function() {
      var scrolltop = $(window).scrollTop()
        if (scrolltop > 85) {
            if (navigator.appVersion.indexOf("MSIE 6") > -1) {
                adbox.css({
                    "position": "absolute",
                    "top": "" + scrolltop + "px"
                })
            } else {
                adbox.css({
                    "position": "fixed",
                    "top": "0"
                })
            }



        } else {
            adbox.css({
                "position": "absolute",
                "top": "35px"
            })
        }
  		
	})
})


/*悬浮搜索*/

$(window).scroll(function (){ 
    var scrolltoph = $(window).scrollTop()
    if(scrolltoph > 500){
        $("#search").css({"display":"block"})
    }else{
        $("#search").css({"display":"none"})
    }
})

/*js添加背景色*/
$(document).ready(function(){
    $(".wy_right ul li").eq(0).addClass("open");
    $(".wy_pingce ul li").eq(1).addClass("gray");
    $(".wy_pingce ul li").eq(3).addClass("gray");
    $(".sy_kaice ul li").eq(0).addClass("open");
    $(".bd_gl ul li").removeClass("gray");
    // 首页网络游戏顶部增加广告
    /*$("#link").before("<a href='http://www.yxdown.com/ads/334.html' target='_blank' style='width:1100px; overflow:hidden; zoom:1; display:block; margin:0 auto;padding:0 15px 10px; height:90px;position:relative;z-index:2;background:#fff;'><img src='http://static.yxdown.com/cjimages/index_1100x90.jpg'/></a>")*/
})


// //轮播图广告
// document.getElementById("slides").innerHTML='<div class="pagenav"><a href="javascript:" class="go 1">1</a><a href="javascript:" class="go 2">2</a></div><a href="javascript:" class="prev">&lsaquo;</a><div class="carousel"><ul><li><a href="/" target="_blank"><img src="http://images.17173cdn.com/2016/www/2016/gg/37/12/17/cq-1217-1920300-hb2.jpg"/></a></li><li><a href="/" target="_blank"><img src="http://images.17173cdn.com/2016/ww/2016/gg/hd/12/15/cc-1216-1920530-hb2b1.jpg"/></a></li></ul></div><a href="javascript:" class="next">&rsaquo;</a><div class="clear"></div>';


$(function(){
// 首页左侧轮播点击统计
    var i=new Image();
    if($('#simg').length>0){
        $(document).on('click','#simg li a',function(){
            var _index=$(this).parent().index();
            var key=['a2V5cz1wY19zeV96YzAx','a2V5cz1wY19zeV96YzAy','a2V5cz1wY19zeV96YzAz','a2V5cz1wY19zeV96YzA0','a2V5cz1wY19zeV96YzA1'];
            i.src='http://tongji.ttsj.yxdown.com/sys/count.do?sc='+key[_index];
        })
    }
    // 首页右侧单机发售表上方点击统计
    if($('#ads140').length>0){
        $(document).on('click','#ads140 a',function(){
            i.src='http://tongji.ttsj.yxdown.com/sys/count.do?sc=a2V5cz1wY19zeV95Y19z';
        })
    }
    // 首页右侧热门活动轮播点击统计
    if($('.carousel').length>0){
        $(document).on('click','.carousel a',function(){
            i.src='http://tongji.ttsj.yxdown.com/sys/count.do?sc=a2V5cz1wY19zeV95Y194';
        })
    }
})

//网游轮播
$("#stimg .stibox").responsiveSlides({ auto: true, pager: true, speed: 500, timeout: 3000, pauseControls: false, nav: true });
$("#stimg").hover(function () {
    $(this).find(".rslides_nav").show();
}, function () {
    $(this).find(".rslides_nav").hide();
})

// 轮播覆盖
// $("#sbox").append('<div class="shadom_bg" style="width:370px; height:460px;position:absolute; left:0; top:0; z-index:999;"><a href="http://www.yxdown.com/ads/324.html" target="_blank"><img src="http://static.yxdown.com/cjimages/index_370x460_v3.jpg" class="shadom_img"></a><em style="display: block;width:24px; height:14px; background:url(http://static.yxdown.com/cjimages/tg-ico-expand.png) no-repeat; position:absolute; z-index:10;left:2px;bottom:2px;"></em><span class="s_close_bgn" style="position:absolute;z-index:120;right:2px;bottom:2px;background:#fff;width:20px;height:20px;line-height:20px;font-family: Simsun;font-size: 20px;cursor:pointer;">×</span></div>');
// $(".shadom_bg .s_close_bgn").click(function(){
//     $(".shadom_bg").hide();
// });
// setTimeout(function(){
//     $(".shadom_bg").hide();
// },10000);

//首页底部新增广告
// $("#link").prepend("<div style='position:relative;margin-bottom:30px;'><a href='http://www.yxdown.com/ads/302.html' target='_blank' style='width:1100px;height:90px;display:block;position:absolute;z-index:99;background:#000;opacity:0;filter:alpha(opacity=0);'></a><b><embed src='http://static.yxdown.com/cjimages/swf/atl_1100x90.swf' width='1100' height='90' wmode='transparent' quality='high' type='application/x-shockwave-flash' title='Adobe Flash Player'></b></div>");
// cookie
var getCookie = function(c_name) {
    if (document.cookie.length > 0) {
        c_start = document.cookie.indexOf(c_name + "=");
        if (c_start != -1) {
            c_start = c_start + c_name.length + 1;
            c_end = document.cookie.indexOf(";", c_start);
            if (c_end == -1)
                c_end = document.cookie.length;
            return unescape(document.cookie.substring(c_start, c_end));
        }
    }
    return "";
}
var setCookie = function(c_name, value, expiredays) {
    var exdate = new Date();
    exdate.setDate(exdate.getDate() + expiredays);
    document.cookie = c_name + "=" + escape(value) +
        ((expiredays == null) ? "" : ";expires=" + exdate.toGMTString());
};
// var fgS = 10; //倒计时
// var fgIn;
// var divHtml="<div id='FuGai' style='display:none;width:900px;height:350px;overflow:hidden;box-shadow:0 4px 10px 0 rgba(0,0,0,1);position:fixed;left:50%; top:50%;margin-left:-450px;margin-top:-175px;z-index:1000000;'></div>";
// var fgHtml="<img src='http://static.yxdown.com/cjimages/pop_900x350.jpg' style='width:900px;height:350px; border:none;' />";
// fgHtml+="<a style='display:block;width:900px;height:350px;position:absolute;left:0;top:0;z-index:1;' href='http://dps.sj.yxdown.com/tlsd2787c48/4306/' target='_blank' class='countHit'></a>";
// fgHtml+="<div style='width:auto;height:20px;line-height:20px;color:#babbbd;font-size:12px;font-family:SimSun;text-align:center;overflow:hidden;position:absolute;top:0;right:0;z-index:2;'>";
// fgHtml+="<span id='t' style='float:left;margin-right:1px;display:block;width:48px;height:20px;background:#282828;'>"+(fgS<10?"0"+fgS:fgS)+" 秒</span>";
// fgHtml+="<a class='close' href='javascript:;' style='float:left;display:block;width:72px;height:20px;color:#babbbd;background:#282828;'>×关闭广告</a></div>";
// /*fgHtml+='<em style="display: block;width:24px; height:14px; background:url(http://static.yxdown.com/cjimages/tg-ico-expand.png) no-repeat; position:absolute; z-index:10;left:2px;bottom:2px;"></em>';*/
// var fgSetime=function(){
//     fgS--;
//     $("#t").html((fgS<10?"0"+fgS:fgS)+" 秒");
//     if(fgS<0){$("#FuGai").remove();
//         clearInterval(fgIn);
//     }
// };
// $('body').append(divHtml);
// $("#FuGai").on("click","a.close",function(){
//     clearInterval(fgIn);
//     $("#FuGai").remove();
// });
// function add(){
//     var setimer=setInterval(function(){
//         $("#FuGai").html(fgHtml).show();
//         clearInterval(setimer);
//         fgIn=setInterval(fgSetime,1000);
//     },1000);
// };
// if(getCookie('f') == ""){
//     add();
//     setCookie('f', 'fugai', 1);
// }else{
//     console.log('cookie is fugai');
// }


