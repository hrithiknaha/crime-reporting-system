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
		<form:errors path="people.*" cssStyle="color: #ff0000;" />
		<div>
			<h1>Lodge an Emergency Complaint Now!!</h1>
			<form:form
				action="/emergency-complaint"
				method="post"
				modelAttribute="people"
			>
				<form:label path="emergencyComplaint.complaint" for="complaint">
					Emergency Complaint
				</form:label>
				<form:input
					type="text"
					name="complaint"
					id="complaint"
					path="emergencyComplaint.complaint"
					required="true"
				/>

				<form:label path="name" for="name">Name</form:label>
				<form:input
					path="name"
					type="text"
					name="name"
					id="name"
					required="true"
				/>

				<form:label path="phoneNumber" for="phoneNumber"
					>Phone Number</form:label
				>
				<form:input
					path="phoneNumber"
					type="Number"
					name="phoneNumber"
					id="phoneNumber"
					required="true"
					min="7000000000"
					max="9999999999"
				/>

				<button type="submit">Lodge</button>
			</form:form>
		</div>
	</body>
</html>
