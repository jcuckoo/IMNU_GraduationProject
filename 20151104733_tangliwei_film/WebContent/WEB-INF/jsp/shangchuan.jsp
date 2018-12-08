<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="apple-touch-fullscreen" content="yes">
        <meta name="apple-mobile-web-app-capable" content="yes">
        <meta name="apple-mobile-web-app-status-bar-style" content="black">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
        <meta name="format-detection" content="telephone=no">

        <title>信息照片上传</title>

        <link rel="stylesheet" type="text/css" href="css/base.css">
        <link rel="stylesheet" type="text/css" href="css/home.css">
		<script>
function submit()
{
document.forms[0].submit()
}
//判断是否填写上传人并已选择上传文件
function check(){
    var username = document.getElementById("username").value;
    var uploadfile = document.getElementById("uploadfile").value;
    if(username==""){
        alert("填写上用户");
        return false;
    }
    if(uploadfile.length==0||file==""){
        alert("请选择上传照片");
        return false;
    }
    return true;
}
</script>
    </head>
    <body>
        <section class="aui-content">
            <div style="height:20px;"></div>
            <div class="aui-content-up">
                <form action="${pageContext.request.contextPath }/fileUpload" name="form1" method="post" 
                enctype="multipart/form-data" onsubmit="return check()">
                    <div class="aui-content-up-form">
                        <h2>上传宝贝</h2>
                    </div>
                    <div class="aui-form-group clear">
                        <label class="aui-label-control">
                            用户名 <em>*</em>
                        </label>
                        <div class="aui-form-input">
                            <input type="text" class="aui-form-control-two" name="username" onBlur="checkna()" id="username" placeholder="请输入用户名"/>
                           
                        </div>
                    </div>
                    <div class="aui-form-group clear">
                        <label class="aui-label-control">
                            商品名称 <em>*</em>
                        </label>
                        <div class="aui-form-input">
                            <input type="text" class="aui-form-control-two" name="shangpinname" id="2" placeholder="请输入商品名称" onBlur="checkpsd1()"/>
                            
                        </div>
                    </div>
                    <div class="aui-form-group clear">
                        <label class="aui-label-control">
                           用户电话 <em>*</em>
                        </label>
                        <div class="aui-form-input">
                            <input type="text" class="aui-form-control-two" name="username" id="3" placeholder="请输入价格" onBlur="checkpsd2()" required/>
                         
                        </div>
                    </div>
                   
                    <div class="aui-form-group clear">
                        <label class="aui-label-control">
                            商品照片<em>*</em>
                            <span>小于2M</span>
                        </label>
                        <div class="aui-form-input">
                            <div class="aui-content-img-box aui-content-full">
                                <div class="aui-photo aui-up-img clear">
                                    <section class="aui-file-up fl">
                                        <img src="img/up.png" class="add-img">
                                        <input type="file" name="uploadfile" id="uploadfile" class="file" value="" accept="image/jpg,image/jpeg,image/png,image/bmp" multiple="multiple"/>
                                    </section>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="aui-form-group-text">
                        <h3>请认真阅读要求:</h3>
                        <p>请在光照充足的地方给您的宝贝照相，请务必保证照片的真实性。</p>
                    </div>
                </form>
            </div>
            <div class="aui-btn-default">
                <a class="aui-btn aui-btn-account" href="javascript:submit();" style="color: #FFFFFF">保存并提交审核</a>
            </div>
        </section>
        <!-- mask begin -->
        <div class="aui-mask aui-works-mask">
            <div class="aui-mask-content">
                <p class="aui-delete-text">确定要删除你上传的商品？</p>
                <p class="aui-check-text">
                    <span class="aui-delete aui-accept-ok">确定</span>
                    <span class="aui-accept-no">取消</span>
                </p>
            </div>
        </div>

    </body>
</html>