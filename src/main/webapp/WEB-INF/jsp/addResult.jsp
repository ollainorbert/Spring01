<!DOCTYPE html>
<%@page import="org.springframework.beans.factory.annotation.Autowired"%>
<%@page import="com.example.demo.repositories.HumanJdbcRepository"%>
<%@page import="org.slf4j.Logger" %>
<%@page import="org.slf4j.LoggerFactory" %>
<%@page import="com.example.demo.models.Human" %>
<%@ page import="org.springframework.web.context.support.SpringBeanAutowiringSupport"%>

<%!
public void jspInit() 
{
    SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, getServletContext());
}

@Autowired
HumanJdbcRepository repo = new HumanJdbcRepository();
%>

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
			Human human = repo.findByName(name);
			
			if (human != null) {
				logger.info("This name is already in.");
				%>
				<b>That name is already in!</b>
				<br>
				<a href="/add">I want to try again!</a>
				<%
			}
			else {
				logger.info("No match, insert start");
				// INSERT
				Human newHuman = new Human(name);
				//newHuman.setId(10004);
				try {
					repo.insert(newHuman);
					logger.info("Insert done!");
					%>
					<b>Success!</b>
					<%
				}
				catch(Exception e) {
					logger.error("Insert failed: " + e.toString());
					%>
					<b>Error with the insert!</b>
					<br>
					<a href="/add">I want to try again!</a>
					<%
				}			
			}
		}
	%>

	<br>
	<br>
	<br>
	<a href="/fullList">Navigate to the Full list Page!</a>
</body>

</html>