<!DOCTYPE html>
<%@ page isErrorPage="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
</head>

<body>
	Error!
	<p>
		<c:out value="${errorMsgId}" />
	</p>

	<br>
	<a href="/add">I want to record a name again!</a>
	<br>
	<a href="/listHumans">Navigate to the Full list Page!</a>

</body>

</html>