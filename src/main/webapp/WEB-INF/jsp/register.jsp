<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<title>CRS | Kolkata</title>
	</head>
	<body>
		<h1>Citizen Register</h1>
		<form:form action="/register" method="post" modelAttribute="user">
			<form:label path="name" for="name">Name</form:label>
			<form:input path="name" type="text" />

			<form:label path="username" for="username">Username</form:label>
			<form:input path="username" type="text" />

			<form:label path="password" for="password">Password</form:label>
			<form:input
				path="password"
				type="password"
				name="password"
				id="password"
			/>

			<button type="submit">Register</button>
		</form:form>
	</body>
</html>
