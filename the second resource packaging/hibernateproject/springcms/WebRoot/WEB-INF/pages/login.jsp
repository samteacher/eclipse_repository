<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>潭州学院-CMS登陆页面</title>
<link rel="stylesheet" href="${basePath}/css/style.default.css" type="text/css" />
<script type="text/javascript" src="${basePath}/js/jquery-1.11.2.min.js"></script>
</head>
<body class="loginpage">
<div class="loginpanel">
    <div class="loginpanelinner animated1 bounceIn">
        <div class="logo"><img src="images/logo.png" alt="" /></div>
            <div class="inputwrapper animated bounceIn">
                <input type="text" name="account" id="account" autofocus="autofocus" placeholder="请输入用户名" />
            </div>
            <div class="inputwrapper magictime tinUpIn ">
                <input type="password" name="password" id="password" placeholder="请输入密码" />
            </div>
            <div class="inputwrapper magictime tinUpIn">
                <button name="button" onclick="tm_login(this)">登 入</button>
            </div>
            <div class="inputwrapper magictime tinUpIn">
                <label><input type="checkbox" class="remember" name="signin" /> 记住密码</label>
            </div>
            
    </div><!--loginpanelinner-->
</div><!--loginpanel-->
<div class="loginfooter">
    <p>&copy; 2013. Shamcey Admin Template. All Rights Reserved.</p>
</div>
<script type="text/javascript">
	function tm_login(obj){
		var password = $("#password").val();
		var account = $("#account").val();
		$.ajax({
			type:"post",
			url:"${basePath}/logined",
			data:{"account":account,"password":password},
			success:function(data){
				if(data=="success"){
					window.location.href = "${basePath}/index";
				}else if(data=="fail"){
					$("#password").val("");
				}
			}
		});
	};
	
</script>
</body>
</html>