<%@ page language='java' import='java.util.*' pageEncoding='utf-8'%>
<script type="text/javascript">
	var app = {};
  	app.debug = false;
  	app.version = '${random}';
  	app.httpHost = '${contextPath}';
  	app.basePath = '${ctx}';
  	app.theme = 'default-b';
  	app.themeGlobalScript = 'theme/global-script';
  	app.jsPaths = {"common":"common"};
  	app.config = {"loading_img_path":"${ctx}\/static\/images\/gif\/loading.gif?6.15.3"};
  	app.controller = '';
  	app.scripts = null;
  	app.lessonCopyEnabled = '1';
  	app.mainScript = '${ctx}/static/js/admin-app.js?6.15.3';
</script>
<script type="text/javascript" src="${ctx}/static/assets/libs/seajs/seajs/2.2.1/sea.js?6.15.3"></script>
<script type="text/javascript" src="${ctx}/static/assets/libs/seajs/seajs-style/1.0.2/seajs-style.js?6.15.3"></script>
<script type="text/javascript" src="${ctx}/static/assets/libs/seajs-global-config.js?6.15.3"></script>
<script type="text/javascript">seajs.use(app.mainScript);</script>

<div id="modal" class="modal fade" style="overflow: auto;"></div>


