<%@page import="org.apache.struts2.json.JSONUtil" pageEncoding="UTF-8"%>
<%@page import="java.util.HashMap"%>
<%
	//设定mime类型
  	response.setContentType("application/json;charset=utf-8");
  	HashMap<String,Object> map = new HashMap<String,Object>();
  	map.put("username", "keke");
  	response.getWriter().print("{\"username\":\"keke\"}");
 %>
