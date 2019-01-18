define(function(require, exports, module) {

    var Notify = require('common/bootstrap-notify');
	require("$");

    exports.run = function() {
    	        
    	var $container = $('#context-table-container');
        require('../../util/item-delete-layer')($container);
        
        createPageList(1);	
    };
    
});


function createPageList(currentPage){
	var number = $('#search_number').val();
 	var name = $('#search_name').val();
 	$.ajax({
		type: "POST",
		url: Query,
		data:{'number':number, 'name':name, 'pageNo': currentPage},
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
