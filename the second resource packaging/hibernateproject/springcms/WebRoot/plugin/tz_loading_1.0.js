/*
	版本：v1.0
	作者：keke
	时间:2015-01-18 23:25
	描述：提示框
	调用方式:
	new tzLoading("请稍后数据sdfsdf加载中....");
	new tzLoading("请稍后数据sdfsdf加载中....",{timeout:1,width:360});
	loading("请注意士大夫",2);==new.tzLoading("请注意士大夫....",{timeout:2});
	层叠号(z-index):100;
*/
var tzLoading = function(message,options){
	var opts = $.extend({},options)
	this.init(message,opts.timeout,opts);
};


tzLoading.prototype = {
	init : function(message,timeout,opts){
		var $loading = this.template(message,opts);
		//定位
		tzUtil._position($loading).resize($loading);
		//事件绑定
		this.events($loading,opts);
		//时间关闭
		this.timeout($loading,timeout);
	},
	
	template:function(content,opts){
		var $loading = $("#tzloading");
		if($loading.length==0){
			$loading = $("<div id='tzloading' title='点我关闭' class='tzui-loading'></div>");
			var $loadingGif = $("<div class='tzui-loading-gif'></div>");
			var $loadingContent = $("<div class='tzui-loading-cnt'></div>");
			$loadingGif.html("<img src='../images/loaders/loader2.gif'>");
			$loadingContent.html(content);
			$loading.append($loadingGif).append($loadingContent);
			$("body").append($loading);
			if(opts.overlay){
				$("body").append("<div class='tzui-loading-overlay'></div>");
				$loading.next().click(function(){
					$(this).remove();
					$loading.trigger("click");
				});
			}
			//初始化完毕的回调方法
			if(opts.load)opts.load($loading);
		}else{
			$loading.find(".tzui-loading-cnt").html(content);
		}
		if(opts.width){
			$loading.width(opts.width);
		}else{		
			var width = $loading.find(".tzui-loading-cnt").width()+50;
			$loading.width(width);
		}
		if(opts.height)$loading.height(opts.height);
		return $loading;
	},

	events :function($loading,opts){
		$loading.click(function(){
			$(this).next().remove();
			tzUtil.animates($(this),"slideUp");
			if(opts.callback)opts.callback($loading);
		});
	},

	timeout:function($loading,timeout){
		var timer = null;
		if(timeout+"".isEmpty() && timeout >0){
			clearTimeout(timer);
			timer = setTimeout(function(){
				//事件的触发
				$loading.trigger("click");
			},timeout*500);
		}
	}
};

var  loading = function(message,timeout,overlay){
	new tzLoading(message,{"timeout":timeout,overlay:overlay});
}

