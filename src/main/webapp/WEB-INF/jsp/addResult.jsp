<!DOCTYPE html>
<html>

<head>
</head>

<body>

	<b>Result:</b>
	<br>
	<%
		String name = request.getParameter("name");
		if (name.trim().length() == 0) {
		%>
			Empty name field!
			<br>
			<a href="/add">I want to try again!</a>
		<%
		} else {
			// DB CHECK
			
			if (name.equals("qwe")) {
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