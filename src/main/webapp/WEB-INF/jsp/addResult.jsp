<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
</head>

<body>
	<b>Result:</b>
	<br>
	<p><c:out value="${error}"/></p>
	<p><c:out value="${result}"/></p>
	<br>
	<a href="/add">I want to record a name again!</a>
	<br>
	<br>
	<a href="/listHumans">Navigate to the Full list Page!</a>
</body>

</html>