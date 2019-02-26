define(function(require, exports, module) {

	var Notify = require('common/bootstrap-notify');

    module.exports = function($element) {
        
        $element.on('click', '[data-role=batch-pay]', function() {
            
        	var $btn = $(this);
        		name = $btn.data('name');

            var ids = [];
            $element.find('[data-role=batch-item]:checked').each(function(){
                ids.push(this.value);
            });

            if (ids.length == 0) {
                Notify.danger('未选中任何' + name);
                return ;
            }

            var index = layer.confirm('确定要结算选中的' + ids.length + '条' + name + '吗？', {icon:3, title:'系统提示'}, function(){
            	$element.find('.btn').addClass('disabled');

                layer.msg('正在结算' + name + '，请稍等...', {icon:16, time:0, shade:[0.4, '#000']});
                $.post($btn.data('url')+'?id='+ids, {'id':ids}, function(msg){
                	if(msg.resultCode == "FAIL"){
                		layer.close(index);
                		layer.msg(msg.message, {icon:2, shade:[0.4, '#000']});
                	}else{
                        layer.close(index);
                		createPageList(1);
                		layer.msg('结算' + name + '成功！', {icon:1, shade:[0.4, '#000']});
                	}             
                }, "json");
            });

        });

    };

});