define(function(require, exports, module) {
    var Validator = require('bootstrap.validator');
    require('common/validator-rules').inject(Validator);
    var Notify = require('common/bootstrap-notify');

    exports.run = function() {    
    	$(document).ready(function(){
			var _index = 0;
			var timer = null;
			// 图片轮播定时器
			function bannerTimer(){
				timer = setInterval(function(){
					_index++;
					if (_index > 2) {
						_index = 0;
					}
					$("#context-homepage a.cycle-slide").eq(_index).css({"position":"static", "display":"block"}).siblings().css({"position":"absolute", "display":"none"});
					$("#context-homepage .cycle-pager span").eq(_index).addClass("cycle-pager-active").siblings().removeClass("cycle-pager-active");
				}, 3000);
			}
			bannerTimer();
			
			// 点击轮播小圆点时触发事件
			$("#context-homepage .cycle-pager span").click(function(){
				//清除定时器
				clearInterval(timer);
				_index = $(this).index();
				$("#context-homepage a.cycle-slide").eq(_index).css({"position":"static", "display":"block"}).siblings().css({"position":"absolute", "display":"none"});
				$("#context-homepage .cycle-pager span").eq(_index).addClass("cycle-pager-active").siblings().removeClass("cycle-pager-active");
				// 重新启动定时器
				bannerTimer();
			});
		});
    }

});