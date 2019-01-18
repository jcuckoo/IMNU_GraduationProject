define(function(require, exports, module) {
    var Validator = require('bootstrap.validator');
    require('common/validator-rules').inject(Validator);
    var Notify = require('common/bootstrap-notify');

    exports.run = function() {  
    	var $modal = $('#save-form').parents('.modal');
        var validator = new Validator({
            element: '#save-form',
            autoSubmit: false,
            failSilently: true,
            onFormValidated: function(error, results, $form) {
                if (error) {
                    return false;
                }
                $('#save-btn').addClass('disabled');
                $.post($form.attr('action'), $form.serialize(), function(data) {
                	if (data.resultCode == "SUCCESS") {
                		$('#save-btn').text("保存成功");
    					$modal.modal('hide');
    					layer.msg("密码修改成功，2秒后自动进入登录页！", {icon:6, time:2000, shade:[0.4, '#000']}, function(){
    						window.location.href = window.app.basePath + "/logout.do";
    					});
					}else {
						Notify.danger(data.message);
						$('#save-btn').removeClass('disabled');
					}
                }, 'json').error(function(){
                    Notify.danger('操作失败');
                });
            }
        });

        validator.on('formValidate', function(elemetn, event) {

        });
        
        validator.addItem({
            element: '[name="password"]',
            required: true
        });

        validator.addItem({
            element: '[name="newPassword"]',
            required: true,
            rule: 'password'
        });
        
        validator.addItem({
            element: '[name="confirmPassword"]',
            required: true,
            rule: 'confirmation{target:#newPassword}',
            display: '确认密码'
        });
        
    };

});