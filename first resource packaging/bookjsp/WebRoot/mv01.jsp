<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
  <head>
    <title>My JSP 'mv01.jsp' starting page</title>
    <meta charset="UTF-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style>
		*{margin:0px;padding:0px;font-family:"微软雅黑";font-size:18px;}
		body{padding:20px;}
		#box{width:1200px;height:250px;}
		.jiaoben{width:1200px;height:300px;}
	</style>
  </head>
  <body>
     
	  <div id="box">
	  	<h1>jsp指令</h1>
	  	&lt;%@ page import="" pageEncoding="" 定义属性%&gt;   
	  	<hr> 
	 	&lt;%@ include file="" % 文件路径&gt;
	 	<hr>
	 	&lt;%@ taglib uri="" pre="" %  &gt;
	  </div>
	 	
	 <div class="jiaoben">
	 	<h1>jsp脚本</h1>
	 	1---- &lt;% Java代码片断  不能定义方法  % &gt;
	 	<hr>
	 	2---- &lt;%!  可以定义Java方法    %&gt;
	 	<hr>
	 	3---- &lt;%=  运算表达式   %&gt;
	 </div>
	 	
  </body>
</html>
