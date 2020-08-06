<%@ include file="./partials/header.jspf" %>
<div class="homepage">
	<div class="homepage-hero">
		<img
			class="homepage-hero__img"
			src="https://images.unsplash.com/photo-1557081998-05f784dcdd41?ixlib=rb-1.2.1&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max&ixid=eyJhcHBfaWQiOjF9"
			alt="homepage background image"
		/>
		<div class="homepage-hero__text">
			<h1 class="homepage-hero__text_title">Cypher-X</h1>
			<h6 class="homepage-hero__text_subtitle">
				Your worries ends here. It is our take now.
			</h6>
			<div class="homepage-hero__text_button">
				<a class="anchor-remove" href="/login"
					><button class="ui green button">Login</button></a
				>
				<a class="anchor-remove" href="#fast-complaint"
					><button class="ui right labeled icon button">
						Fast Complain<i class="down arrow icon"></i></button
				></a>
			</div>
		</div>
	</div>

	<div id="homepage-body" class="homepage-body ui container">
		<div class="homepage-body__crime">
			<h3 class="homepage-body__ec_title">
				Crime Coverage
			</h3>

			<table class="ui fixed table">
				<thead>
					<tr>
						<th>Name</th>
						<th>Age</th>
						<th>Location</th>
						<th>Status</th>
						<th>Type</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${crimes}" var="crime">
						<tr>
							<td><c:out value="${crime.name}" /></td>
							<td><c:out value="${crime.age}" /></td>
							<td><c:out value="${crime.location}" /></td>
							<c:if test="${crime.status == 'Pending'}">
								<c:set value="negative" var="cssClass"></c:set>
							</c:if>
							<td class="${cssClass}">
								<c:out value="${crime.status}" />
							</td>
							<td><c:out value="${crime.type}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

		<div id="fast-complaint" class="homepage-body__ec">
			<h3 class="homepage-body__ec_title">Emergency Complaint</h3>
			<div class="homepage-body__ec-wrapper">
				<div class="homepage-body__ec-wrapper-file">
					<a class="anchor-remove" href="/emergency-complaint"
						><button
							class="homepage-body__ec-wrapper-button ui primary button"
						>
							File a Fast Complaint
						</button></a
					>
				</div>
				<div class="homepage-body__ec-wrapper-form">
					<form
						class="ui form"
						action="/emergency-complaint-status"
						method="post"
					>
						<div class="field">
							<label for="emergency-complaint-status"
								>Check Emergency Complaint Status</label
							>
							<input
								type="number"
								name="emergency-complaint-status"
								id="emergency-complaint-status"
								placeholder="Enter Emergency Complaint Id"
								required="true"
							/>
						</div>

						<button
							class="homepage-body__ec-wrapper-button ui positive button"
							type="submit"
						>
							Check
						</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>

<%@ include file="./partials/footer.jspf" %>
