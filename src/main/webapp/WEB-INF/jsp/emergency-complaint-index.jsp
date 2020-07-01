<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<title>CRS | Kolkata</title>
	</head>
	<body>
		<div>
			<h1>Lodge an Emergency Complaint Now!!</h1>
			<form:form
				action="/emergency-complaint"
				method="post"
				modelAttribute="people"
			>
				<!-- <spring:bind path="emergencyComplaint.complaint"> -->
				<form:label path="emergencyComplaint.complaint" for="complaint">
					Emergency Complaint
				</form:label>
				<form:input
					type="text"
					name="complaint"
					id="complaint"
					path="emergencyComplaint.complaint"
				/>
				<!-- </spring:bind> -->
				<!-- <spring:bind path="emergencyComplaint.status"> -->
				<!-- <form:label path="emergencyComplaint.status" for="status">
					Status
				</form:label>
				<form:input
					type="text"
					name="status"
					id="status"
					path="emergencyComplaint.status"
				></form:input> -->
				<!-- </spring:bind> -->

				<form:label path="name" for="name">Name</form:label>
				<form:input path="name" type="text" name="name" id="name" />

				<form:label path="phoneNumber" for="phoneNumber"
					>Phone Number</form:label
				>
				<form:input
					path="phoneNumber"
					type="text"
					name="phoneNumber"
					id="phoneNumber"
				/>

				<button type="submit">Lodge</button>
			</form:form>
		</div>
	</body>
</html>
