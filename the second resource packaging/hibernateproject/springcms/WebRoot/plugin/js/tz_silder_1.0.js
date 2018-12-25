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
			//������ʼ��
			this.params($slider,opts);
			//�¼��ĳ�ʼ��
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
			var x= e.clientX;//��ȡ��ǰ��갴��ȥ��x�����꣬
			//�û���ľ���
			var left = $this.offset().left;
			var nleft = x-left;
			var maxWidth = $this.width();
			//���軬����µ�left
			$this.find(".tzui-slider-handle").css("left",nleft);
			//����ٷֱ�
			var percent =  Math.ceil((nleft/maxWidth)*100);
			$this.find(".tzui-slider-range").width(percent+"%");
		},

		silderY:function($this,e){
			var y= e.clientY;//��ȡ��ǰ��갴��ȥ��x�����꣬
			//�û���ľ���
			var top = $this.offset().top;
			var ntop = y-top;
			var maxHeight = $this.height();
			//���軬����µ�left
			$this.find(".tzui-slider-handle").css("top",ntop);
			//����ٷֱ�
			var percent =  Math.ceil((ntop/maxHeight)*100);
			$this.find(".tzui-slider-range").height(percent+"%");
		},

		events : function($slider,opts){
			var flag = false;
			//�����¼���
			var obj = this;
			$slider.mousedown(function(e){
				if(!opts.horizontal)obj.silderX($(this),e);
				if(opts.horizontal)obj.silderY($(this),e);
			});

			//�����϶��¼���
			$slider.find(".tzui-slider-handle").on("mousedown",function(e){
				flag = true;
				var $this = $(this);
				var x = e.clientX;//��ȡ��ǰ��갴��ȥ��x�����꣬
				var y = e.clientY;//��ȡ��ǰ��갴��ȥ��y�����꣬
				var left = $this.position().left;//��ȡԪ�صľ���λ��left
				var top = $this.position().top;//��ȡԪ�صľ���λ��top
				var maxWidth = $this.parent().width();//��ȡ������
				var maxHeight = $this.parent().height();//��ȡ����߶�
				var sliderWidth = $this.width();//��ȡС����Ŀ��
				var sliderHeight= $this.height();//��ȡС����ĸ߶�
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