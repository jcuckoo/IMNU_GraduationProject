<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/pages/commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>${pageTitle }</title>
<%@ include file="/pages/commons/top.jsp" %>
<link href="${ctx}/static/css/bootstrap-fileinput.css?${random}" rel="stylesheet">
<link type="text/css" href="${ctx }/static/assets/ueditor/themes/default/css/ueditor.css" rel="stylesheet"/>
<!-- 配置文件  -->  
<script type="text/javascript" src="${ctx }/static/assets/ueditor/ueditor.config.js"></script>  
<!-- 编辑器源码文件 -->  
<script type="text/javascript" src="${ctx }/static/assets/ueditor/ueditor.all.js"></script>  
<!-- 语言包文件(建议手动加载语言包，避免在ie下，因为加载语言失败导致编辑器加载失败) -->  
<script type="text/javascript" src="${ctx }/static/assets/ueditor/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript" src="${ctx }/static/js/bootstrap-fileinput.js"></script>
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
						<h1 style="margin-bottom: 4px;font-size: 18px;">首页 &gt; 菜单管理 </h1>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12" style="padding-bottom: 14px;">
					<div class="col-sm-8">
						<form id="save-form" class="form-horizontal" method="post" action="${ctx}/manage/menu/save.do">
							<input type="hidden" id="id" name="id" value="${menu.id }" />
							<div class="form-group">
								<div class="col-md-2 control-label">
									<label for="name">菜名</label>
								</div>
								<div class="col-md-6 controls">
									<input type="text" id="name" name="name" class="form-control" 
										value="${menu.name }" placeholder="菜谱名">
								</div>
								<span class="points">*</span>
							</div>
							
							<div class="form-group">
								<div class="col-md-2 control-label">
									<label for="price">价格</label>
								</div>
								<div class="col-md-4 controls">
									<input type="text" id="price" name="price" class="form-control" 
										value="${menu.price }" placeholder="价格">
								</div>
								<span class="points">*</span>
							</div>
							
							<div class="form-group">
								<div class="col-md-2 control-label">
									<label for="score">评分</label>
								</div>
								<div class="col-md-4 controls">
									<input type="text" id="score" name="score" class="form-control" 
										value="${menu.score }" placeholder="菜谱评分，评分区间0-5">
								</div>
								<span class="points">*</span>
							</div>
							
							<div class="form-group">
								<div class="col-md-2 control-label">
									<label for="groom">是否推荐</label>
								</div>
								<div class="col-md-4 controls">
									<select name="groom" class="form-control">
										<option value="0" ${menu.groom eq false ? 'selected' : '' }>未推荐</option>
										<option value="1" ${menu.groom eq true ? 'selected' : '' }>已推荐</option>
									</select>
								</div>
							</div>
							
							<div class="form-group">
								<div class="col-md-2 control-label">
									<label for="typeId">菜系类别</label>
								</div>
								<div class="col-md-4 controls">
									<select name="menuType.id" id="typeId" class="form-control">
										<option value="">请选择菜系所属类别</option>
										<c:forEach var="var" items="${menuTypeList }">
											<option value="${var.id }" ${var.id == menu.menuType.id ? 'selected' : '' }>${var.name }</option>
										</c:forEach>
									</select>
								</div>
							</div>
							
							<div class="form-group">
								<div class="col-md-2 control-label">
									<label for="remark">菜谱简介</label>
								</div>
								<div class="col-md-10 controls">
									<textarea id="content-textarea" style="width:100%;height:240px;">${menu.content }</textarea>
									<input type="hidden" id="content" name="content" >
									<script type="text/javascript">
						            	var ue = UE.getEditor('content-textarea');
						            	ue.addListener('selectionchange', function(editor) {
						            		 var content = UE.getEditor('content-textarea').getContent();
										     $('#content').val(content);
										});
						            </script>
								</div>
							</div>
							<input type="hidden" id="coverImg" name="coverImg" value="${menu.coverImg }">
							<div class="col-sm-2">&nbsp;</div>
					    	<div class="col-sm-10">
						   		<button id="save-btn" data-submiting-text="正在提交" type="submit" class="btn btn-primary">
						    		<span class="glyphicon glyphicon-saved"></span> 保存
						    	</button>&nbsp;&nbsp;
						    	<button id="back-btn" type="button" class="btn btn-primary" onclick="javascript:window.history.go(-1);">
						    		<span class="glyphicon glyphicon-share-alt"></span> 返回
						    	</button>
					    	</div>
						</form>
					</div>
					<div class="col-sm-4">
						<div class="col-md-3 control-label">
							<label for="picPhoto">菜单图</label>
						</div>
						<div class="col-md-9 controls">
							<form id="pic-form">
					            <div class="form-group col-md-9" id="uploadForm" enctype="multipart/form-data">
					                <div class="fileinput fileinput-new" data-provides="fileinput"  id="exampleInputUpload">
					                    <div class="fileinput-new thumbnail" style="width: 150px;height: auto;max-height:150px;">
					                    	<c:choose>
						                    	<c:when test="${not empty menu.coverImg }">
						                        	<img style="width: 100%;height: auto;max-height: 140px;" src="${ctx }${menu.coverImg}" />
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
			$("#save-form").submit(function (e) {
	            var form = $(this);
	            // 阻止表单默认提交
	            e.preventDefault();
	            // 参数校验
				var name = $("#name").val().trim();
				var price = $("#price").val().trim();
				var score = $("#score").val().trim();
				var typeId = $("#typeId").val();
				if (name == "" || name == null){
					layer.msg("菜谱名不能为空！", {icon:0, time:2000, shift:6, shade:[0.5, '#393D49']});
					return;
				}
				if (price == "" || price == null){
	                layer.msg("价格不能为空！", {icon:0, time:2000, shift:6, shade:[0.5, '#393D49']});
	                return;
				}
				if (score == "" || score == null){
	                layer.msg("评分不能为空！", {icon:0, time:2000, shift:6, shade:[0.5, '#393D49']});
	                return;
				}
				if (score > 5 || score < 0) {
					layer.msg("评分区间为0~5！", {icon:0, time:2000, shift:6, shade:[0.5, '#393D49']});
	                return;
				}
				if (typeId == "" || typeId == null){
	                layer.msg("请选择菜系类型！", {icon:0, time:2000, shift:6, shade:[0.5, '#393D49']});
	                return;
				}
	            //与后台交互
				var index;
				var $modal = $('#save-form').parents('.modal');
	            $.ajax({
	                url:"${ctx}/manage/menu/save.do",
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
	                    	layer.msg("提交成功！", {icon:6, time:2000, shade:[0.5, '#393D49']}, function(){
	                    		window.location.href="${ctx}/manage/menu/list.do";
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

