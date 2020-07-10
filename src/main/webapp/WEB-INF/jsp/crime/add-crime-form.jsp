<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<title>CRS | KOLKATA</title>
	</head>
	<body>
		<form:errors path="crime.*" cssStyle="color: #ff0000;" />
		<form:form action="/crime/new" method="POST" modelAttribute="crime">
			<form:label path="name" for="name">Name</form:label>
			<form:input
				path="name"
				type="text"
				name="name"
				id="name"
				required="true"
			/>

			<form:label path="location" for="location">Location</form:label>
			<form:input
				path="location"
				type="text"
				name="location"
				id="location"
				required="true"
			/>

			<form:label path="age" for="age">Age</form:label>
			<form:input
				path="age"
				type="number"
				name="age"
				id="age"
				required="true"
			/>

			<form:label path="status" for="status">Status</form:label>
			<form:input
				path="status"
				type="text"
				name="status"
				id="status"
				required="true"
			/>

			<form:label path="type" for="type">Type</form:label>

			<form:select path="type" name="type" id="type" required="true">
				<option value="Missing">Missing</option>
				<option value="Murder">Murder</option>
				<option value="Theft">Theft</option>
				<option value="Breaking and Entering"
					>Breaking and Entering</option
				>
			</form:select>

			<button type="submit">Submit</button>
		</form:form>
	</body>
</html>
