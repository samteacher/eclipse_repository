<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
  <head>
    <meta charset="UTF-8">
    <title>My JSP 'success.jsp' starting page</title>
  </head>
  <body>
    <h1>恭喜你！登录成功！！！！！！！</h1>
    <!-- jsp获取不同作用中的值 -->>
    jsp获取request作用域====<%=request.getAttribute("username")%>>  <br/>
    jsp获取session作用域====<%=session.getAttribute("username")%>><br/>
    jsp获取application作用域====<%=application.getAttribute("username")%>>
    
    <hr></hr>
    
    <!-- el表达式获取不同作用中的值 -->
    jsp获取request作用域====${requestScope.username } <br/>
    jsp获取session作用域====${sessionScope.username }<br/>
    jsp获取application作用域====${applicationScope.username }
  </body>
</html>
