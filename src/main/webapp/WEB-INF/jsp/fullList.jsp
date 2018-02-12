<!DOCTYPE html>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<html>

<head>
</head>

<body>

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