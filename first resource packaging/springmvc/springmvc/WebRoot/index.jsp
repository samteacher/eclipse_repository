<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
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
    <form action="attirbute" method="post">
    	<input type="txt" name="username" autofoucs/><br/>
    	<input type="password" name="password" autofoucs/><br/>
    	<input type="txt" name="age" autofoucs/><br/>
    	
    	<input type="submit" value="提交">
    </form>
    
   	这里是首页
   	<p>${user.age}</p>
   	<p>${user.username}</p>
   	<p>${user.password}</p>
   	
   	<hr>
   	
   	<c:forEach items="${users}" var="users">
   		<p>${users.age}</p>
   		<p>${users.username}</p>
   		<p>${users.password}</p>
   	</c:forEach>
   	
   	<img id="code" src="http://localhost:8080/springmvc/code" alt="" onclick="this.src='http://localhost:8080/springmvc/code?'+new Date().getTime() "/>
	<a href="javascript:void(0)" onclick="tmcode(this)">换一张</a>
	
	<img id="code" src="http://localhost:8080/springmvc/code" alt="" onclick="this.src='http://localhost:8080/springmvc/code?'+new Date().getTime() "/>
	<a href="javascript:void(0)" onclick="tmcode(this)">换一张</a>
	
	${code }
   	
   	<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
   	<script type="text/javascript">
   		function tmcode(obj){
   			$(obj).prev().trigger("click");
   		}
   	</script>
  </body>
</html>
