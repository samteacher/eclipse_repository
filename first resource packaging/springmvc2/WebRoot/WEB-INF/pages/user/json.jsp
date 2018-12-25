<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>JSON序列化</title>
    <meta charset="UTF-8">
	<meta name="keywords" content="">
	<meta name="description" content="">
	<script type="text/javascript">var rootPath = "${rootPath}";</script>
	<script type="text/javascript" src="${resPath}/js/jquery-1.11.1.min.js"></script>
	<style type="text/css">
		*{margin:0px;padding:0px;}
		body{font-family:"微软雅黑",font-size:24px;}
	</style>
  </head>
  <body>
  
  	<div id="show"></div>
  	<input type="button" value="解析Json" onclick="parseJson()" />
  	<input type="button" value="解析Json对象" onclick="parseJsonObj()" />
    
    <script type="text/javascript">
    
	    function parseJson(){
	    	$.ajax({
	    		type:"post",
	    		url:rootPath+"/user/out",
	    		success:function(data){
	    			//var json = getJSON(data);
	    			var json = JSON.parse(data);
					//var str = JSON.stringify(json);
	    			$("#show").html(json.username+"==="+json.password+"==="+json.age);
	    		}
	    	});
	    };
	    
	    //拿到字符串
	    function getJSON(data){
	    	if(typeof data === "string"){
	    		return eval("("+data+")"); 
	    	}else{
	    		return data;
	    	}
	    };
	    
	    /* springmvc返回application/json对象格式 */
    	 function parseJsonObj(){
	    	$.ajax({
	    		type:"post",
	    		url:rootPath+"/user/outUser",
	    		success:function(data){
	    			var json = getJSON(data);
	    			$("#show").html(json.username+"****"+json.age);
	    		}
	    	});
	    };
    </script>
  </body>
</html>
