<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
  <head>
    <title>My JSP 'test.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  <body>
<!--     <h1>Test  ----${map.age }--${map.username }---${map.password }</h1> -->
<!--     ${age} -->

	<form action="http://localhost:8080//moov_spring/getuser" method="post">
		<input type="text" name="username" />
		<input type="text" name="password" />
		<input type="text" name="age" />
		<input type="text" name="email" />
		<input type="submit" value="提交" />
	</form>
	
	<hr/>
	
	<h1>Test  ----${map.age }--${map.username }---${map.password }</h1>
	
	<h1>
		<c:forEach items="${list}" var="list">
			<p>${list.username }</p>
			<p>${list.password }</p>
			<p>${list.age }</p>
			<p>${list.email }</p>
		</c:forEach>
	</h1>
  </body>
</html>
