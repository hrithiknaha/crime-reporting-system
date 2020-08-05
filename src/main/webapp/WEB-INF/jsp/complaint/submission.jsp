<%@ include file="../partials/header.jspf" %>
<div class="ui attached inverted segment">
	<div class="ui inverted secondary menu">
		<div class="ui container">
			<div class="item"><a href="/">Cypher-X</a></div>
			<a class="right active item" href="/logout">Logout</a>
		</div>
	</div>
</div>
<div class="complaint-submission ui container">
	<a href="/user"
		><button class="ui labeled icon button">
			<i class="angle left icon"></i>
			Go Back
		</button></a
	>
	<h2 class="ui header">Submitted Complaint</h2>
	<table class="ui single line table">
		<thead>
			<tr>
				<th>Plaintiff's Name</th>
				<th>Image</th>
				<th>Complaint</th>
				<th>Status</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${citizen.name}</td>
				<td>
					<img class="ui medium image" src="${complaint.imagePath}" />
				</td>
				<td>${complaint.text}</td>
				<td>${complaint.status}</td>
			</tr>
		</tbody>
	</table>
</div>

<%@ include file="../partials/header.jspf" %>
