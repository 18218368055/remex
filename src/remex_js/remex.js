// *** remex标准函数库 ***

var remex = {};

(function($) {
	
	//==================== jqGrid ====================
	$.fn.remexJqGrid = function(ag) {
		ag = ag || {}
		//默认配置
		var aguse = {
			datatype : "json",  //请求数据返回的类型，可选json,xml,txt
			rowNum : 10,  //一页显示多少条
			rowList : [10, 20, 30],  //可供用户选择一页显示多少条
			mtype : "post",  //ajax提交方式。post或者post，默认get
			viewrecords : true,  //定义是否要显示总记录数
			autowidth : true,  //自动宽度
			height : 300,  //表格高度，可以是数字，像素值或者百分比
			jsonReader : {
				root : "data.data",
				page : "data.pageNum",
				total : "data.totalPage",
				records : "data.total",
			},
		}
		
		$.extend(aguse, ag);
		$(this).jqGrid(aguse);
		
	}
	//==================== jqGrid End ====================
	
	
	
})(jQuery);








