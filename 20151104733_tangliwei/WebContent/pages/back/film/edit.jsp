<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/pages/commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>电影管理-滨海影视网</title>
<%@ include file="/pages/commons/top.jsp" %>
<link href="${ctx}/static/css/bootstrap-fileinput.css?${random}" rel="stylesheet">
<link rel="stylesheet" href="${ctx}/static/css/jsmodern.min.css">
<link type="text/css" href="${ctx }/static/assets/ueditor/themes/default/css/ueditor.css" rel="stylesheet"/>
<!-- 配置文件  -->  
<script type="text/javascript" src="${ctx }/static/assets/ueditor/ueditor.config.js"></script>  
<!-- 编辑器源码文件 -->  
<script type="text/javascript" src="${ctx }/static/assets/ueditor/ueditor.all.js"></script>  
<!-- 语言包文件(建议手动加载语言包，避免在ie下，因为加载语言失败导致编辑器加载失败) -->  
<script type="text/javascript" src="${ctx }/static/assets/ueditor/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript" src="${ctx }/static/js/bootstrap-fileinput.js"></script>
<script type="text/javascript" src="${ctx }/static/js/jsmodern.min.js"></script>
</head>
<body>
	<!-- 头部begin -->
	<%@ include file="/pages/back/header.jsp" %>
	<!-- 头部end -->

	<div class="container">
		<div class="es-row-wrap">
			<div class="row">
				<div class="col-md-12">
					<div class="page-header clearfix">
						<h1 style="margin-bottom: 4px;font-size: 18px;">首页 &gt; 新增/编辑电影 </h1>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12" style="padding-bottom: 14px;">
					<div class="col-sm-8">
						<form id="save-form" class="form-horizontal" method="post" action="${ctx}/manage/film/save.do">
							<input type="hidden" id="id" name="id" value="${film.id }" />
							<div class="form-group">
								<div class="col-md-2 control-label">
									<label for="title">电影名</label>
								</div>
								<div class="col-md-6 controls">
									<input type="text" id="title" name="title" class="form-control" 
										value="${film.title }" placeholder="电影名">
								</div>
								<span class="points">*</span>
							</div>
							
							<div class="form-group">
								<div class="col-md-2 control-label">
									<label for="score">评分</label>
								</div>
								<div class="col-md-4 controls">
									<input type="text" id="score" name="score" class="form-control" 
										value="${film.score }" placeholder="电影评分，评分区间0-5">
								</div>
								<span class="points">*</span>
							</div>
							
							<div class="form-group">
								<div class="col-md-2 control-label">
									<label for="vip">是否开放</label>
								</div>
								<div class="col-md-4 controls">
									<select name="vip" class="form-control">
										<option value="0" ${film.vip eq false ? 'selected' : '' }>免费</option>
										<option value="1" ${film.vip eq true ? 'selected' : '' }>VIP</option>
									</select>
								</div>
							</div>
							
							<div class="form-group">
								<div class="col-md-2 control-label">
									<label for="groom">是否推荐</label>
								</div>
								<div class="col-md-4 controls">
									<select name="groom" class="form-control">
										<option value="0" ${film.groom eq false ? 'selected' : '' }>未推荐</option>
										<option value="1" ${film.groom eq true ? 'selected' : '' }>已推荐</option>
									</select>
								</div>
							</div>
							
							<div class="form-group">
								<div class="col-md-2 control-label">
									<label for="typeId">电影类别</label>
								</div>
								<div class="col-md-4 controls">
									<select name="filmType.id" id="typeId" class="form-control">
										<option value="">请选择电影类别</option>
										<c:forEach var="var" items="${filmTypeList }">
											<option value="${var.id }" ${var.id == film.filmType.id ? 'selected' : '' }>${var.name }</option>
										</c:forEach>
									</select>
								</div>
							</div>
							
							<div class="form-group">
								<div class="col-md-2 control-label">
									<label>视频文件</label>
								</div>
								<div class="col-md-4 controls">
									<input type="hidden" id="videoUrl" name="videoUrl" value="${film.videoUrl}">
									<a href="javascript:void(0);" class="btn btn-sm btn-info" data-toggle="modal"
										data-url="${ctx}/manage/film/uploadPage.do" data-target="#modal">上传视频</a>
								</div>
							</div>
							
							<div class="form-group">
								<div class="col-md-2 control-label">
									<label>&nbsp;</label>
								</div>
								<div id="video" class="col-md-10 controls" style="height: 240px;">
									<video src="${ctx }${empty film.videoUrl ? '/static/video/video.mp4' : film.videoUrl}" id="mp4"></video>
								</div>
							</div>
							
							<div class="form-group">
								<div class="col-md-2 control-label">
									<label for="content">影片介绍</label>
								</div>
								<div class="col-md-10 controls">
									<textarea id="content-textarea" style="width:100%;height:240px;">${film.content }</textarea>
									<input type="hidden" id="content" name="content" value="${film.content }">
									<script type="text/javascript">
						            	var ue = UE.getEditor('content-textarea');
						            	ue.addListener('selectionchange', function(editor) {
						            		 var content = UE.getEditor('content-textarea').getContent();
										     $('#content').val(content);
										});
						            </script>
								</div>
							</div>
							<input type="hidden" id="coverImg" name="coverImg" value="${film.coverImg }">
							<div class="col-sm-2">&nbsp;</div>
					    	<div class="col-sm-10">
						   		<button id="save-btn" data-submiting-text="正在提交" type="submit" class="btn btn-primary">
						    		<span class="glyphicon glyphicon-saved"></span> 上传
						    	</button>&nbsp;&nbsp;
						    	<button id="back-btn" type="button" class="btn btn-primary" onclick="javascript:window.history.go(-1);">
						    		<span class="glyphicon glyphicon-share-alt"></span> 返回
						    	</button>
					    	</div>
						</form>
					</div>
					<div class="col-sm-4">
						<div class="col-md-3 control-label">
							<label for="picPhoto">封面图</label>
						</div>
						<div class="col-md-9 controls">
							<form id="pic-form">
					            <div class="form-group col-md-9" id="uploadForm" enctype="multipart/form-data">
					                <div class="fileinput fileinput-new" data-provides="fileinput"  id="exampleInputUpload">
					                    <div class="fileinput-new thumbnail" style="width: 150px;height: auto;max-height:150px;">
					                    	<c:choose>
						                    	<c:when test="${not empty film.coverImg }">
						                        	<img style="width: 100%;height: auto;max-height: 140px;" src="${ctx }${film.coverImg}" />
						                    	</c:when>
						                    	<c:otherwise>
						                    		<img style="width: 100%;height: auto;max-height: 140px;" src="${ctx }/static/images/noimage.png" />
						                    	</c:otherwise>
					                    	</c:choose>
					                    </div>
					                    <div class="fileinput-preview fileinput-exists thumbnail" style="max-width: 150px; max-height: 150px;"></div>
					                    <div>
					                        <span class="btn btn-primary btn-file">
					                            <span class="fileinput-new">选择文件</span>
					                            <span class="fileinput-exists">换一张</span>
					                            <input type="file" name="file" id="picID" accept="image/gif,image/jpeg,image/x-png" onchange="ajaxPicUpload('picID');"/>
					                        </span>
					                        <a href="javascript:;" class="btn btn-warning fileinput-exists" data-dismiss="fileinput">移除</a>
					                    </div>
					                </div>
					            </div>
				            </form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- 底部begin -->
	<%@ include file="/pages/commons/bottomjs.jsp" %>
	<!-- 底部end -->
	<script type="text/javascript">
		$(function(){
			jsModern.video("#video");
			
			$("#save-form").submit(function (e) {
	            var form = $(this);
	            // 阻止表单默认提交
	            e.preventDefault();
	            // 参数校验
				var title = $("#title").val().trim();
				if (title == "" || title == null){
					layer.msg("电影名不能为空！", {icon:0, time:2000, shift:6, shade:[0.5, '#393D49']});
					return;
				}
				var score = $("#score").val().trim();
				if (score == "" || score == null){
	                layer.msg("评分不能为空！", {icon:0, time:2000, shift:6, shade:[0.5, '#393D49']});
	                return;
				}
				if (score > 5 || score < 0) {
					layer.msg("评分区间为0~5！", {icon:0, time:2000, shift:6, shade:[0.5, '#393D49']});
	                return;
				}
				var typeId = $("#typeId").val();
				if (typeId == "" || typeId == null){
	                layer.msg("请选择电影类型！", {icon:0, time:2000, shift:6, shade:[0.5, '#393D49']});
	                return;
				}
				var videoUrl = $("#videoUrl").val().trim();
				if (videoUrl == "" || videoUrl == null){
	                layer.msg("请上传电影视频文件！", {icon:0, time:2000, shift:6, shade:[0.5, '#393D49']});
	                return;
				}
				var content = $("#content").val().trim();
				if (content == "" || content == null){
	                layer.msg("电影内容介绍不能为空！", {icon:0, time:2000, shift:6, shade:[0.5, '#393D49']});
	                return;
				}
	            //与后台交互
				var index;
				var $modal = $('#save-form').parents('.modal');
	            $.ajax({
	                url:"${ctx}/manage/film/save.do",
	                type:"POST",
	                dataType:"JSON",
	                data:form.serialize(),
	                beforeSend: function () {
	                    index = layer.msg("提交中，请稍候...", {icon:16, shade:[0.5, '#393D49']});
	                    // 禁用按钮防止重复提交
	                    $("#save-btn").attr({disabled: "disabled"});
	                },
	                success:function (data) {
	                    if(data.resultCode=="SUCCESS") {
	                    	$modal.modal('hide');
	                    	layer.msg("提交成功，管理员审核通过后显示！", {icon:6, time:2000, shade:[0.5, '#393D49']}, function(){
	                    		window.location.href="${ctx}/manage/film/list.do";
	                    	});
	                    	
						}else {
							layer.msg(data.message, {icon:5, time:2000, shade:[0.5, '#393D49']});
							$("#save-btn").removeAttr("disabled");
						}
	                },complete: function () {
	                    layer.close(index);
	                    $("#save-btn").removeAttr("disabled");
	                },
					error:function (data) {
	                    layer.msg(data.message, {icon:5,time:2000})
	                }
	            });
	        });
		});
	
		// 上传头像
        function ajaxPicUpload(picID){
        	var picFile = $("#picID").val();
        	if (picFile != null && picFile != "") {
        		var data = new FormData($('#pic-form')[0]);  
                $.ajax({  
                    url: '${ctx}/manage/file/upload.do',  
                    type: 'POST',  
                    data: data,  
                    dataType: 'JSON',  
                    cache: false,  
                    processData: false,  //不处理发送的数据，因为data值是FormData对象，不需要对数据做处理 
                    contentType: false   //不设置Content-type请求头
                }).done(function(data){  
                    if(data.resultCode=="SUCCESS"){  
                        layer.msg("上传成功！", {icon:1});
                        $("#coverImg").val(data.data);
                    }else{  
                    	layer.msg("上传失败！", {icon:2});  
                    }  
                });
			 }else {
				 $("#coverImg").val("");
			}
         }
	</script>
</body>
</html>

