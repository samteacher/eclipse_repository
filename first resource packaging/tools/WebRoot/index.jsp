<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  <body>
  	<form action="http://localhost:8080/tools/user/login" method="post">
    	<input type="txt" name="username" autofoucs/><br/>
    	<input type="password" name="password" autofoucs/><br/>
    	<input type="txt" name="age" autofoucs/><br/>
    	<input type="submit" value="提交">
    </form>
  
    <img src="http://localhost:8080/tools/code" alt="" onclick="this.src='http://localhost:8080/tools/code?'+new Date().getTime() "/>
	<a href="javascript:void(0)" onclick="tmcode(this)">换一张</a>
  </body>
</html>
