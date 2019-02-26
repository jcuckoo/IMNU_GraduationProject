define(function(require, exports, module) {

	var Notify = require('common/bootstrap-notify');

    module.exports = function($element, onSuccess) {
        $element.on('click', '[data-role=item-delete]', function() {
            var $btn = $(this),
                name = $btn.data('name'),
                message = $btn.data('message');

            if (!message) {
                message = '真的要删除该' + name + '吗？';
            }

            var index = layer.confirm(message, {icon:3, title:'系统提示'}, function(){
            	layer.msg('正在删除' + name + '，请稍等...', {icon:16, time:0, shade:[0.4, '#000']});
            	$.post($btn.data('url'), function(msg) {
                    if (msg.resultCode == "FAIL") {
                    	layer.close(index);
                    	layer.msg(msg.message, {icon:2, shade:[0.4, '#000']});
                    } else {
                        layer.close(index);
                    	createPageList(1);
                        layer.msg('删除' + name + '成功！', {icon:1, shade:[0.4, '#000']});
                    }
                }, 'json');
            });
        });
    };

});