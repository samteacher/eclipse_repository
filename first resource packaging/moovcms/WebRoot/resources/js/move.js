/**
 * @author keke
 * 时间版本的动画函数
 * 
 * 
 * 参数分析:
 * obj:改变的元素对象
 * json：改变的值，比如:{width:200,height:200,opacity:0}
 * times:1000默认是:400
 * fx:不写模式是:linear，如果要去定义的话：animate.js中去去查找
 * callback：运动执行完毕的回调函数
 * mkAnimate(obj,json,times,fx,callback);
 * 
 */
function mkAnimate(obj, json, times, fx, fn) {
    var iCur = {};
    var startTime = nowTime();

    if (typeof times == 'undefined') {
        times = 400;
        fx = 'linear';
    }

    if (typeof times == 'string') {
        if (typeof fx == 'function') {
            fn = fx;
        }
        fx = times;
        times = 400;
    } else if (typeof times == 'function') {
        fn = times;
        times = 400;
        fx = 'linear';
    } else if (typeof times == 'number') {
        if (typeof fx == 'function') {
            fn = fx;
            fx = 'linear';
        } else if (typeof fx == 'undefined') {
            fx = 'linear';
        }
    }

    for (var attr in json) {
        iCur[attr] = 0;
        if (attr == 'opacity') {
            iCur[attr] = Math.round(getStyle(obj, attr) * 100);
        } else {
            iCur[attr] = parseInt(getStyle(obj, attr));
        }
    }

    clearInterval(obj.timer);
    obj.timer = setInterval(function () {
        var changeTime = nowTime();
        var scale = 1 - Math.max(0, startTime + times - changeTime) / times; 
        for (var attr in json) {
            var value = Tween[fx](scale * times, iCur[attr], json[attr] - iCur[attr], times);
            if (attr == 'opacity') {
                obj.style.filter = 'alpha(opacity=' + value + ')';
                obj.style.opacity = value / 100;
            } else {
                obj.style[attr] = value + 'px';
            }
        }

        if (scale == 1) {
            clearInterval(obj.timer);
            if (fn) {
                fn.call(obj);
            }
        }
    }, 30);

    function nowTime() {
        return (new Date()).getTime();
    }
}

/*获取样式*/
function getStyle(obj, attr) {
    if (obj.currentStyle) {
        return obj.currentStyle[attr];
    } else {
        return getComputedStyle(obj, false)[attr];
    }
};