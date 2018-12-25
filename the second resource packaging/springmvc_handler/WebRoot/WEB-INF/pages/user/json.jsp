<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
  <head>
  	<title>潭州学院添加页面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript">var rootPath="${rootPath}";</script>
	<style>
		*{padding: 0;margin:0}
		body{font-size:14px;font-family: "微软雅黑";}
	</style>
	<script type="text/javascript" src="${resPath}/js/jquery.js"></script>
  </head>
  <body>
  
  	<div id="show"></div>
  	<input type="button" onclick="parseJson()" value="解析json">
  	<input type="button" onclick="parseJson2()" value="解析json对象">
  	
  	
  	<script type="text/javascript">
  		function parseJson(){
  			$.ajax({
  				type:"post",
  				url:rootPath+"/user/out",
  				success:function(data){
  					//var json = getJSON(data);
  					var json = JSON.parse(data);
  					var jsonString =JSON.stringify(json);
  					alert(jsonString);
  					$("#show").html(json.username+"==="+json.email)
  				}
  			});
  		};
  		
  		
  		function getJSON(data){
  			if(typeof data === "string"){
  				//var json = JSON.parse(data);
  				//return json;
  				return eval("("+data+")");
  			}else{
  				return data;
  			}
  		};
  		
  		
  		/*springmvc返回application/json对象格式*/
  		function parseJson2(){
  			$.ajax({
  				type:"post",
  				url:rootPath+"/user/outUser",
  				success:function(data){
  					var json =getJSON(data);
  					$("#show").html(json.username+"==="+json.email);
  				}
  			});
  		};
  	</script>
  </body>
</html>
