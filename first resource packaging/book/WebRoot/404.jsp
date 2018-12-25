<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
  <head>
    
    <title>提示错误</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
    <div style="margin:10px;width:960px;height:300px;border:1px solid #000;">
  		非法提示<span id="count">5</span>之后，返回空间首页
  		<a href="page/book">点击返回</a>
  	</div>
  	
  	<script type="text/javascript">
	   var count = 5;
	   window.onload = function(){
		   setInterval(function(){
			   	count--;
				if(count<=0)window.location.href = "page/book";
				document.getElementById("count").innerHTML = "<b>"+count+"</b>";
		   },1000);
	   };
   </script>
  </body>
</html>
