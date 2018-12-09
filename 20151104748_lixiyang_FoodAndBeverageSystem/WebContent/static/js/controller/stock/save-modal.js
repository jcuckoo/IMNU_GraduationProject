define(function(require, exports, module) {
	require("jquery.bootstrap-datetimepicker");
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
    					layer.msg("保存成功", {icon:6, time:1000, shade:[0.4, '#000']}, function(){
    						createPageList(1);
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
            element: '[name="productNo"]',
            required: true
        });
        
        validator.addItem({
            element: '[name="productName"]',
            required: true
        });
        
        validator.addItem({
            element: '[name="stockNum"]',
            required: true
        });
        
    };

});