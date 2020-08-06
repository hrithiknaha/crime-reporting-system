<%@ include file="../partials/header.jspf" %>
<div class="ui attached inverted segment">
	<div class="ui inverted secondary menu">
		<div class="ui container">
			<div class="item"><a href="/">Cypher-X</a></div>
		</div>
	</div>
</div>

<div class="complaint-submission ui container">
	<a href="/"
		><button class="ui labeled icon button">
			<i class="angle left icon"></i>
			Go Back
		</button></a
	>
	<h2 class="ui header">Submitted Emergency Complaint</h2>
	<table class="ui fixed table">
		<thead>
			<tr>
				<th>Complaint ID</th>
				<th>Fast Complaint</th>
				<th>Status</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${peopleComplaint.id}</td>
				<td>${peopleComplaint.complaint}</td>
				<td>${peopleComplaint.status}</td>
			</tr>
		</tbody>
	</table>
</div>
<%@ include file="../partials/footer.jspf" %>
