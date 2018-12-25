<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
		*{margin:0px;padding:0px}
		p{line-height:50px;}
		body{padding:100px}
		form{margin:0px auto;}
	</style>
  </head>
  <body>
    <form id="userForm" action="http://localhost:8080/moov_spring/update" method="post">
    	<p><input type="text" name="username" value="小针对性" /></p>
    	<p><input type="password" name="password" value="123456789" /></p>
    	<p><input type="text" name="age" value="38" /></p>
    	<p><input type="text" name="email" value="1327499522@qq.com" /></p>
    	<p><input type="submit" value="from提交" /></p>
    	<p><input type="button" onclick="saveUser(this.form)" value="Ajax提交" /></p>
    </form>
    ============================================================${user.username}
    
    <script type="text/javascript" src="http://localhost:8080/moov_spring/js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript">
    
    	function saveUser(form){
    		
    		//js中的json---string处理
    		//  json--String-----JSON.stringify(json);
    		//  String--json-----JSON.parse(string);
    		
    	/* 	var username = getFormVal("username");
    		var password = getFormVal("password");
    		var age = getFormVal("age");
    		var email = getFormVal("email"); */
    		
    		var params = $("#userForm").serialize();
    		
    		$.ajax({
        		type:"post",
        		url:"http://localhost  :8080/moov_spring/users/saveuser",
        		data:{"username":username,"password":password,"age":age,"email":email},
        		success:function(data){
        			
        		}
        	});
    	}
    	
    	//封装好的
    	function getFormVal(name){
    		return $("input[name='"+name+"']").val();
    	}
    	
    	//数组
    	function getFormVals(name){
    		var arr = [];
    		$("input[type='checkbox'][name='"+name+"']:checked").val().each(function(){
    			arr.push($(this).val());
    		});
    		return arr.toString();
    	}
    	
    </script>
  </body>
</html>
