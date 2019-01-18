<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>${pageTitle }</title>
<%@ include file="/pages/commons/taglibs.jsp"%>
<%@ taglib uri='/tag/page-tags' prefix='p'%>
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

	<div class="container" style="margin-top: 75px;">
		<div class="es-row-wrap">
			<div class="row">
				<div class="col-md-12">
					<div class="page-header clearfix">
						<h1 style="margin-bottom: 4px;font-size: 18px;">
							<span class="glyphicon glyphicon-home"></span> 首页 &gt; 保险信息管理 
						</h1>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12" style="padding-bottom: 14px;">
					<div class="col-sm-8">
						<form id="save-form" class="form-horizontal" method="post" action="${ctx}/manage/insurance/save.do">
							<input type="hidden" id="id" name="id" value="${insurance.id }" />
							<div class="form-group">
								<div class="col-md-2 control-label">
									<label for="title">保险名称</label>
								</div>
								<div class="col-md-6 controls">
									<input type="text" id="title" name="title" class="form-control" 
										value="${insurance.title }" placeholder="保险名称">
								</div>
								<span class="points">*</span>
							</div>
							
							<div class="form-group">
								<div class="col-md-2 control-label">
									<label for="money">保险金额</label>
								</div>
								<div class="col-md-4 controls">
									<input type="text" id="money" name="money" class="form-control" 
										value="${insurance.money }" placeholder="保险金额（单位：元）">
								</div>
								<span class="points">*</span>
							</div>
							
							<div class="form-group">
								<div class="col-md-2 control-label">
									<label for="dueTime">保险期限</label>
								</div>
								<div class="col-md-4 controls">
									<input type="text" id="dueTime" name="dueTime" class="form-control" 
										value="${insurance.dueTime }" placeholder="保险期限（单位：年）">
								</div>
								<span class="points">*</span>
							</div>
							
							<div class="form-group">
								<div class="col-md-2 control-label">
									<label for="groom">是否推荐</label>
								</div>
								<div class="col-md-4 controls">
									<select name="groom" class="form-control">
										<option value="0" ${insurance.groom eq false ? 'selected' : '' }>未推荐</option>
										<option value="1" ${insurance.groom eq true ? 'selected' : '' }>已推荐</option>
									</select>
								</div>
							</div>
							
							<div class="form-group">
								<div class="col-md-2 control-label">
									<label for="insuranceTypeId">保险类别</label>
								</div>
								<div class="col-md-6 controls">
									<select name="insuranceType.id" id="insuranceTypeId" class="form-control">
										<option value="">请选择保险类别...</option>
										<c:forEach var="var" items="${insuranceTypeList }">
											<option value="${var.id }" ${insurance.insuranceType.id == var.id ? 'selected' : '' }>${var.name }</option>
										</c:forEach>
									</select>
								</div>
								<span class="points">*</span>
							</div>
							
							<div class="form-group">
								<div class="col-md-2 control-label">
									<label for="companyId">所属公司</label>
								</div>
								<div class="col-md-6 controls">
									<select name="company.id" id="companyId" class="form-control">
										<option value="">请选择保险类别...</option>
										<c:forEach var="var" items="${companyList }">
											<option value="${var.id }" ${insurance.company.id == var.id ? 'selected' : '' }>${var.name }</option>
										</c:forEach>
									</select>
								</div>
								<span class="points">*</span>
							</div>
							
							<div class="form-group">
								<div class="col-md-2 control-label">
									<label for="content">内容</label>
								</div>
								<div class="col-md-10 controls">
									<textarea id="content-textarea" style="width:100%;height:240px;">${insurance.content }</textarea>
									<input type="hidden" id="content" name="content" value="${insurance.content }">
									<script type="text/javascript">
						            	var ue = UE.getEditor('content-textarea');
						            	ue.addListener('selectionchange', function(editor) {
						            		 var content = UE.getEditor('content-textarea').getContent();
										     $('#content').val(content);
										});
						            </script>
								</div>
							</div>
							<input type="hidden" id="coverImg" name="coverImg" value="${insurance.coverImg }">
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
							<label for="picPhoto">封面图</label>
						</div>
						<div class="col-md-9 controls">
							<form id="pic-form">
					            <div class="form-group col-md-9" id="uploadForm" enctype="multipart/form-data">
					                <div class="fileinput fileinput-new" data-provides="fileinput"  id="exampleInputUpload">
					                    <div class="fileinput-new thumbnail" style="width: 150px;height: auto;max-height:150px;">
					                    	<c:choose>
						                    	<c:when test="${not empty insurance.coverImg }">
						                        	<img style="width: 100%;height: auto;max-height: 140px;" src="${ctx }${insurance.coverImg}" />
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
				var title = $("#title").val().trim();
				var money = $("#money").val().trim();
				var dueTime = $("#dueTime").val().trim();
				var insuranceTypeId = $("#insuranceTypeId").val().trim();
				var companyId = $("#companyId").val();
				if (title == "" || title == null){
					layer.msg("保险名称不能为空！", {icon:0, time:2000, shift:6, shade:[0.5, '#393D49']});
					return;
				}
				if (money == "" || money == null){
	                layer.msg("保险金额不能为空！", {icon:0, time:2000, shift:6, shade:[0.5, '#393D49']});
	                return;
				}
				if (dueTime == "" || dueTime == null){
	                layer.msg("保险期限不能为空！", {icon:0, time:2000, shift:6, shade:[0.5, '#393D49']});
	                return;
				}
				if (dueTime <= 0) {
					layer.msg("保险期限不能小于等于0年！", {icon:0, time:2000, shift:6, shade:[0.5, '#393D49']});
	                return;
				}
				if (insuranceTypeId == "" || insuranceTypeId == null){
	                layer.msg("请选择保险所属类型！", {icon:0, time:2000, shift:6, shade:[0.5, '#393D49']});
	                return;
				}
				if (companyId == "" || companyId == null){
	                layer.msg("请选择保险所属公司！", {icon:0, time:2000, shift:6, shade:[0.5, '#393D49']});
	                return;
				}
	            //与后台交互
				var index;
				var $modal = $('#save-form').parents('.modal');
	            $.ajax({
	                url:form.attr("action"),
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
	                    	layer.msg("成功保存！", {icon:6, time:2000, shade:[0.5, '#393D49']}, function(){
	                    		window.location.href="${ctx}/manage/insurance/list.do";
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
	
		// 上传图片
        function ajaxPicUpload(picID){
        	var picFile = $("#picID").val();
        	if (picFile != null && picFile != "") {
        		var data = new FormData($('#pic-form')[0]);  
                $.ajax({  
                    url: '${ctx}/manage/insurance/upload.do',  
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

