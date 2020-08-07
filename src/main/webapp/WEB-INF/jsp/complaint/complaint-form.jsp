<%@ include file="../partials/header.jspf" %>
<div class="ui attached inverted segment">
	<div class="ui inverted secondary menu">
		<div class="ui container">
			<div class="item"><a href="/">Cypher-X</a></div>
			<a class="right active item" href="/logout">Logout</a>
		</div>
	</div>
</div>
<div class="complaint-form">
	<div class="ui centered grid container">
		<div class="nine wide column">
			<a href="/user"
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
						<form:errors path="complaint.*" />
					</div>
				</div>
			</c:if>
			<h1 class="form-header">File a Complaint</h1>
			<div class="ui fluid card">
				<div class="content">
					<form:form
						class="ui form"
						action="/user/${username}/complaint"
						method="post"
						modelAttribute="complaint"
						enctype="multipart/form-data"
					>
						<div class="field">
							<form:label path="text" for="complaint"
								>Complaint</form:label
							>
							<form:textarea
								name="complaint"
								id="complaint"
								path="text"
								required="true"
								minlength="2"
								maxlength="255"
								placeholder="Enter your complaint (255 Characters Only)"
							></form:textarea>
						</div>
						<div class="field">
							<label for="file">Image</label>
							<input
								type="file"
								name="file"
								id="file"
								required="true"
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
				</div>
			</div>
		</div>
	</div>
</div>

<%@ include file="../partials/footer.jspf" %>
