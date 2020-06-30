<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<title>Kolkata | CRS</title>
	</head>
	<body>
		<h1>Home Page | Crime Reporting System</h1>
		<div>
			<h3>No Crime as of now!</h3>
			<div>
				<h3>Wanted</h3>
				<p>No one!</p>
			</div>
			<div>
				<h3>Missing</h3>
				<p>No One!</p>
			</div>
			<div>
				<h3>Emergency Complaint</h3>
				<button><a href="/emergency-complaint">Lodge Here</a></button>
				<div>
					<form action="/emergency-complaint-status" method="post">
						<label for="emergency-complaint-status">Status</label>
						<input
							type="number"
							name="emergency-complaint-status"
							id="emergency-complaint-status"
						/>
						<button type="submit">Check</button>
					</form>
				</div>
			</div>
		</div>
	</body>
</html>
