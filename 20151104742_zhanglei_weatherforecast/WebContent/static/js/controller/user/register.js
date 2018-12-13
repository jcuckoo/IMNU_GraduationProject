define(function(require, exports, module) {
    var Validator = require('bootstrap.validator');
    require('common/validator-rules').inject(Validator);
    var Notify = require('common/bootstrap-notify');

    exports.run = function() {  
    	
        var validator = new Validator({
            element: '#register-form',
            autoSubmit: false,
            failSilently: true,
            onFormValidated: function(error, results, $form) {
                if (error) {
                    return false;
                }
                
                $('#register-btn').button('submiting').addClass('disabled');
                $.post($form.attr('action'), $form.serialize(), function(data) {
                	if(data.resultCode == 'SUCCESS'){
                		$('#register-btn').button('submiting').text('注册成功');
                		layer.msg("2秒钟后自动跳转进入登录页！", {icon:6, shade:[0.5,'#000'], time:2000}, function(){
                			window.location.href= window.app.basePath + "/index.html";
                		});
                	}
                }, 'json').error(function(){
                    Notify.danger('注册失败！');
                });
            }
        });

        validator.on('formValidate', function(elemetn, event) {

        });
        
        validator.addItem({
            element: '[name="username"]',
            required: true,
            rule: 'remote'
        });
        
        validator.addItem({
            element: '[name="name"]',
            required: true,
            rule: 'chinese byte_minlength{min:2} byte_maxlength{max:8}'
        });
        
        validator.addItem({
            element: '[name="mobile"]',
            required: true,
            rule: 'email_or_mobile'
        });
        
        validator.addItem({
            element: '[name="address"]',
            required: true
        });
        
        validator.addItem({
            element: '[name="password"]',
            required: true,
            rule: 'password'
        });
        
        validator.addItem({
            element: '[name="confirmPassword"]',
            required: true,
            rule: 'confirmation{target:#password}'
        });
        
        validator.addItem({
            element: '[name="user_terms"]',
            required: true,
            display: '注册协议'
        });
        
    };

});