<%@ include page="./partials/header.jsp" %>
<p>${citizen.name}</p>
<form action="/admin/citizen/${citizen.id}/edit" method="POST">
	<label for="name">Name</label>
	<input type="text" name="name" id="name" value="${citizen.name}" />

	<label for="email">Email</label>
	<input type="email" name="email" id="email" value="${citizen.email}" />

	<button type="submit">Edit</button>
</form>
<%@ include page="./partials/footer.jsp" %>
