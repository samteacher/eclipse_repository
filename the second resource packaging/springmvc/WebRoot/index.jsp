<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <h1>WEBROOT下的index.jsp页面</h1>
    =======${sessionScope.code}
   <img alt="" src="http://localhost:8080/springmvc/code" onclick="this.src='http://localhost:8080/springmvc/code?'+new Date().getTime();">
   <a href="javascript:void(0)"  onclick="tmcode(this)">请点击下一张</a>
   <!-- <a href="javascript:void(0)" onclick="function test(){this.code.src='http://localhost:8080/springmvc/code?'+new Date().getTime();};test();">请点击下一张</a> -->
  
   <img alt="" src="http://localhost:8080/springmvc/code" onclick="this.src='http://localhost:8080/springmvc/code?'+new Date().getTime();">
   <a href="javascript:void(0)" onclick="tmcode(this)">请点击下一张</a>

   <script type="text/javascript" src="js/jquery-3.3.1.js"></script>
   <script type="text/javascript">
	   	function tmcode(obj){
	   		$(obj).prev().trigger("click");
	   	}
   </script>
  </body>
</html>
