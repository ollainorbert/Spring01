<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
</head>

<body>
<table border="1" width="50%">
		<tr>
			<th>ID</th>
			<th>Name</th>
		</tr>

		<c:forEach items="${humans}" var="human" >
			<tr>
				<td><c:out value="${human.id}" /></td>
				<td><c:out value="${human.name}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
<br><br>
<a href="/add">I want to record a name again!</a>

</html>