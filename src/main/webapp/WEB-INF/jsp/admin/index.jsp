<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<title>CRS | Kolkata</title>
	</head>
	<body>
		<h1>Admin Page</h1>
		<p>${user.username}</p>
		<p>${user.admin.name}</p>

		<p>Complaint</p>
		<c:forEach items="${complaints}" var="complaint">
			<table style="width: 100%; border: 1px solid black;">
				<tr>
					<th>Image</th>
					<th>Complaint</th>
					<th>Status</th>
					<th>Admin Actions</th>
				</tr>
				<tr>
					<th><img src="${complaint.imagePath}" alt="image"></th>
					<td><c:out value="${complaint.text}" /></td>
					<td><c:out value="${complaint.status}" /></td>
					<td>
						<a href="/admin/complaint/${complaint.id}/edit">Edit</a>
						<a href="/admin/complaint/${complaint.id}/delete"
							>Delete</a
						>
					</td>
				</tr>
			</table>
		</c:forEach>

		<p>Police</p>
		<a href="/admin/police/new">Add New Police Officer</a>
		<c:forEach items="${police}" var="policeList">
			<table style="width: 100%; border: 1px solid black;">
				<tr>
					<th>Name</th>
					<th>Admin Actions</th>
				</tr>
				<tr>
					<td><c:out value="${policeList.name}" /></td>
					<td>
						<a href="/admin/police/${policeList.id}/edit"
							>Edit Details</a
						>
						<a href="/admin/police/${policeList.id}/delete"
							>Delete Officer</a
						>
					</td>
				</tr>
			</table>
		</c:forEach>

		<p>Citizen</p>
		<a href="/admin/citizen/new">Add New Citizen</a>
		<c:forEach items="${citizen}" var="citizenList">
			<table style="width: 100%; border: 1px solid black;">
				<tr>
					<th>Name</th>
					<th>Email</th>
					<th>Admin Actions</th>
				</tr>
				<tr>
					<td><c:out value="${citizenList.name}" /></td>
					<td><c:out value="${citizenList.email}" /></td>
					<td>
						<a href="/admin/citizen/${citizenList.id}/edit"
							>Edit Details</a
						>
						<a href="/admin/citizen/${citizenList.id}/delete"
							>Delete Citizen</a
						>
					</td>
				</tr>
			</table>
		</c:forEach>
	</body>
</html>
