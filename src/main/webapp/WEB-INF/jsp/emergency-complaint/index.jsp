<%@ include file="../partials/header.jspf" %>
<div class="ui attached inverted segment">
	<div class="ui inverted secondary menu">
		<div class="ui container">
			<div class="item"><a href="/">Cypher-X</a></div>
		</div>
	</div>
</div>

<div class="emergency-complaint-form">
	<div class="ui centered grid container">
		<div class="nine wide column">
			<a href="/"
				><button class="ui labeled icon button">
					<i class="angle left icon"></i>
					Go Back
				</button></a
			>

			<c:if test="${validationError}">
				<div class="ui warning message">
					<div class="content">
						<div class="header">
							Validation failed!
						</div>
						<form:errors path="people.*" />
					</div>
				</div>
			</c:if>
			<h1 class="form-header">File a Fast Complaint</h1>
			<div class="ui fluid card">
				<div class="content">
					<form:form
						class="ui form"
						action="/emergency-complaint"
						method="post"
						modelAttribute="people"
					>
						<div class="field">
							<form:label
								path="emergencyComplaint.complaint"
								for="complaint"
							>
								Emergency Complaint
							</form:label>
							<form:textarea
								type="text"
								name="complaint"
								id="complaint"
								path="emergencyComplaint.complaint"
								required="true"
								maxlength="255"
								placeholder="Enter your complaint (255 characters only)"
							></form:textarea>
						</div>
						<div class="field">
							<form:label path="name" for="name">Name</form:label>
							<form:input
								path="name"
								type="text"
								name="name"
								id="name"
								required="true"
								placeholder="Enter your name"
							/>
						</div>
						<div class="field">
							<form:label path="phoneNumber" for="phoneNumber"
								>Phone Number</form:label
							>
							<form:input
								path="phoneNumber"
								type="tel"
								name="phoneNumber"
								id="phoneNumber"
								pattern="[789][0-9]{9}"
								title="10 digit mobile number"
								required="true"
								placeholder="Enter your Phone Number"
							/>
						</div>
						<button
							class="ui primary labeled icon button"
							type="submit"
						>
							<i class="paper plane icon"></i>
							Complain
						</button>
					</form:form>
					<%@ include file="../partials/header.jspf" %>
				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="../partials/footer.jspf" %>
