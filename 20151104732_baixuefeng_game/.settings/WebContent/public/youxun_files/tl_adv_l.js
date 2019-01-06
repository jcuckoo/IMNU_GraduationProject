/*if (pageConfig.type == "default") {
	document.write("<div style='position:relative;'><a href='http://dps.sj.yxdown.com/tls0baddf0a/2258/' target='_blank' style='width:1100px;height:120px;display:block;position:absolute;z-index:99;background:#000;opacity:0;filter:alpha(opacity=0);'></a><b><embed src='http://static.yxdown.com/cjimages/swf/1100x120x00.swf' width='1100' height='120' wmode='transparent' quality='high' type='application/x-shockwave-flash' title='Adobe Flash Player'></b></div>");
}*/

(function() {
	if (document.URL.toLowerCase() == "http://www.yxdown.com/" || /(oldown|jiaocheng|olnews|olgl|olgongju)/i.test(location.pathname)) {
		//1100*120
		document.write("<div style='position:relative;'><a href='http://dps.sj.yxdown.com/tls0baddf0a/2258/' target='_blank' style='width:1100px;height:120px;display:block;position:absolute;z-index:99;background:#000;opacity:0;filter:alpha(opacity=0);'></a><b><embed src='http://static.yxdown.com/cjimages/swf/1100x120x00.swf' width='1100' height='120' wmode='transparent' quality='high' type='application/x-shockwave-flash' title='Adobe Flash Player'></b></div>");
	} else{
		//980*120
		document.write("<div style='position:relative;'><a href='http://dps.sj.yxdown.com/tls0baddf0a/2258/' target='_blank' style='width:980px;height:120px;display:block;position:absolute;z-index:99;background:#000;opacity:0;filter:alpha(opacity=0);'></a><b><embed src='http://static.yxdown.com/cjimages/swf/980x120x00.swf' width='980' height='120' wmode='transparent' quality='high' type='application/x-shockwave-flash' title='Adobe Flash Player'></b></div>");
	}
       
       if (document.URL.toLowerCase() == "http://www.yxdown.com/tag/" || document.URL.toLowerCase() == "http://www.yxdown.com/key/") {

	/*富媒体*/
	document.writeln('<script type="text/javascript">//<![CDATA[')
	document.writeln('ac_as_id = "mm_116831154_14674554_62018328";')
	document.writeln('ac_format = 1;')
	document.writeln('ac_mode = 1;')
	document.writeln('ac_group_id = 1;')
	document.writeln('ac_server_base_url = "afpeng.alimama.com/";')
	document.writeln('//]]></script>')
	document.writeln('<script type="text/javascript" src="http://afpmm.alicdn.com/g/mm/afp-cdn/JS/k.js"></script>')

}

})();
