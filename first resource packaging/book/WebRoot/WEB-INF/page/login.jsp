<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>JavaVip试听课程-登陆</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="js/tm_cookie.js"></script>
<style type="text/css">
	#message{text-align: center;height: 35px;color: red;font-weight: bold;line-height: 35px;display: none;}
</style>
</head>
<body>
<!-- contact-form -->	
<div class="message warning">
<div class="inset">
	<div class="login-head">
		<h1>学院登陆 </h1>
		<div class="alert-close"> </div> 			
	</div>
	<div id="message"></div>
		<!-- jsp就是servlet  -->
		<form action="login" method="post">
			<li>
				<input type="text" name="account" id="username" placeholder="请输入用户名称!" class="text" ><a href="#" class=" icon user"></a>
			</li>
			<li>
				<input type="password" name="password" id="password"  placeholder="请输入用户密码!"> <a href="#" class="icon lock"></a>
			</li>
			<div class="clear"> </div>
			<div class="submit">
				<label><input type="checkbox" id="cookie" name="sign">七天免登录</label>
				<input type="button" onclick="tm_login()" value="登 陆" >
				<h4><a href="javascript:void(0);">忘记密码 ?</a></h4>
				<div class="clear">  </div>
			</div>
		</form>
		</div>					
	</div>
	<div class="clear"> </div>


<script type="text/javascript">
	
	function tm_login(){
		window.onload=function(){
	    	$(document).keydown(function(event){
	        	switch(event.keyCode) {
	        		case 13:{}
	            }
	    	});
	    };
		var account = $("#username").val();
		var password = $("#password").val();
		
		var cookieMark = "";
		if($("#cookie").prop("checked"))cookieMark = 1;

		var timer = null;
		clearInterval(timer);
		timer = setTimeout(function(){
			$.ajax({
				type:"post",//请求方式
				url:"http://localhost:8080/book/login",//与服务器请求的地址
				data:{"account":account,"password":password,"cookieMark":cookieMark},//传递给服务器的值 形式：key:value
				beforeSend:function(){},//与服务器进行交互之前执行的回调函数
				error:function(){},//与服务器进行交互失败或者服务器关闭执行的回调函数
				timeout:3000,
				success:function(data){//与服务器进行交互成功执行的回调函数
					if(data=="success"){
						window.location.href = "page/book";
					}else{
						alert("error  404");
					}
				}
			});
		},200);
		
	}
</script>

</body>
</html></label>