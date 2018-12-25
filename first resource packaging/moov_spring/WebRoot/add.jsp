<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
  <head>
  
  	<title>潭州学院添加页面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style>
		*{padding: 0;margin:0}
		body{font-size:14px;font-family: "微软雅黑";background:#333}
		#box{width:560px;height:480px;background:#888;margin:100px auto;text-align:center;border:1px solid #ccc;}
		#box p{line-height:26px;margin-top:10px;color:#fff;}
		#box p input[type='text']{height:32px;width:240px;font-family: "微软雅黑";text-indent:1em;outline:none;border:1px solid #ccc;}
		#box textarea{width:240px;height:69px;vertical-align: top;font-family: "微软雅黑";padding:10px;}
	</style>
  </head>
  <body>
  	
  	<div id="box">
  		<form id="userForm" action="http://localhost/tzupload/user/save.html" method="post">
	  		<p>姓名:<input type="text" name="username" autofocus="autofocus" placeholder="请属于用户名称..." maxlength="10" value="keke"/></p>
	  		<p>年龄:<input type="text" name="age" placeholder="请属于年龄..." value="31"/></p>
	  		<p>邮箱:<input type="text" name="email" placeholder="请输入邮箱xxxx@qq.com..." value="761008250@qq.com"/></p>
	  		<p>电话:<input type="text" name="phone" placeholder="请输入电话.." value="15074816437"/></p>
	  		<p>省份:<select name="city">
	  			<option value="431000" selected="selected">湖南省</option>
	  			<option value="131000">郴州省</option>
	  			<option value="231000">浙江省</option>
	  			<option value="331000">上海省</option>
	  		</select></p>
	  		<p>爱好:
	  			<label><input type="checkbox" name="hobbys" checked="checked" value="1"/>电影</label>
	  			<label><input type="checkbox" name="hobbys" value="2"/>爬山</label>
	  			<label><input type="checkbox" name="hobbys" checked="checked" value="3"/>游泳</label>
	  			<label><input type="checkbox" name="hobbys" value="4"/>睡觉</label>
	  		</p>
	  		<p>性别:
	  			<label><input type="radio" name="male" checked="checked" value="1"/>男</label>
	  			<label><input type="radio" name="male" value="0"/>女</label>
	  			<label><input type="radio" name="male" value="2"/>保密</label>
	  		</p>
	  		<p>描述 :
	  			<textarea name="desc" placeholder="请输入用户描述...">我是一个老师!!!</textarea>
	  		</p>
	  		<p><input type="submit" value="submit提交"/></p>
	  		<p><input type="button" onclick="tzsaveuser(this.form)" value="ajax提交"/></p>
  		</form>
  	</div>
  	
  	<script type="text/javascript" src="http://localhost/tzupload/js/jquery-1.11.2.min.js"></script>
  	<script type="text/javascript">
  	
  		//js中的json-string的处理
  		//JSON--String --- JSON.stringify(json);
  		//String-JSON ---- JSON.parse(jsonString);
  		
//   	var json ={username:"keke"};
//   	var jsonString = JSON.stringify(json);
//   	var jobj = JSON.parse(jsonString);
//   	alert(jobj.username)
  		
  		
  		function tzsaveuser(form){
  			//var username = getFormVal("username");
  			//var age = getFormVal("age");
  			
  			//localStorage.setItem("username",username);
  			//localStorage.setItem("age",age);
  			//var json = {username:username,age:age};
  			//localStorage.setItem("message",JSON.stringify(json));
  			
	
  			/*var username = getFormVal("username");
  			var age = getFormVal("age");
  			var phone = getFormVal("phone");
  			var email = getFormVal("email");
  			var desc = $("textarea[name='desc']").val();
  			var city = $("select[name='city']").val();
  			var male = getFormVal("male");
  			var hobbys = getFormVals("hobbys");
  			var params = {
  				username:username,
  				age:age,
  				email:email,
  				phone:phone,
  				desc:desc,
  				city:city,
  				male:male,
  				loves:hobbys
  			};*/
  			
//   			方法一:
//   			var loves = getFormVals("hobbys");
//   			var params =  $("#userForm").serialize();
//   			params+="&loves="+loves;
//   			$.ajax({
//   				type:"post",
//   				url:"http://localhost/tzupload/user/ajaxSave.html",
//   				data:params,
//   				success:function(data){
//   				}
//   			});
	
  				//方法三:
  	  			var loves = getFormVals("hobbys");
  	  			var params =  $("#userForm").serializeArray();
  	  			var json = {name:"loves",value:loves};
  	  			params.push(json);
  	  			$.ajax({
  	  				type:"post",
  	  				url:"http://localhost/tzupload/user/ajaxSave.html",
  	  				data:params,
  	  				success:function(data){
  	  					
  	  				}
  	  				
  	  			});
  		}
  		
  		
  		
  		function getFormVal(name){
  			return $("input[name='"+name+"']").val();
  		}
  		
  		//数组
  		function getFormVals(name){
  			var arr = [];
  			$("input[type='checkbox'][name='"+name+"']:checked").each(function(){
  				arr.push($(this).val());	
  			});
  			return arr.toString();
  		}
  	
  	</script>
  </body>
</html>
