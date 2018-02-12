<!DOCTYPE html>
<%@ page import="java.util.*"%>

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
HumanJdbcRepository repo;

Logger logger = LoggerFactory.getLogger(this.getClass());
%>
<html>

<head>
</head>

<body>

	<%	
	try {
		logger.info("Select * From START!");
		List<Human> allHumansFromDBList = repo.findAll();		
		// IDE JON A TABLA
		%>
		<table border="1">
			<tr>
			<td>ID</td>
			<td>Name</td>
			</tr>
			
			<%
				for(int i = 0; i < allHumansFromDBList.size(); ++i) {
					Human human = allHumansFromDBList.get(i);
					logger.info(human.toString());
					%>
					<tr>
						<td><%=human.getId() %></td>
						<td><%=human.getName() %></td>
					</tr>
			 		<%
				}
				%>
		</table>
	<%
	}
	catch (Exception e) {
		logger.error(e.toString());
		%>
		<b>Problem with the database request!</b>
		<%
	}
	%>
	
</body>

</html>