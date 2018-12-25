<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="mv" uri="/WEB-INF/tld/mv.tld" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>自定义标签日期转换</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style>
		*{margin:0px;padding:0px;font-family:"微软雅黑";font-size:18px;}
		body{padding:50px;}
		p{margin:10px 0;}
	</style>
  </head>
  <body>
    
    <div>自定义标签----函数自定义标签 - fn</div>
   	<p>1.小写转大写======${mv:toUpper("adfasdfasd") }</p>
   	<p>2.日期格式化======${mv:dateFormat("2017-02-26 10:48:47","yyyy-MM-dd HH:mm:ss")}</p>
   	<p>3.性别判断 =======</p>
   	<p>4.空判断  ========${mv:isEmpty("dfasd")}</p>
   	<p>5.数字转中文   =====</p>
   	<p>6.输入A,B,C ====</p>
    	
   	<%
   		String str ="";
   		pageContext.setAttribute("str", str);
   	%>
   	${mv:isEmpty(str) ? "我是一个空值" : "我有值"}
  </body>
</html>
