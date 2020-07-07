<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<title>Kolkata | CRS</title>
	</head>
	<body>
		<h1>Users Page</h1>
		<p>${user.username}</p>
		<p>${user.citizen.email}</p>

		<a href="/user/${user.username}/complaint">Add Complaint</a>
		<c:forEach items="${user.citizen.complaint}" var="complaints">
			<table style="width: 100%; border: 1px solid black;">
				<tr>
					<th>Complaint</th>
					<th>Status</th>
				</tr>
				<tr>
					<td><c:out value="${complaints.text}" /></td>
					<td><c:out value="${complaints.status}" /></td>
				</tr>
			</table>
		</c:forEach>
	</body>
</html>
