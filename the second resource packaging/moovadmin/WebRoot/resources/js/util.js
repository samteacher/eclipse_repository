/**  获取ID  */
function getId(id) {
	return document.getElementById(id);
}

/** 转换成数组 */
function toArray(doms){
	return Array.prototype.slice.call(doms);
}

/** 倒计时跳转页面 */
function SetTime(id,path){
	var count = 5;
	setInterval(function(){
		count--;
		if (count <= 0)window.location.href = path;
			document.getElementById(id).innerHTML = "<br>" + count + "</br>";
		}, 1000);
}

/** 空判断 */
function isEmpty(val) {
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
}

/** 非空判断 */
function isNotEmpty(val) {
	return !isEmpty(val);
}

/** 禁止窗体选中 */
function forbiddenSelect() {
	$(document).bind("selectstart", function() {
		return false;
	});
	document.onselectstart = new Function("event.returnValue=false;");
	$("*").css({
		"-moz-user-select" : "none"
	});
}

/** 窗体允许选中 */
function autoSelect() {
	$(document).bind("selectstart", function() {
		return true;
	});
	document.onselectstart = new Function("event.returnValue=true;");
	$("*").css({
		"-moz-user-select" : ""
	});
};

/**
 * 对Date的扩展，将 Date 转化为指定格式的String 月(M)、日(d)、12小时(h)、24小时(H)、分(m)、秒(s)、周(E)、季度(q)
 * 可以用 1-2 个占位符 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字) eg: (new
 * Date()).format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423 (new
 * Date()).format("yyyy-MM-dd E HH:mm:ss") ==> 2009-03-10 二 20:09:04 (new
 * Date()).format("yyyy-MM-dd EE hh:mm:ss") ==> 2009-03-10 周二 08:09:04 (new
 * Date()).format("yyyy-MM-dd EEE hh:mm:ss") ==> 2009-03-10 星期二 08:09:04 (new
 * Date()).format("yyyy-M-d h:m:s.S") ==> 2006-7-2 8:9:4.18
 */
Date.prototype.format = function(fmt) {
	var o = {
		"M+" : this.getMonth() + 1,
		// 月份
		"d+" : this.getDate(),
		// 日
		"h+" : this.getHours() % 12 == 0 ? 12 : this.getHours() % 12,
		// 小时
		"H+" : this.getHours(),
		// 小时
		"m+" : this.getMinutes(),
		// 分
		"s+" : this.getSeconds(),
		// 秒
		"q+" : Math.floor((this.getMonth() + 3) / 3),
		// 季度
		"S" : this.getMilliseconds()
	// 毫秒
	};
	var week = {
		"0" : "/u65e5",
		"1" : "/u4e00",
		"2" : "/u4e8c",
		"3" : "/u4e09",
		"4" : "/u56db",
		"5" : "/u4e94",
		"6" : "/u516d"
	};
	if (/(y+)/.test(fmt)) {
		fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "")
				.substr(4 - RegExp.$1.length));
	}
	if (/(E+)/.test(fmt)) {
		fmt = fmt
				.replace(
						RegExp.$1,
						((RegExp.$1.length > 1) ? (RegExp.$1.length > 2 ? "/u661f/u671f"
								: "/u5468")
								: "")
								+ week[this.getDay() + ""]);
	}
	for ( var k in o) {
		if (new RegExp("(" + k + ")").test(fmt)) {
			fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k])
					: (("00" + o[k]).substr(("" + o[k]).length)));
		}
	}
	return fmt;
};

/**
 * javascript版本的equals比较
 * 判断两个元素是否相等
 */
function equals(str, tstr) {
	if (str == tstr) {
		return true;
	}
	return false;
}

/**
 * 获取ID 
 */
function getId(id) {
	return document.getElementById(id);
}

/**
 * 转换成数组
 */
function toArray(doms) {
	return Array.prototype.slice.call(doms);
}

/**
 * js中数组的排序
 * json是要排序的对象
 * filed 你要排序的属性
 * sortMark:desc==降序   asc==升序     默认升序==asc
 */
function ArraySort(jsonArr, field, sortMark) {
	//1：判断是不数组
	if (!Array.isArray(jsonArr)) {
		return;
	}
	sortMark = sortMark || "asc";
	jsonArr.sort(function(a, b) {
		if (sortMark == "asc") {
			return a[field] - b[field];
		} else if (sortMark == "desc") {
			return b[field] - a[field];
		}
	});
};

/**
 * javascript设置Cookie值
 */
$.tmCookie = {
	setCookie : function(name, value, time, option) {
		var str = name + '=' + escape(value);
		var date = new Date();
		date.setTime(date.getTime() + this.getCookieTime(time));
		str += "; expires=" + date.toGMTString();
		if (option) {
			if (option.path)
				str += '; path=' + option.path;
			if (option.domain)
				str += '; domain=' + option.domain;
			if (option.secure)
				str += '; true';
		}
		document.cookie = str;
	},
	getCookie : function(name) {
		var arr = document.cookie.split('; ');
		if (arr.length == 0)
			return '';
		for (var i = 0; i < arr.length; i++) {
			tmp = arr[i].split('=');
			if (tmp[0] == name)
				return unescape(tmp[1]);
		}
		return '';
	},
	delCookie : function(name) {
		$.tmCookie.setCookie(name, '', -1);
		var date = new Date();
		date.setTime(date.getTime() - 10000);
		document.cookie = name + "=; expire=" + date.toGMTString() + "; path=/";
	},

	getCookieTime : function(time) {
		if (time <= 0)
			return time;
		var str1 = time.substring(1, time.length) * 1;
		var str2 = time.substring(0, 1);
		if (str2 == "s") {
			return str1 * 1000;
		} else if (str2 == "m") {
			return str1 * 60 * 1000;
		} else if (str2 == "h") {
			return str1 * 60 * 60 * 1000;
		} else if (str2 == "d") {
			return str1 * 24 * 60 * 60 * 1000;
		}
	}
};

/**
 * 解决IE下不支持input下的placeholder属性  type="text"
 */
(function($) {
	$.fn.placeholder = function(options) {
		var opts = $.extend({}, $.fn.placeholder.defaults, options);
		var isIE = document.all ? true : false;
		return this.each(function() {
			var _this = this, placeholderValue = _this
					.getAttribute("placeholder"); //缓存默认的placeholder值
			if (isIE) {
				_this.setAttribute("value", placeholderValue);
				_this.onfocus = function() {
					$.trim(_this.value) == placeholderValue ? _this.value = ""
							: '';
				};
				_this.onblur = function() {
					$.trim(_this.value) == "" ? _this.value = placeholderValue
							: '';
				};
			}
		});
	};
})(jQuery);

/**
 * 解决IE下不支持placeholder属性
 */
(function($) {
	$.fn.placeholder = function(options) {
		var opts = $.extend({}, $.fn.placeholder.defaults, options);
		var isIE = document.all ? true : false;
		return this.each(function() {
			var _this = this, placeholderValue = _this
					.getAttribute("placeholder"); //缓存默认的placeholder值
			if (isIE) {
				_this.setAttribute("value", placeholderValue);
				_this.onfocus = function() {
					$.trim(_this.value) == placeholderValue ? _this.value = ""
							: '';
				};
				_this.onblur = function() {
					$.trim(_this.value) == "" ? _this.value = placeholderValue
							: '';
				};
			}
		});
	};
})(jQuery);