<%@ include file="../partials/header.jspf" %>
<div class="ui attached inverted segment">
	<div class="ui inverted secondary menu">
		<div class="ui container">
			<div class="item"><a href="/">Cypher-X</a></div>
			<a class="right active item" href="/logout">Logout</a>
		</div>
	</div>
</div>

<div class="adminpage ui container">
	<div class="adminpage-info ui card">
		<div class="content">
			<div class="center aligned header">${user.admin.name}</div>
		</div>
		<div class="extra content">
			<div class="center aligned author">
				${user.username}
			</div>
		</div>
	</div>

	<h2 class="ui header">Filed Complaints</h2>
	<table class="ui fixed table">
		<thead>
			<tr>
				<th>Image</th>
				<th>Complaint</th>
				<th>Status</th>
				<th>Admin Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${complaints}" var="complaint">
				<tr>
					<td>
						<img
							class="ui medium image"
							src="${complaint.imagePath}"
							alt="image"
						/>
					</td>
					<td><c:out value="${complaint.text}" /></td>
					<c:if test="${complaint.status == 'Investigation Pending'}">
						<c:set value="negative" var="cssClass"></c:set>
					</c:if>
					<td class="${cssClass}">
						<c:out value="${complaint.status}" />
					</td>
					<td>
						<a href="/admin/complaint/${complaint.id}/edit"
							><button class="mini ui button">
								Edit
							</button></a
						>
						<a href="/admin/complaint/${complaint.id}/delete"
							><div class="mini ui red button">Delete</div></a
						>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<a class="anchor-remove" href="/admin/police/new"
		><div class="adminpage-addpolice ui black button">
			Add New Police Officer
		</div></a
	>

	<h2 class="ui header">Police Personnel</h2>
	<table class="ui fixed table">
		<thead>
			<tr>
				<th>Name</th>
				<th>Admin Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${police}" var="policeList">
				<tr>
					<td><c:out value="${policeList.name}" /></td>
					<td>
						<a href="/admin/police/${policeList.id}/edit"
							><button class="mini ui button">
								Edit
							</button></a</a
						>
						<a href="/admin/police/${policeList.id}/delete"
							><div class="mini ui red button">Delete</div></a
						>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<a class="anchor-remove" href="/admin/citizen/new"
		><div class="adminpage-addpolice ui black button">
			Add New Citizen Details
		</div></a
	>

	<h2 class="ui header">Citizens</h2>
	<table class="ui fixed table">
		<thead>
			<tr>
				<th>Name</th>
				<th>Email</th>
				<th>Admin Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${citizen}" var="citizenList">
				<tr>
					<td><c:out value="${citizenList.name}" /></td>
					<td><c:out value="${citizenList.email}" /></td>
					<td>
						<a href="/admin/citizen/${citizenList.id}/edit"
							><button class="mini ui button">
								Edit
							</button></a
						>
						<a href="/admin/citizen/${citizenList.id}/delete"
							><div class="mini ui red button">Delete</div></a
						>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<%@ include file="../partials/header.jspf" %>
