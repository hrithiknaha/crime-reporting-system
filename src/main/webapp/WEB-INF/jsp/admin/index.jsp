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
	</body>
</html>
