<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<title>CRS | KOLKATA</title>
	</head>
	<body>
		<p>${police.name}</p>
		<form action="/admin/police/${police.id}/edit" method="POST">
			<label for="name">Name</label>
			<input type="text" name="name" id="name" value="${police.name}" />

			<button type="submit">Edit</button>
		</form>
	</body>
</html>
