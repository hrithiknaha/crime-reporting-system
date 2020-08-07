<%@ include file="../partials/header.jspf" %>
<div class="ui attached inverted segment">
	<div class="ui inverted secondary menu">
		<div class="ui container">
			<div class="item"><a href="/">Cypher-X</a></div>
			<a class="right active item" href="/logout">Logout</a>
		</div>
	</div>
</div>
<div class="emergency-complaint-edit-form">
	<div class="ui centered grid container">
		<div class="nine wide column">
			<a href="/police"
				><button class="ui labeled icon button">
					<i class="angle left icon"></i>
					Go Back
				</button></a
			>

			<!-- <c:if test="${validationError}">
				<div class="ui warning message">
					<div class="content">
						<div class="header">
							Validation failed!
						</div>
						<form:errors path="complaint.*" />
					</div>
				</div>
			</c:if> -->
			<h1 class="form-header">
				Status Change Id - ${emergencyComplaint.id}
			</h1>
			<div class="ui fluid card">
				<div class="content">
					<form:form
						class="ui form"
						action="/emergency-complaint/${complaintId}/status/edit"
						method="post"
						modelAttribute="emergencyComplaint"
						enctype="multipart/form-data"
					>
						<div class="field disabled">
							<form:label path="complaint" for="complaint"
								>Complaint</form:label
							>
							<form:textarea
								name="complaint"
								id="complaint"
								path="complaint"
								required="true"
								value="${emergencyComplaint.complaint}"
							></form:textarea>
						</div>
						<div class="field">
							<label for="status">Complaint Status</label>
							<input
								type="text"
								name="status"
								id="status"
								value="${emergencyComplaint.status}"
								required="true"
								minlength="2"
								placeholder="Update Status"
							/>
						</div>
						<button
							class="ui primary labeled icon button"
							type="submit"
						>
							<i class="paper plane icon"></i>
							Edit Status
						</button>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>

<%@ include file="../partials/header.jspf" %>
