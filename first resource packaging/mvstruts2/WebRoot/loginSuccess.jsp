<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>登录成功的页面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  <body>
  	
  	<%
  		String username = request.getParameter("username");
  		String password = request.getParameter("password");
  		request.setAttribute("username", username);
  		request.setAttribute("password", password);
  		
  	%>
  
  	<p>${username } ==== ${password }</p>
  	<h1>恭喜你，登录成功！</h1>
  </body>
</html>
