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
			<form:label path="citizen.name" for="name">Name</form:label>
			<form:input path="citizen.name" type="text" required="true" />

			<form:label path="citizen.email" for="email">Email</form:label>
			<form:input path="citizen.email" type="email" required="true" />

			<form:label path="username" for="username">Username</form:label>
			<form:input path="username" type="text" required="true" />

			<form:label path="password" for="password">Password</form:label>
			<form:input
				path="password"
				type="password"
				name="password"
				id="password"
				required="true"
			/>

			<button type="submit">Register</button>
		</form:form>
	</body>
</html>
