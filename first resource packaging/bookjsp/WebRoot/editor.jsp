<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>富本编辑器</title>
	<link rel="stylesheet" type="text/css" href="themes/default/css/ueditor.css">
    <script type="text/javascript" charset="utf-8" src="js/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="js/ueditor/ueditor.all.min.js"> </script>
    <script type="text/javascript" charset="utf-8" src="js/ueditor/zh-cn.js"></script>
    
    <style>
    	#box{width:900px;}
    </style>
  </head>
  <body>
	
	<div id="box">
		<textarea id="editor"></textarea>
	</div>
	
	<script type="text/javascript">
		//实例化编辑器
   		 var ue = UE.getEditor("editor");
		
	</script>
  </body>
</html>
