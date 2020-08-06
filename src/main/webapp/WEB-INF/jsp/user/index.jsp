<%@ include file="../partials/header.jspf" %>
<div class="ui attached inverted segment">
	<div class="ui inverted secondary menu">
		<div class="ui container">
			<div class="item"><a href="/">Cypher-X</a></div>
			<a class="right active item" href="/logout">Logout</a>
		</div>
	</div>
</div>
<div class="userpage ui container">
	<div class="userpage-info ui card">
		<div class="content">
			<div class="center aligned header">${user.citizen.name}</div>
			<div class="center aligned description">
				<p>
					${user.citizen.email}
				</p>
			</div>
		</div>
		<div class="extra content">
			<div class="center aligned author">
				${user.username}
			</div>
		</div>
	</div>

	<a class="anchor-remove" href="/user/${user.username}/complaint"
		><div class="userpage-addcomplaint ui black button">
			File Complaint
		</div></a
	>

	<h2 class="ui header">Filed Complaints</h2>
	<table class="ui fixed table">
		<thead>
			<tr>
				<th>Image</th>
				<th>Complaint</th>
				<th>Status</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${user.citizen.complaint}" var="complaint">
				<tr>
					<td>
						<img
							class="ui medium image"
							src="${complaint.imagePath}"
						/>
					</td>
					<td>
						<p><c:out value="${complaint.text}" /></p>
					</td>
					<c:if test="${complaint.status == 'Investigation Pending'}">
						<c:set value="negative" var="cssClass"></c:set>
					</c:if>
					<td class="${cssClass}">
						<c:out value="${complaint.status}" />
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<%@ include file="../partials/footer.jspf" %>
