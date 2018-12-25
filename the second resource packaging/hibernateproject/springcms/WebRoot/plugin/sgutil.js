String.prototype.isEmpty = function(){
	var val = this;
	val = $.trim(val);
	if (val== null)
		return true;
	if (val == undefined || val == 'undefined')
		return true;
	if (val == "")
		return true;
	if (val.length == 0)
		return true;
	if (!/[^(^\s*)|(\s*$)]/.test(val))
		return true;
	return false;
};

String.prototype.isNotEmpty = function(){
	return !this.isEmpty();
}

String.prototype.replaceAll = function(str,target){
	return this.replace(new RegExp(str,"ig"),target);
}

var tzUtil = {
	_position : function($dom){//æ”÷–∂®Œª
		var windowWidth = $(window).width();
		var windowHeight= $(window).height();
		var width = $dom.width();
		var height = $dom.height();
		var left = (windowWidth - width)/2;
		var top = (windowHeight - height)/2;
		$dom.css({left:left,top:top});
		return this;
	},

	resize : function($dom){
		var $this = this;
		$(window).resize(function(){
			$this._position($dom);	
		});
	},
	animates:function($dom,mark){
		switch(mark){
			case "fadeOut":$dom.fadeOut("slow",function(){$(this).remove();});break;
			case "slideUp":$dom.slideUp("slow",function(){$(this).remove();});break;
			case "fadeIn":$dom.fadeIn("slow");break;
			case "slideDown":$dom.slideDown("slow");break;
		}
	},

	isEmpty:function(str){
		val = $.trim(val);
		if (val == null)
			return true;
		if (val == undefined || val == 'undefined')
			return true;
		if (val == "")
			return true;
		if (val.length == 0)
			return true;
		if (!/[^(^\s*)|(\s*$)]/.test(val))
			return true;
		return false;
	},

	isNotEmpty:function(str){
		return !this.isEmpty(str);
	}
};