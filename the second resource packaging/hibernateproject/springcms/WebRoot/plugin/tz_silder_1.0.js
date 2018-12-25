(function($){
	$.fn.tzSlider = function(options){
		var opts = $.extend({},$.fn.tzSlider.methods,$.fn.tzSlider.defaults,options);
		this.each(function(){
			opts.init($(this),opts);
		});
	};

	$.fn.tzSlider.methods = {
		init : function($slider,opts){
			this.template($slider,opts);
			//事件的初始化
			this.events($slider);
		},
		template:function($slider,opts){
			if(opts.width)$slider.width(opts.width);
			$slider.addClass("tzui-slider tzui-slider-horizontal");
			if(opts.backgroundSlider){
				$slider.append("<div class='tzui-slider-range'></div>");
			}
			$slider.append("<a class='tzui-slider-handle' href='javascript:void(0);'></a>");
			
		},
		events : function($slider){
			
			var flag = false;
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
				new tzLoading(percent,{width:200});
			});

			$slider.find(".tzui-slider-handle").on("mousedown",function(e){
				var x= e.clientX;//获取当前鼠标按下去的x轴坐标，
				flag = true;
				var $this = $(this);
				var left = $this.position().left;
				var maxWidth = $this.parent().width();
				var sliderWidth = $this.width();	
				$(document).on("mousemove",function(ev){
					if(flag){
						var nx = ev.clientX;
						var nleft = nx+left-x-sliderWidth ;
						if(nleft<=0)nleft=0;
						if(nleft > maxWidth)nleft = maxWidth;
						$this.css({left:nleft});
						var percent =  Math.ceil((nleft/maxWidth)*100);
						$slider.find(".tzui-slider-range").width(percent+"%");	
						new tzLoading(percent,{width:200});
					}
				}).on("mouseup",function(){
					flag = false;
				});
			});
			
		}
	};

	$.fn.tzSlider.defaults = {
		backgroundSlider :true,
		width:0
	}

})(jQuery) 