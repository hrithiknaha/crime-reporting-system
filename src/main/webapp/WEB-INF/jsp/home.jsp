<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<title>Kolkata | CRS</title>
	</head>
	<body>
		<h1>Home Page | Crime Reporting System</h1>
		<div>
			<h3>Crime</h3>
			<c:forEach items="${crimes}" var="crime">
				<table style="width: 100%; border: 1px solid black;">
					<tr>
						<th>Name</th>
						<th>Age</th>
						<th>Location</th>
						<th>Status</th>
						<th>Type</th>
					</tr>
					<tr>
						<td><c:out value="${crime.name}" /></td>
						<td><c:out value="${crime.age}" /></td>
						<td><c:out value="${crime.location}" /></td>
						<td><c:out value="${crime.status}" /></td>
						<td><c:out value="${crime.type}" /></td>
					</tr>
				</table>
			</c:forEach>
			<div>
				<h3>Emergency Complaint</h3>
				<button><a href="/emergency-complaint">Lodge Here</a></button>
				<div>
					<form action="/emergency-complaint-status" method="post">
						<label for="emergency-complaint-status">Status</label>
						<input
							type="number"
							name="emergency-complaint-status"
							id="emergency-complaint-status"
						/>
						<button type="submit">Check</button>
					</form>
				</div>
			</div>
		</div>
	</body>
</html>
