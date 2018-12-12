define(function(require, exports, module) {

    var Notify = require('common/bootstrap-notify');
	require("$");

    exports.run = function() {
    	        
    	var $container = $('#context-table-container');
        require('../../util/batch-select')($container);
        require('../../util/item-delete-layer')($container);
        
        createPageList(1);	

    };
    
});


function createPageList(currentPage){
 	var cityName = $('#search_cityName').val();
 	$.ajax({
		type: "POST",
		url: Query,
		data:{'cityName':cityName, 'pageNo': currentPage},
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
