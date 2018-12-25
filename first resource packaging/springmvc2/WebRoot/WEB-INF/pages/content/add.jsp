<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE HTML>
<html>
  <head>
    <title>add页面</title>
    <meta charset="UTF-8">
	<meta name="keywords" content="keyword1,keyword2,keyword3">
	<meta name="description" content="This is my page">
	<script type="text/javascript">var rootPath = "${rootPath}";</script>
	<script type="text/javascript" src="${resPath}/js/jquery-1.11.1.min.js"></script>
	<style type="text/css">
		*{margin:0px;padding:0px;}
		body{font-family:"微软雅黑";font-size:24px;}
		#box{width:560px;height:480px;background:#888;margin:0px auto;text-align:center;border:1px solid #ccc;}
		#box p{line-height:26px;margin-top:10px;color:#fff;}
	</style>
  </head>
  <body>
	<div id="box">
		<form:form modelAttribute="content" action="${rootPath}/content/save" method="post">
			<form:errors path="*"></form:errors>
			<p>标题：<form:input path="title"/></p>
			<p>描述：<form:input path="description"/></p>
			<p>年龄：<form:input path="age"/></p>
			<p>金钱：<form:input path="salary"/></p>
			<p>时间：<form:input path="time"/></p>
			<input type="submit" value="提交" />
		</form:form>
	</div>
	
  </body>
</html>
