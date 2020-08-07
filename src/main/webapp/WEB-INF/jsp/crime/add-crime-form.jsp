<%@ include file="../partials/header.jspf" %>
<div class="ui attached inverted segment">
	<div class="ui inverted secondary menu">
		<div class="ui container">
			<div class="item"><a href="/">Cypher-X</a></div>
			<a class="right active item" href="/logout">Logout</a>
		</div>
	</div>
</div>
<!-- <form:errors path="crime.*" cssStyle="color: #ff0000;" />
<form:form action="/crime/new" method="POST" modelAttribute="crime">
	<form:label path="name" for="name">Name</form:label>
	<form:input path="name" type="text" name="name" id="name" required="true" />

	<form:label path="location" for="location">Location</form:label>
	<form:input
		path="location"
		type="text"
		name="location"
		id="location"
		required="true"
	/>

	<form:label path="age" for="age">Age</form:label>
	<form:input path="age" type="number" name="age" id="age" required="true" />

	<form:label path="status" for="status">Status</form:label>
	<form:select path="status" name="status" id="status" required="true">
		<option value="Solved">Solved</option>
		<option value="Pending">Not Solved</option>
		>
	</form:select>

	<form:label path="type" for="type">Type</form:label>

	<form:select path="type" name="type" id="type" required="true">
		<option value="Missing">Missing</option>
		<option value="Murder">Murder</option>
		<option value="Theft">Theft</option>
		<option value="Breaking and Entering">Breaking and Entering</option>
	</form:select>

	<button type="submit">Submit</button>
</form:form> -->

<div class="loginpage">
	<div class="ui centered grid container">
		<div class="nine wide column">
			<a href="/police"
				><button class="ui labeled icon button">
					<i class="angle left icon"></i>
					Go Back
				</button></a
			>
			<c:if test="${validationError}">
				<div class="ui icon warning message">
					<i class="lock icon"></i>
					<div class="content">
						<div class="header">
							Validation failed!
						</div>
						<form:errors path="crime.*" />
					</div>
				</div>
			</c:if>
			<h1 class="form-header">Registration</h1>
			<div class="ui fluid card">
				<div class="content">
					<form:form
						class="ui form"
						action="/crime/new"
						method="POST"
						modelAttribute="crime"
					>
						<div class="field">
							<form:label path="name" for="name">Name</form:label>
							<form:input
								path="name"
								type="text"
								name="name"
								id="name"
								required="true"
								placeholder="Enter the Name"
							/>
						</div>
						<div class="field">
							<form:label path="location" for="location"
								>Location</form:label
							>
							<form:input
								path="location"
								type="text"
								name="location"
								id="location"
								required="true"
								placeholder="Enter the Location"
							/>
						</div>
						<div class="field">
							<form:label path="age" for="age">Age</form:label>
							<form:input
								path="age"
								type="number"
								name="age"
								id="age"
								required="true"
								min="0"
								placeholder="Enter the Age"
							/>
						</div>
						<div class="field">
							<form:label path="status" for="status"
								>Status</form:label
							>
							<form:select
								path="status"
								name="status"
								id="status"
								required="true"
							>
								<option value="Solved">Solved</option>
								<option value="Pending">Not Solved</option>
								>
							</form:select>
						</div>
						<div class="field">
							<form:label path="type" for="type">Type</form:label>

							<form:select
								path="type"
								name="type"
								id="type"
								required="true"
							>
								<option value="Missing">Missing</option>
								<option value="Murder">Murder</option>
								<option value="Theft">Theft</option>
								<option value="Breaking and Entering"
									>Breaking and Entering</option
								>
							</form:select>
						</div>
						<button
							class="ui primary labeled icon button"
							type="submit"
						>
							<i class="lock alternate icon"></i>
							File Crime
						</button>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="../partials/footer.jspf" %>
