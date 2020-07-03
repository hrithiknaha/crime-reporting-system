<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<title>Kolkata | CRS</title>
	</head>
	<body>
		<h1>Username ${user.username}</h1>
		<h1>Username ${user.name}</h1>
		<h1>Username ${user.password}</h1>
		<h1>Username ${user.roles}</h1>

		<form:form
			action="/users/complaint"
			method="post"
			modelAttribute="user"
		>
			<form:label path="complaint.text" for="complaint"
				>Complaint</form:label
			>
			<form:input
				type="text"
				name="complaint"
				id="complaint"
				path="complaint.text"
			></form:input>

			<button type="submit">Submit</button>
		</form:form>
	</body>
</html>
