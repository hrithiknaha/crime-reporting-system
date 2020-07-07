<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<title>CRS | KOLKATA</title>
	</head>
	<body>
		<p>${citizen.name}</p>
		<form action="/admin/citizen/${citizen.id}/edit" method="POST">
			<label for="name">Name</label>
			<input type="text" name="name" id="name" value="${citizen.name}" />

			<label for="email">Email</label>
			<input
				type="email"
				name="email"
				id="email"
				value="${citizen.email}"
			/>

			<button type="submit">Edit</button>
		</form>
	</body>
</html>
