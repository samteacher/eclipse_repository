(function($){
		$.fn.tzTab = function(options){
			var opts = $.extend({},$.fn.tzTab.methods,$.fn.tzTab.defaults,options);
			this.each(function(){
				var optss = $.extend({},opts,$.fn.tzTab.parseOptions($(this)));
				opts.init($(this),optss);
			});
		};

		$.fn.tzTab.methods = {
			init : function($tab,opts){
				$tab.addClass("tzui-tabs");
				var $ul = $("<ul class='tzui-tabs-nav'></ul>");
				var liHtml = "";
				var contentHtml = "";
				var jdata = opts.tabDatas;
				var length = jdata.length;
				var className = "tzui-state-default";
				
				if(opts.index==0 || opts.index>length)opts.index=0;//边界判断
				for(var i=0;i<length;i++){
					var classStyle = "display:none";
					if(opts.index == i){
						className="tzui-tabs-active tzui-state-active";
						classStyle="";
					}
					liHtml+= "<li tab='tab-"+i+"' data-url='"+jdata[i].url+"' class='"+className+"'><a href='javascript:void(0)' class='tzui-tabs-anchor'>"+jdata[i].title+"</a></li>";
					contentHtml+="<div id='tab-"+i+"' class='tzui-tabs-panel' style='"+classStyle+"'>"+jdata[i].content+"</div>";
					className = "";					
				}
				$ul.html(liHtml);
				$tab.append($ul);
				//面板内容
				$tab.append(contentHtml);
				if(opts.width)$tab.width(opts.width);
				if(opts.height)$tab.height(opts.height);
				if(opts.background){
					$tab.css("border","2px solid "+opts.background);
					$ul.css({"background":opts.background});
					$ul.find("li>a").filter(function(){
						if(!$(this).parent().hasClass("tzui-state-active")){
							$(this).css({"background":opts.background,"color":"#fff"});
						}
					});
				}

				if(opts.linear && opts.border){
					$tab.css("border","2px solid "+opts.border);
					$ul.css({"background":"linear-gradient("+opts.linear+")"});
					$ul.find("li>a").filter(function(){
						if(!$(this).parent().hasClass("tzui-state-active")){
							$(this).css({"background":"linear-gradient("+opts.linear+")","color":"#fff"});
						}
					});
				}

				$tab.find(".tzui-tabs-nav > li").on(opts.event,function(){
					var markFlag = $(this).hasClass("tzui-tabs-active");
					if(markFlag)return;
					var tab = $(this).attr("tab");
					$(this).addClass("tzui-tabs-active tzui-state-active").siblings().removeClass("tzui-tabs-active tzui-state-active");
					$tab.find(".tzui-tabs-panel").hide();
					var $content = $tab.find("#"+tab);
					$content.show();
					$(this).find("a").removeAttr("style");
					if(opts.linear && opts.border){
						$(this).siblings().find("a").css({"background":"linear-gradient("+opts.linear+")","color":"#fff"});
					}else{
						$(this).siblings().find("a").css({"background":opts.background,"color":"#fff"});
					}
					if(opts.callback)opts.callback($(this),$content);
					//当前元素解绑事件
				});

				
			}
		};

		$.fn.tzTab.parseOptions = function($target){
			
			var datas = $target.find(".data").text();
			var json = {
				width:$target.data("width"),//选项卡的宽度
				height:$target.data("height"),//选项卡的高度
				event:$target.data("event"),//选项卡的事件类型
				background:$target.data("background"),
				linear:$target.data("linear"),
				border:$target.data("border"),
				index:$target.data("index")//默认选择哪一个
			}
			if(datas)json["tabDatas"]=eval("("+datas+")");
			return json;
		};

		$.fn.tzTab.defaults = {
			width:600,//选项卡的宽度
			height:300,//选项卡的高度
			event:"click",//选项卡的事件类型
			background:"#4684b2",
			linear:"",
			border:"",
			index:2,//默认选择哪一个
			callback:function($current,$content){
				
			},
			tabDatas:[
				{title:"选项卡1",content:"士大夫收到111","url":"user.action"},
				{title:"选项卡2",content:"士大夫收到22222","url":"delete.action"},
				{title:"选项卡3",content:"选项卡3333"}
			]
		};
	})(jQuery);