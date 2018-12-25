<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>My JSP 'list.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  
  <body>
    <h1>来自于sessioin中的值是：${sessionScope.content}</h1>
    <h1>来自于request中的值是：${requestScope.content}</h1>
    <h1>来自于application中的值是：${applicationScope.content}</h1>
  </body>
</html>
