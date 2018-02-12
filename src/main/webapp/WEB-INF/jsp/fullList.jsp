<!DOCTYPE html>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

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
	
	
	<sql:setDataSource var="snapshot" driver="org.h2.Driver"
		url="jdbc:h2:mem:testdb" user="sa" password="" />

	<sql:query dataSource="${snapshot}" var="result">
         SELECT * from human;
      </sql:query>

	<table border="1" width="50%">
		<tr>
			<th>ID</th>
			<th>Name</th>
		</tr>

		<c:forEach var="row" items="${result.rows}">
			<tr>
				<td><c:out value="${row.id}" /></td>
				<td><c:out value="${row.name}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>

</html>