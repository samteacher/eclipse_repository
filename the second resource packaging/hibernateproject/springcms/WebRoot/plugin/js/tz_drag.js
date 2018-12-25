/*
	拖拽div
*/
(function($){
	$.fn.tzDrag = function(options){
		var opts = $.extend({},$.fn.tzDrag.methods,$.fn.tzDrag.defaults,options);
		this.each(function(){
			var optss = $.extend({},opts,$.fn.tzDrag.parseOptions($(this)));
			opts.init($(this),optss);	
		});
	};

	$.fn.tzDrag.methods = {
		init:function($dialog,opts){//层拖动
			var thisObj = this;
			var mark = false;
			$dialog.css("position","absolute");
			var $dialogClone  = null;
			$dialog.on("mousedown",opts.handler,function(e){
				//镜像
				tzUtil.forbiddenSelect();
				if(opts.ghost)$dialogClone= thisObj.ghsot($dialog,opts);
				var $this = $(this).parent();

				if(!opts.handler){
					$this=$(this);
				}

				var x = e.clientX;
				var y = e.clientY;
				var left = $this.offset().left;
				var top = $this.offset().top;
				var w = $this.width();
				var h = $this.height();
				var offsetHeight = $this.parent().height() - h-2;
				var offsetWidth= $this.parent(). width() - w-2;
				var jsonData = {};
				jsonData.width=w;
				jsonData.height=h;
				mark = true;
				$(document).on("mousemove",function(e){
					if(mark){
						var nx = e.clientX;
						var ny = e.clientY;
						var nl = nx + left - x;
						var nt = ny + top - y;
						if(nl<=0)nl=1;
						if(nt<=0)nt=1;
						if(nl>=offsetWidth)nl = offsetWidth;
						if(nt>=offsetHeight)nt = offsetHeight;
						jsonData.left = nl;
						jsonData.top = nt;
						if(opts.ghost){
							$dialogClone.css({left:nl,top:nt});	
						}else{
							$this.css({left:nl,top:nt});	
						}
						if(opts.move)opts.move(jsonData,$this);
					}

				}).on("mouseup",function(){
					if(opts.ghost){
						$dialogClone.remove();
						$this.css({left:jsonData.left,top:jsonData.top});	
					}
					tzUtil.autoSelect();
					if(opts.up)opts.up($this);
					mark = false;
				});
			});
		},
		ghsot:function($dialog,opts){
			var $dialogClone = $dialog.clone();
			$dialogClone.css({"background":"#f9f9f9","opacity":0.9,"border":"1px dotted #ccc"}).find(".tzui-empty").empty();
			$("body").append($dialogClone);
			return $dialogClone;
		},	


	   }

	   $.fn.tzDrag.parseOptions = function($dialog){
			return {
				handler:$dialog.data("handler"),
				ghost:$dialog.data("ghost")
			}
	   };

	   $.fn.tzDrag.defaults = {
			handler:"",//拖动代理
			ghost:true,//是否产生镜像
			move:function(opts){
			},
            up:function(opts){
			}

	   }
})(jQuery)	