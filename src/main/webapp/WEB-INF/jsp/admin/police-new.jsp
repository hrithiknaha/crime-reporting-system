<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<title>CRS | Kolkata</title>
	</head>
	<body>
		<p>Add New Police</p>
		<form:form
			action="/admin/police/new"
			method="post"
			modelAttribute="user"
		>
			<form:label path="username" for="username">Username</form:label>
			<form:input
				path="username"
				type="text"
				name="username"
				id="username"
			/>

			<form:label path="password" for="password">Password</form:label>
			<form:input
				path="password"
				type="password"
				name="password"
				id="password"
			/>

			<form:label path="police.name" for="name">Name</form:label>
			<form:input path="police.name" type="text" name="name" id="name" />

			<button type="submit">Submit</button>
		</form:form>
	</body>
</html>