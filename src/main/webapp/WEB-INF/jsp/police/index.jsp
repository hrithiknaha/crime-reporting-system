<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<title>Kolkata | CRS</title>
	</head>
	<body>
		<h1>Police Page</h1>
		<p>${user.username}</p>
		<p>${user.police.name}</p>

		<c:forEach items="${complaints}" var="complaint">
			<table style="width: 100%; border: 1px solid black;">
				<tr>
					<th>Complaint</th>
					<th>Status</th>
					<th>Update Status</th>
				</tr>
				<tr>
					<td><c:out value="${complaint.text}" /></td>
					<td><c:out value="${complaint.status}" /></td>
					<td>
						<a href="/complaint/${complaint.id}/status/edit"
							>Update Status</a
						>
					</td>
				</tr>
			</table>
		</c:forEach>

		<p>Emergency Complaints</p>

		<c:forEach items="${emergencyComplaints}" var="emergencyComplaint">
			<table style="width: 100%; border: 1px solid black;">
				<tr>
					<th>Complaint</th>
					<th>Status</th>
				</tr>
				<tr>
					<td><c:out value="${emergencyComplaint.complaint}" /></td>
					<td><c:out value="${emergencyComplaint.status}" /></td>
					<td>
						<a
							href="/emergency-complaint/${emergencyComplaint.id}/status/edit"
							>Update Status</a
						>
					</td>
				</tr>
			</table>
		</c:forEach>
	</body>
</html>
