<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<title>CRS | Kolkata</title>
	</head>
	<body>
		<form:form
			action="/user/${username}/complaint"
			method="post"
			modelAttribute="complaint"
		>
			<form:label path="text" for="complaint">Complaint</form:label>
			<form:input
				type="text"
				name="complaint"
				id="complaint"
				path="text"
			></form:input>

			<button type="submit">Submit</button>
		</form:form>
	</body>
</html>
