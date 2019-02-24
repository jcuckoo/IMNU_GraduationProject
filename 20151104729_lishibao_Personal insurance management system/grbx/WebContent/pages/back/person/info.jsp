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
							<span class="glyphicon glyphicon-home"></span> 首页 &gt; 个人信息管理 
						</h1>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12" style="padding-bottom: 14px;">
					<div class="col-sm-7">
						<form id="save-form" class="form-horizontal" method="post" action="${ctx}/manage/person/save.do">
							<input type="hidden" id="id" name="id" value="${user.id }" />
							<div class="form-group">
								<div class="col-md-3 control-label">
									<label for="username">用户名</label>
								</div>
								<div class="col-md-6 controls">
									<input type="text" id="username" name="username" class="form-control" value="${user.username }"
										placeholder="用户名作为登录账号" disabled="disabled" style="background: #fff;">
								</div>
							</div>
							
							<div class="form-group">
								<div class="col-md-3 control-label">
									<label for="truename">用户姓名</label>
								</div>
								<div class="col-md-6 controls">
									<input type="text" id="truename" name="truename" class="form-control" value="${user.truename }"
										placeholder="用户姓名">
								</div>
								<span class="points">*</span>
							</div>
							
							<div class="form-group">
								<div class="col-md-3 control-label">
									<label for="mobile">联系方式</label>
								</div>
								<div class="col-md-6 controls">
									<input type="text" id="mobile" name="mobile" class="form-control" value="${user.mobile }"
										placeholder="用户联系方式">
								</div>
								<span class="points">*</span>
							</div>
							
							<div class="form-group">
								<div class="col-md-3 control-label">
									<label for="eamil">联系邮箱</label>
								</div>
								<div class="col-md-6 controls">
									<input type="text" id="eamil" name="eamil" class="form-control" value="${user.email }"
										placeholder="用户联系邮箱">
								</div>
							</div>
							
							<div class="form-group">
								<div class="col-md-3 control-label">
									<label for="address">个人住址</label>
								</div>
								<div class="col-md-6 controls">
									<input type="text" id="address" name="address" class="form-control" value="${user.address }"
										placeholder="用户住址">
								</div>
							</div>
							
							<input type="hidden" id="picImg" name="picImg">
							<div class="col-sm-3">&nbsp;</div>
					    	<div class="col-sm-9">
						   		<button id="save-btn" data-submiting-text="正在提交" type="submit" class="btn btn-primary">
						    		<span class="glyphicon glyphicon-saved"></span> 保存
						    	</button>&nbsp;&nbsp;
						    	<button id="back-btn" type="button" class="btn btn-primary" onclick="javascript:window.history.go(-1);">
						    		<span class="glyphicon glyphicon-share-alt"></span> 返回
						    	</button>
					    	</div>
						</form>
					</div>
					<div class="col-sm-5">
						<div class="col-md-3 control-label">
							<label for="picPhoto">个人头像</label>
						</div>
						<div class="col-md-9 controls">
							<form id="pic-form">
					            <div class="form-group col-md-9" id="uploadForm" enctype="multipart/form-data">
					                <div class="fileinput fileinput-new" data-provides="fileinput"  id="exampleInputUpload">
					                    <div class="fileinput-new thumbnail" style="width: 150px;height: auto;max-height:150px;">
					                    	<c:choose>
						                    	<c:when test="${not empty user.picImg }">
						                        	<img style="width: 100%;height: auto;max-height: 140px;" src="${ctx }${user.picImg}" alt="头像" />
						                    	</c:when>
						                    	<c:otherwise>
						                    		<img style="width: 100%;height: auto;max-height: 140px;" src="${ctx }/static/images/noimage.png" alt="头像" />
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
		// 上传头像
        function ajaxPicUpload(picID){
        	var picFile = $("#picID").val();
        	if (picFile != null && picFile != "") {
        		var data = new FormData($('#pic-form')[0]);  
                $.ajax({  
                    url: '${ctx}/manage/person/upload.do',  
                    type: 'POST',  
                    data: data,  
                    dataType: 'JSON',  
                    cache: false,  
                    processData: false,  //不处理发送的数据，因为data值是FormData对象，不需要对数据做处理 
                    contentType: false   //不设置Content-type请求头
                }).done(function(data){  
                    if(data.resultCode=="SUCCESS"){  
                        layer.msg("上传成功！", {icon:1});
                        $("#picImg").val(data.data);
                    }else{  
                    	layer.msg("上传失败！", {icon:2});  
                    }  
                });
			 }else {
				 $("#picImg").val("");
			}
         }
	</script>
	<script>app.controller='person/save-modal';</script>
</body>
</html>

