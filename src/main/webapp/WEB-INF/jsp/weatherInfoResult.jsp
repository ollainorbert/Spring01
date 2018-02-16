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
	<a href="/weatherInfo">I want to check a city again!</a>
	<br>
	<br>
	<a href="/">Back to the Home Page!</a>
</body>

</html>