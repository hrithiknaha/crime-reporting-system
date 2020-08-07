<%@ include file="../partials/header.jspf" %>
<div class="ui attached inverted segment">
	<div class="ui inverted secondary menu">
		<div class="ui container">
			<div class="item"><a href="/">Cypher-X</a></div>
			<a class="right active item" href="/logout">Logout</a>
		</div>
	</div>
</div>
<div class="police-edit__page">
	<div class="ui centered grid container">
		<div class="nine wide column">
			<a href="/admin"
				><button class="ui labeled icon button">
					<i class="angle left icon"></i>
					Go Back
				</button></a
			>
			<h1 class="form-header">Edit Police ID - ${police.id}</h1>
			<div class="ui fluid card">
				<div class="content">
					<form
						class="ui form"
						action="/admin/police/${police.id}/edit"
						method="POST"
					>
						<div class="field">
							<label for="name">Name</label>
							<input
								type="text"
								name="name"
								id="name"
								value="${police.name}"
								required="true"
								minlength="2"
								placeholder="Enter Police Personnel's name"
							/>
						</div>
						<button
							class="ui primary labeled icon button"
							type="submit"
						>
							<i class="unlock alternate icon"></i>
							Edit Details
						</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>

<%@ include file="../partials/header.jspf" %>
