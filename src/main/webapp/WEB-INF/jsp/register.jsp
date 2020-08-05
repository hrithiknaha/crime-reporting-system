<%@ include file="./partials/header.jspf" %>
<div class="ui attached inverted segment">
	<div class="ui inverted secondary menu">
		<div class="ui container">
			<div class="item"><a href="/">Cypher-X</a></div>
		</div>
	</div>
</div>
<div class="registerpage">
	<div class="ui centered grid container">
		<div class="nine wide column">
			<a href="/"
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
						<form:errors path="user.*" />
					</div>
				</div>
			</c:if>
			<h1 class="form-header">Registration</h1>
			<div class="ui fluid card">
				<div class="content">
					<form:form
						class="ui form"
						action="/register"
						method="post"
						modelAttribute="user"
					>
						<div class="field">
							<form:label path="citizen.name" for="name"
								>Name</form:label
							>
							<form:input
								path="citizen.name"
								type="text"
								required="true"
							/>
						</div>
						<div class="field">
							<form:label path="citizen.email" for="email"
								>Email</form:label
							>
							<form:input
								path="citizen.email"
								type="email"
								required="true"
							/>
						</div>
						<div class="field">
							<form:label path="username" for="username"
								>Username</form:label
							>
							<form:input
								path="username"
								type="text"
								required="true"
							/>
						</div>
						<div class="field">
							<form:label path="password" for="password"
								>Password</form:label
							>
							<form:input
								path="password"
								type="password"
								name="password"
								id="password"
								required="true"
							/>
						</div>
						<button
							class="ui primary labeled icon button"
							type="submit"
						>
							<i class="lock alternate icon"></i>
							Register
						</button>
					</form:form>
				</div>
			</div>
			<p>Already Registered? <a href="/login">Login</a></p>
		</div>
	</div>
</div>
<%@ include file="./partials/footer.jspf" %>
