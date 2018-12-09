define(function(require, exports, module) {

    var Notify = require('common/bootstrap-notify');
	require("$");

    exports.run = function() {
    	        
    	var $container = $('#context-table-container');
        require('../../util/short-long-text')($container);
        require('../../util/batch-select')($container);
        require('../../util/batch-delete-layer')($container);
        require('../../util/item-delete-layer')($container);
        
        createPageList(1);	

    };
    
});


function createPageList(currentPage){
 	var name = $('#search_name').val();
 	var typeId = $('#search_typeId').val();
 	$.ajax({
		type: "POST",
		url: Query,
		data:{'name':name, 'menuType.id':typeId, 'pageNo': currentPage},
		cache: false,
	    async: true,
	    beforeSend: function () {
            $('#context-table-container').html("<div align='center'><img style='width:20%;margin-left: auto;margin-right: auto;' src='../../static/images/gif/loading1.gif' /></div>");                    
        },
		success: function(data){
			$('#context-table-container').html(data);
		}
	});
}  
