$(function(){
	// 背景图
	$('body').append("<div class='ali-index-bg'></div>");
	// 背投广告
	
	if($('body').width()>1000){
		var width=($('body').width()-0)/2;
		/*$('body').append('<a href="http://dps.sj.yxdown.com/tls1382e167/840/"  class="bg_l" target="_blank" style="display:block; position:absolute; left:0px; top:0px; width:'+width+'px;height:1100px;" onfocus="this.blur();"></a><a href="http://dps.sj.yxdown.com/tls1382e167/840/" class="bg_r" target="_blank" style="display:block; position:absolute; right:0px; top:0px; width:'+width+'px; height:1100px;" onfocus="this.blur();"></a>');*/
		$('body').append('<a href="http://dps.sj.yxdown.com/tls23c1b6fc/3841/"  class="bg_l" target="_blank" style="display:block; position:fixed; left:0px; top:0px; width:'+width+'px;height:1100px;" onfocus="this.blur();"></a><a href="http://dps.sj.yxdown.com/tls23c1b6fc/3841/" class="bg_r" target="_blank" style="display:block; position:fixed; right:0px; top:0px; width:'+width+'px; height:1100px;" onfocus="this.blur();"></a>');
	}
})
resize();
function resize(){
	// 背景图
	var oWLength = $(window).width();
	var oAlength = parseInt((oWLength - 0)/2);
	$("a.bg_l, a.bg_r").css('width',oAlength+'px');
};
window.onresize = function(){ 
	resize();
};