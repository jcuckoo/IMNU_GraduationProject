<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/pages/commons/taglibs.jsp"%>

<script type="text/javascript" src="${ctx}/static/js/ajaxfileupload.js"></script>

<div class="modal-dialog">
	<div class="modal-content">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal">×</button>
			<h4 class="modal-title">上传视频文件</h4>
		</div>
		<div class="modal-body">
			<form id="import-create-form" onsubmit="return fileUpload();" enctype="multipart/form-data"
				action="${ctx}/manage/file/upload.do" method="post">
				<div class=" row form-group">
					<div class="col-md-2 control-label">
						<label>视频文件</label>
					</div>
					<div class="col-md-9 controls">
						<input id="fileToUpload" type="file" name="file">
					</div>
				</div>
			</form>

			<script type="text/javascript">
                function fileUpload() {
                    var fileType = $.trim($("#fileToUpload").val());
                    if (fileType == null || fileType == "") {
                        layer.alert("请选择要上传的视频文件！", {icon:0});
                        return false;
                    }
                    var _index = fileType.lastIndexOf(".");
                    if(_index < 0) {
                        layer.alert("上传的文件格式不正确，请选择mp4视频文件！", {icon:0});
                        return false;
                    }
                    var ext = fileType.substring(_index + 1, fileType.length);
                    if(ext != "mp4") {
                        layer.alert("上传的文件格式不正确，请选择mp4视频文件！", {icon:0});
                        return false;
                    }

                    $('#import-create-btn').button('submiting').addClass('disabled');
                    $('#import-create-btn').prop('disabled', true);
                    var $modal = $('#import-create-form').parents('.modal');
                    var templateType = $("#templateType").val();
                    $.ajaxFileUpload({
                        url : "${ctx}/manage/file/upload.do",
                        secureuri : false,
                        fileElementId : 'fileToUpload',
                        dataType : 'text',
                        success : function(data, status) {
                        	var result = eval("("+data+")");
                            if (result.resultCode == 'SUCCESS'){
                            	$('#import-create-btn').button('submiting').text('上传完成');
                            	layer.msg("上传成功！", {icon:1, time:2000, shade:[0.5,'#000']}, function(){
                            		$modal.modal('hide');
                            		$("#videoUrl").val(result.data);
                            		$("#mp4").attr("src", "${ctx}/" + result.data);
                            	});
                            }else {
								layer.msg("上传失败！", {icon:0});
							}
                        },
                        error : function(data, status, e) {
                            alert(e);
                        }
                    });
                    return true;
                }
			</script>
		</div>
		<div class="modal-footer">
			<button id="import-create-btn" data-submiting-text="正在上传"
				class="btn btn-primary pull-right" data-toggle="form-submit"
				data-target="#import-create-form" type="submit" onclick="fileUpload();">上传</button>
			<button type="button" class="btn btn-link pull-right"
				data-dismiss="modal">取消</button>
		</div>
	</div>
</div>