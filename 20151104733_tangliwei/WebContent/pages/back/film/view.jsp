<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/pages/commons/taglibs.jsp"%>
<link rel="stylesheet" href="${ctx}/static/css/jsmodern.min.css">
<script type="text/javascript" src="${ctx }/static/js/jsmodern.min.js"></script>
<div class="modal-dialog">
	<div class="modal-content">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			<h4 class="modal-title">电影信息详情</h4>
		</div>
		<div class="modal-body">
			<div id="video" style="width:480px;height: 240px;margin: 0px auto;">
				<video src="${ctx }${film.videoUrl}"></video>
			</div>
		</div>
		<div class="modal-footer">
			<button type="button" class="btn btn-link" data-dismiss="modal">关闭</button>
		</div>
	</div>
</div>
<script type="text/javascript">
	jsModern.video("#video");
</script>