<!DOCTYPE html>
<%@page import="org.springframework.beans.factory.annotation.Autowired"%>
<%@page import="com.example.demo.repositories.HumanJdbcRepository"%>
<%@page import="org.slf4j.Logger" %>
<%@page import="org.slf4j.LoggerFactory" %>

<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>

<html>

<head>
</head>

<body>

	<b>Result:</b>
	<br>
	<%
		Logger logger = LoggerFactory.getLogger(this.getClass());
	
		String name = request.getParameter("name");
		if (name.trim().length() == 0) {
		%>
			Empty name field!
			<br>
			<a href="/add">I want to try again!</a>
		<%
		} else {
			boolean isItIn = true;
			// DB CHECK
			

			//repo.findById(10001);
			
			if (name.equals(!isItIn)) {				
				%>
				<b>Success!</b>
				<%
			} else {
			%>
				<b>That name is already in!</b>
				<br>
				<a href="/add">I want to try again!</a>
			<%
			}
		}
	%>

	<br>
	<br>
	<br>
	<a href="/fullList">Navigate to the Full list Page!</a>
</body>

</html>