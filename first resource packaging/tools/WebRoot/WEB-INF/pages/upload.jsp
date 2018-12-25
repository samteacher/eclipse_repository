<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>My JSP 'upload.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<style type="text/css">
* {
	margin: 0px;
	padding: 0px;
}

body {
	font-size: 20px;
	margin-top:50px;
	font-family: "微软雅黑";
}

fieldset {
	width: 640px;
	margin: 0px auto;
	padding: 30px;
}


</style>
</head>
<body>
	<fieldset>
		<legend>文件上传</legend>
		<form action="upload" enctype="multipart/form-data">
			<input type="file" name="file" /> 
			<input type="submit" value="上传文件" />
		</form>
	</fieldset>

</body>
</html>
