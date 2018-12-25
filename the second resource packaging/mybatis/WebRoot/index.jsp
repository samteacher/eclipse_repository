<%@page import="org.apache.struts2.json.JSONUtil"%>
<%@page import="com.sam.bean.Teacher"%>
<%@page import="com.sam.bean.Parmes"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@page import="org.apache.ibatis.session.SqlSessionFactoryBuilder"%>
<%@page import="org.apache.ibatis.session.SqlSessionFactory"%>
<%@page import="org.apache.ibatis.io.Resources"%>
<%@page import="java.io.InputStream"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE HTML >
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
		*{padding:0;margin:0}
		a{text-decoration: none;}
		body{font-size:14px;font-family:"微软雅黑"}
		#wrap{width:960px;height:640px;background:#999;margin:20px auto}
		dl dd{background:#111;color:#fff;padding:10px;font-weight: 700;font-size:18px;}
		dl dt p{padding-left:20px;background:#666;color:#fff;margin-top:1px;font-size:12px;line-height: 26px;}
		dl dt p:hover{background:#333}
		.more{background:#333;text-align:center;color:#fff;padding:10px;}
		.more a{display: block;color: #fff;}
	</style>
	<script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>
  </head>
  <body>
  
  	<%
  		SqlSessionFactory sessionFactory = (SqlSessionFactory)application.getAttribute("sessionFactory");
	  	SqlSession sqlSession = sessionFactory.openSession();
	  	Parmes params = new Parmes();
		List<Teacher> teachers = sqlSession.selectList("com.tz.bean.Teacher.findTeachers",params);
		//放作用域
		pageContext.setAttribute("teachers", teachers);
  	%>
  	<div id="wrap">
	  	<c:forEach var="teacher" items="${teachers}">
		  	<dl>
		  		<dd>${teacher.username}</dd>
		  		<dt>
		  			<div id="teacherbox-${teacher.id}">
			  			<c:forEach items="${teacher.students}" var="student" varStatus="sindex">
			  				<p><span>${sindex.count}</span>：${student.username }</p>
			  			</c:forEach>
		  			</div>
		  			<c:if test="${teacher.studentCount>10}">
		  				<div class="more"><a href="javascript:void(0);" class="loadingstudents" pageno="1" pagesize="10" data-count="${teacher.studentCount}" data-tid="${teacher.id}">加载更多学生</a></div>
		  			</c:if>
		  		</dt>
		  	</dl>
	  	</c:forEach>
  	</div>
  	
  	<script type="text/javascript">
  		$(function(){
  			$(".loadingstudents").click(function(){
  				var $this = $(this);
  				var tid= $this.data("tid");
  				var count = $this.data("count");
  				var pageNo = $this.attr("pageno")*1;
  				var pageSize = $this.attr("pagesize")*1;
  				var pno = pageNo*pageSize;
  				var params = {tid:tid,pageNo:pno,pageSize:pageSize};
  				if(pno>=count){
  					 $this.text("数据加载完毕");
  					return;
  				}
  				$.ajax({
  					type:"post",
  					url:"data.jsp",
  					data:params,
  					success:function(data){
  						pageNo++;
  						$("#teacherbox-"+tid).append(data);
  						$this.attr("pageno",pageNo);
  						sortId(tid);
  					}
  				});
  			});
  			
  			function sortId(tid){
  				$("#teacherbox-"+tid).find("p").each(function(i){
  					$(this).find("span").text(i+1);
  				});
  			}
  		});
  	</script>
  </body>
</html>
