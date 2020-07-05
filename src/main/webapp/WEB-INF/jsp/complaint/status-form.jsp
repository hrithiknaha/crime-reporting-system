<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<title>CRS | Kolkata</title>
	</head>
	<body>
		<h1>Edit Complaint Status</h1>
		<p>${complaint.text}</p>
		<form action="/complaint/${complaintId}/status/edit" method="POST">
			<label for="status">Complaint Status</label>
			<input
				type="text"
				name="status"
				id="status"
				value="${complaint.status}"
			/>
			<button type="submit">Update</button>
		</form>
	</body>
</html>
