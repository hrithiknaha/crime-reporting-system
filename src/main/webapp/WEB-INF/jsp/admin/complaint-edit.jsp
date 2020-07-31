<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<title>CRS | KOLKATA</title>
	</head>
	<body>
		<form action="/admin/complaint/${complaint.id}/edit" method="POST">
			<label for="complaint">Complaint</label>
			<input
				type="text"
				name="complaint"
				id="complaint"
				value="${complaint.text}"
			/>

			<label for="status">Status</label>
			<input
				type="text"
				name="status"
				id="status"
				value="${complaint.status}"
			/>

			<button type="submit">Edit</button>
		</form>
	</body>
</html>
