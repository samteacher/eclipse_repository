<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>验证码</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style>
		*{margin:0px;padding:0px;}
		body{font-family:"微软雅黑";font-size:18px;}
		.box{width:600px;height:300px;margin:100px auto;padding:20px;}
	</style>
  </head>
  <body>
	<div class="box">
		<img id="code" src="code.jsp" onclick="this.src='code.jsp?'+Math.random()" />
		
		<a href="javascript:void(0)" onclick="document.getElementById('code').src='code.jsp?'+Math.random()">换一张</a>
	</div>
	
  </body>
</html>
