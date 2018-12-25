<%@page import="com.sam.bean.Student"%>
<%@page import="com.sam.bean.Parmes"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@page import="org.apache.ibatis.session.SqlSessionFactory"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%

	SqlSessionFactory sessionFactory = (SqlSessionFactory)application.getAttribute("sessionFactory");
	SqlSession sqlSession = sessionFactory.openSession();
	Parmes params = new Parmes();
	String tid = request.getParameter("tid");
	String pageNo = request.getParameter("pageNo");
	String pageSize = request.getParameter("pageSize");
	params.setPageNo(Integer.parseInt(pageNo));
	params.setPageSize(Integer.parseInt(pageSize));
	List<Student> students = sqlSession.selectList("com.tz.bean.Teacher.loadStudentsByTid",params);
	pageContext.setAttribute("students", students);
%>

<c:forEach items="${students}" var="student" varStatus="sindex">
	<p><span></span>：${student.username }</p>
</c:forEach>