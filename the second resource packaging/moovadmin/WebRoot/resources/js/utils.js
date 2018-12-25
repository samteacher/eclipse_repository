/*
 * @author Leider/Rumor
 * js常用方法封装
 * 
 * ready(callback);当页面加载完后之后执行回调函数
 * id(id);以id获取元素
 * getClass(cName,parent);以class获取元素。cName为class类名，parent为当前元素的父级元素
 * firstChild(dom);获取当前元素下的第一个子元素
 * element(dom,parent);获取元素标签dom为要获取的元素标签名，parent为当前标签的父级元素
 * prevSibling(dom);获取当前元素的上一个兄弟元素
 * nextSibling(dom);获取当前元素的下一个兄弟元素
 * auto(fn,callback,time);setInterval定时器，fn为函数名，callback为回调函数，time为定时器的周期
 * getIndex(dom);获取当前元素的索引
 * siblings(dom,callback);获取当前元素的所有兄弟元素，不包括自己。dom为当前元素，callback为回调函数，可以执行一些业务逻辑。
 * addStyle(dom);给当前元素添加css样式,用法：addStyle(dom,key,value);或者addStyle(dom,{width:value,left:value,……});
 * r(cont);调试方法。用于页面开发的调试。
 * lastChild(dom);//获取父级元素下的最后一个子元素
 * 
 * */


//dom元素加载完毕执行方法
function ready(b) {
    if (document.addEventListener) document.addEventListener("DOMContentLoaded", b, !1);
    else {
        var a = document.createElement("script");
        document.getElementsByTagName("head")[0].appendChild(a);
        a.defer = !0;
        a.onreadystatechange = function () {
            "complete" == a.readyState && b()
        }
    }
};


//获取ID
function id(id){
	return document.getElementById(id);
};
//获取第一个子元素
function firstChild(dom){
	if(dom.firstElementChild){
		return dom.firstElementChild;
	}else{
		return dom.firstChild;
	};
};

//获取最后一个子元素
function lastChild(dom){
	if(dom.lastElementChild){
		return dom.lastElementChild;
	}else{
		return dom.lastChild;
	};
};

//获取class
function getClass(cName,parent){
	parent = parent || document;
	if(document.getElementsByClassName){
		var className = parent.getElementsByClassName(cName);
		var  arr = [].slice.call(className);
		return arr;
	}else{
		var allE = element("*",parent);
		var arr = [];
		var i = 0,len = allE.length;
		for(;i<len;i++){
			var newArr = allE[i].className.split(" ");
			for(var j=0;j<newArr.length;j++){
				if(newArr[j] == cName){
					arr.push(newArr[j]);
					break;
				};
			};
		};
		return arr;
	};
};
//获取元素
function element(dom,parent){
	parent = parent || document;
	return parent.getElementsByTagName(dom);
};

//获取上一个兄弟元素
function prevSibling(dom){
	if(dom.prveiousSibling){
		return dom.previousSibling;
	}else{
		return dom.previousElementSibling;
	}
};

//获取下一个兄弟元素
function nextSibling(dom){
	if(dom.nextElementSibling){
		return dom.nextElementSibling;
	}else{
		return dom.nextSibling;
	};
}
//自动轮播
function auto(fn,callback,time){
	var falg = fn || callback;
	timer = setInterval(falg,time);
}

/*
 *获取元素的索引位置 
 */
function getIndex(dom){
   //获取这个对象父元素所有子元素
   var doms = dom.parentElement.children;
   //记录索引的
   var index = -1;
   //循环所有元素，判断当前元素在所有元素的那个位置
   for(var i=0,len=doms.length;i<len;i++){
       //如果是同意一个元素，就把位置索引拿出来，跳出循环
       if(dom==doms[i]){
        index = i;
        break;
       }
    };
    return index;
};

/*
 * 找到某个元素的同辈元素
 */
function siblings(dom,callback){
    //获取这个对象父元素所有子元素
   var doms = dom.parentElement.children;
   var arr = [];
   //循环所有元素，判断当前元素在所有元素的那个位置
   for(var i=0,len=doms.length;i<len;i++){
       //如果不是一个元素，就把位置索引拿出来，跳出循环
       if(dom!=doms[i]){
       		arr.push(doms[i]);
          	callback && callback.call(doms[i],doms[i],i);
       };
    };
    return arr;
}
//根据某个元素找到这个元素的所有兄弟元素
//function allSibling(dom){
//	var doms = dom.parentElement.children;
//	var i = 0,len = doms.length,arr = [];
//	for(;i<len;i++){
//		if(dom!=doms[i]){
//			arr.push(doms[i]);
//		};
//	};
//	return arr;
//};
/*
 *调试
 */
function r(cont){
	if(cont){
		console.log("===="+cont);
	}else{
		alert(cont);
	}
};

/*
 *给DOM元素的style对象添加属性值。
 * 
 */
function addStyle(dom){
	var len = arguments.length;
	if(len == 2 && typeof arguments[1] == "object"){
		for(var key in arguments[1]){
			addCss(key,arguments[1][key]);
		};
	}else{
		addCss(arguments[1],arguments[2]);
	};
	//封装value数据类型判断
	function addCss(attr,value){
		//判断value 是否为number数据类型、
		if(typeof value == "number"){
			return dom.style[attr] = value+"px";
		}else{
			return dom.style[attr] = value;
		};
	};
};

