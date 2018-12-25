(function($){
	for(i in document.images)document.images[i].ondragstart=function(){return false;}	
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
				if(opts.height)$slider.height(opts.height);
			}else{
				$slider.addClass("tzui-slider tzui-slider-horizontal");
				if(opts.width)$slider.width(opts.width);
			}
			if(opts.bgcolor){
				$slider.append("<div class='tzui-slider-range'></div>");
			}
			$slider.append("<a class='tzui-slider-handle' draggable='false' href='javascript:void(0);'></a>");
		},

		params : function($slider,opts){
			if(!opts.horizontal){
				var maxWidth = $slider.width();
				$slider.find(".tzui-slider-handle").css("left",(maxWidth * opts.percent)/100);
				if(opts.bgcolor)$slider.find(".tzui-slider-range").width(opts.percent+"%");
			}

			if(opts.horizontal){
				var maxHeight = $slider.height();
				$slider.find(".tzui-slider-handle").css("top",(maxHeight * opts.percent)/100);
				if(opts.bgcolor)$slider.find(".tzui-slider-range").height(opts.percent+"%");
			}
			
			if(!opts.silderColor){
				if(opts.randomcolor && opts.bgcolor){
					$slider.find(".tzui-slider-range").css("background",tzUtil.getRandomColor());
				}
			}else{
				$slider.find(".tzui-slider-range").css("background","#"+opts.silderColor);
			}
			
			if(opts.load)opts.load($slider,opts.percent);
		},

		silderX:function($this,e){
			var x= e.clientX;//获取当前鼠标按下去的x轴坐标，
			//拿滑块的距离
			var left = $this.offset().left;
			var nleft = x-left;
			var maxWidth = $this.width();
			//赋予滑块的新的left
			$this.find(".tzui-slider-handle").css("left",nleft);
			//计算百分比
			var percent =  Math.ceil((nleft/maxWidth)*100);
			$this.find(".tzui-slider-range").width(percent+"%");
		},

		silderY:function($this,e){
			var y= e.clientY;//获取当前鼠标按下去的x轴坐标，
			//拿滑块的距离
			var top = $this.offset().top;
			var ntop = y-top;
			var maxHeight = $this.height();
			//赋予滑块的新的left
			$this.find(".tzui-slider-handle").css("top",ntop);
			//计算百分比
			var percent =  Math.ceil((ntop/maxHeight)*100);
			$this.find(".tzui-slider-range").height(percent+"%");
		},

		events : function($slider,opts){
			var flag = false;
			//滑块事件绑定
			var obj = this;
			$slider.mousedown(function(e){
				if(!opts.horizontal)obj.silderX($(this),e);
				if(opts.horizontal)obj.silderY($(this),e);
			});

			//滑块拖动事件绑定
			$slider.find(".tzui-slider-handle").on("mousedown",function(e){
				flag = true;
				var $this = $(this);
				var x = e.clientX;//获取当前鼠标按下去的x轴坐标，
				var y = e.clientY;//获取当前鼠标按下去的y轴坐标，
				var left = $this.position().left;//获取元素的绝对位置left
				var top = $this.position().top;//获取元素的绝对位置top
				var maxWidth = $this.parent().width();//获取滑块宽度
				var maxHeight = $this.parent().height();//获取滑块高度
				var sliderWidth = $this.width();//获取小滑块的宽度
				var sliderHeight= $this.height();//获取小滑块的高度
				var percent = 0;
				var horizontalMark = opts.horizontal;
				$(document).on("mousemove",function(ev){
					if(flag){
						if(!horizontalMark){
							var nx = ev.clientX;
							var nleft = nx+left-x+(sliderWidth/2)-4 ;
							if(nleft<=0)nleft=0;
							if(nleft > maxWidth)nleft = maxWidth;
							$this.css({left:nleft});
							percent =  Math.ceil((nleft/maxWidth)*100);
							$slider.find(".tzui-slider-range").width(percent+"%");
						}else{
							var ny = ev.clientY;
							var ntop = ny+top-y+(sliderHeight/2)-4 ;
							if(ntop<=0)ntop=0;
							if(ntop > maxHeight)ntop = maxHeight;
							$this.css({top:ntop});
							percent =  Math.ceil((ntop/maxHeight)*100);
							$slider.find(".tzui-slider-range").height(percent+"%");
						}
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
			height:$slider.data("height"),
			percent:$slider.data("percent"),
			bgcolor:$slider.data("bgcolor"),
			silderColor:$slider.data("sildercolor"),
			horizontal:	$slider.data("horizontal")
		}
	};

	$.fn.tzSlider.defaults = {
		bgcolor :true,
		percent:20,
		width:0,
		height:0,
		horizontal:true,
		randomcolor:true,
		silderColor:"",
		load:function($silder,percent){

		},
		callback:function($silder,percent){
		
		}
	}

})(jQuery) 