<%@ include file="./partials/header.jspf" %>
<div class="ui attached inverted segment">
	<div class="ui inverted secondary menu">
		<div class="ui container">
			<div class="item"><a href="/">Cypher-X</a></div>
		</div>
	</div>
</div>
<div class="loginpage">
	<div class="ui centered grid container">
		<div class="nine wide column">
			<a href="/"
				><button class="ui labeled icon button">
					<i class="angle left icon"></i>
					Go Back
				</button></a
			>
			<c:if test="${not empty error}">
				<div class="ui icon warning message">
					<i class="lock icon"></i>
					<div class="content">
						<div class="header">
							Login failed!
						</div>
						<p>${error}</p>
					</div>
				</div>
			</c:if>
			<c:if test="${not empty logout}">
				<div class="ui icon success message">
					<i class="lock icon"></i>
					<div class="content">
						<div class="header">
							We'll get to it!
						</div>
						<p>${logout}</p>
					</div>
				</div>
			</c:if>
			<h1 class="form-header">Login</h1>
			<div class="ui fluid card">
				<div class="content">
					<form class="ui form" action="login" method="post">
						<div class="field">
							<label>Username</label>
							<input
								type="text"
								name="username"
								placeholder="Username"
							/>
						</div>
						<div class="field">
							<label>Password</label>
							<input
								type="password"
								name="password"
								placeholder="Password"
							/>
						</div>
						<button
							class="ui primary labeled icon button"
							type="submit"
						>
							<i class="unlock alternate icon"></i>
							Login
						</button>
					</form>
				</div>
			</div>
			<p>Not Registered? <a href="/register">Here</a></p>
		</div>
	</div>
</div>
<%@ include file="./partials/footer.jspf" %>
