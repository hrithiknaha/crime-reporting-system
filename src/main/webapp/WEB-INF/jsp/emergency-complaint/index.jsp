<%@ include file="../partials/header.jspf" %>
<div class="ui attached inverted segment">
	<div class="ui inverted secondary menu">
		<div class="ui container">
			<div class="item"><a href="/">Cypher-X</a></div>
			<a class="right active item" href="/logout">Logout</a>
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
							<form:input
								type="text"
								name="complaint"
								id="complaint"
								path="emergencyComplaint.complaint"
								required="true"
							/>
						</div>
						<div class="field">
							<form:label path="name" for="name">Name</form:label>
							<form:input
								path="name"
								type="text"
								name="name"
								id="name"
								required="true"
							/>
						</div>
						<div class="field">
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
								value="null"
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
