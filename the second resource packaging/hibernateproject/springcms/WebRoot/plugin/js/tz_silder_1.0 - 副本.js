(function($){
	$.fn.tzSlider = function(options){
		var opts = $.extend({},$.fn.tzSlider.methods,$.fn.tzSlider.defaults,options);
		$("body").data("opts",opts);
		this.each(function(){
			var optss = $.extend({},$("body").data("opts"),$.fn.tzSlider.optionAttr($(this)));
			opts.init($(this),optss);
		});
	};

	$.fn.tzSlider.methods = {
		init : function($slider,opts){
			this.template($slider,opts);
			//参数初始化
			this.params($slider,opts);
			//事件的初始化
			this.events($slider,opts);
		},
		template:function($slider,opts){
			
			if(opts.horizontal){
				$slider.addClass("tzui-slider tzui-slider-uhorizontal");
			}else{
				$slider.addClass("tzui-slider tzui-slider-horizontal");
				//if(opts.width)$slider.width(opts.width);
			}

			if(opts.bgcolor){
				$slider.append("<div class='tzui-slider-range'></div>");
			}
			$slider.append("<a class='tzui-slider-handle' href='javascript:void(0);'></a>");
		},
		params : function($slider,opts){
			if(opts.bgcolor){
				$slider.find(".tzui-slider-range").width(opts.percent+"%");
			}
			var maxWidth = $slider.width();
			$slider.find(".tzui-slider-handle").css("left",(maxWidth * opts.percent)/100);
			if(opts.load)opts.load($slider,opts.percent);
		},
		events : function($slider,opts){
			var flag = false;
			//滑块事件绑定
			$slider.mousedown(function(e){
				var x= e.clientX;//获取当前鼠标按下去的x轴坐标，
				//拿滑块的距离
				var left = $(this).offset().left;
				var nleft = x-left;
				var maxWidth = $(this).width();
				//赋予滑块的新的left
				$(this).find(".tzui-slider-handle").css("left",nleft);
				//计算百分比
				var percent =  Math.ceil((nleft/maxWidth)*100);
				$(this).find(".tzui-slider-range").width(percent+"%");	
				//new tzLoading(percent,{width:200});
			});

			//滑块拖动事件绑定
			$slider.find(".tzui-slider-handle").on("mousedown",function(e){
				var x= e.clientX;//获取当前鼠标按下去的x轴坐标，
				flag = true;
				var $this = $(this);
				var left = $this.position().left;
				var maxWidth = $this.parent().width();
				var sliderWidth = $this.width();	
				var percent = 0;
				$(document).on("mousemove",function(ev){
					if(flag){
						var nx = ev.clientX;
						var nleft = nx+left-x+(sliderWidth/2)-4 ;
						if(nleft<=0)nleft=0;
						if(nleft > maxWidth)nleft = maxWidth;
						$this.css({left:nleft});
						percent =  Math.ceil((nleft/maxWidth)*100);
						$slider.find(".tzui-slider-range").width(percent+"%");	
						//new tzLoading(percent,{width:200});
					}
				}).on("mouseup",function(){
					flag = false;
					if(opts.callback)opts.callback($slider,percent);
				});
			}).on("mouseup",function(){
				flag = false;	
			});
			
		}
	};

	$.fn.tzSlider.optionAttr = function($slider){
		return {
			width:$slider.data("width"),
			percent:$slider.data("percent"),
			bgcolor:$slider.data("bgcolor")	
		}
	}
	$.fn.tzSlider.defaults = {
		bgcolor :true,
		percent:20,
		width:0,
		horizontal:true,
		load:function($silder,percent){

		},
		callback:function($silder,percent){
		
		}
	}
})(jQuery) 