<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>头部页面</title>
   	<meta charset="UTF-8">
  </head>
  
  <body>
  	<div id="header">
	     <div class="wth1100">
	          <div class="teac_pic"><a href="#"><img src="../${user.headerplc}" alt=""/></a></div>
	          <div class="teac_nr">
	               <div class="teac_bt"><span>${user.nickname }<a href="/book/logout">退出</a></span></div>
	               <div class="teac_zi">${user.description}</div>
	          </div>
	          <div class="clearfix"></div>
	     </div>     
	</div>
  </body>
</html>
