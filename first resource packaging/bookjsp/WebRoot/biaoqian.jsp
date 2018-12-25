<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="mv" uri="/WEB-INF/tld/mv.tld" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'biaoqian.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  <body>
	
	<!-- 业务逻辑自定义标签 -->
	<%--  <mv:contentTag end="" begin="" var="">dfdsfsdf</mv:contentTag>  --%>
	
	
	<%
		
		HashMap<String , Object> map = new HashMap<String,Object>();
		map.put("name","余秋富");
		map.put("age",22);
		pageContext.setAttribute("map", map);
		
	%>
	
	
	<c:forEach items="${map}" var="mk" varStatus="cindex">
		<p>${(cindex.index+1)} ${mk.key } ====  ${mk.value }</p>	
	</c:forEach>
	
  </body>
</html>
