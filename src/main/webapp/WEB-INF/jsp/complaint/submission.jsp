<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<title>CRS | Kolkata</title>
	</head>
	<body>
		<h1>Complaint Submitted</h1>
		<p>${citizen.name}</p>
		<p>${complaint.text}</p>
		<p>${complaint.status}</p>
		<img src="${complaint.imagePath}" alt="" />
	</body>
</html>
