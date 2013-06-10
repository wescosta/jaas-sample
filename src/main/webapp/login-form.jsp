<!DOCTYPE html>
<html>
	<head>
		<title>JAAS Sample - Login</title>
		<meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1.0">
		<link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet">
	</head>
	<body>
		<div class="container">
			<div class="row">
				<div class="span3 hidden-phone"></div>
				<div class="span6" id="form-login">
					<form class="form-horizontal well" action="j_security_check" method="post">
						<fieldset>
							<legend>Login Form</legend>
							<div class="control-group">
								<div class="control-label">
									<label>Username</label>
								</div>
								<div class="controls">
									<input type="text" id="login" name="j_username" placeholder="your.name@youremail.com" class="input-large"/>
								</div>
							</div>
							
							<div class="control-group">
								<div class="control-label">
									<label>Password</label>
								</div>
								<div class="controls">
									<input type="password" id="password" name="j_password" placeholder="type your password" class="input-large"/>
								</div>
							</div>
	
							<div class="control-group">
								<div class="controls">
									<button type="submit" id="submit" class="btn btn-primary button-loading" data-loading-text="Loading...">Sign in</button>
								</div>
							</div>
						</fieldset>
					</form>
				</div>
			</div>
		</div>
		<script src="http://code.jquery.com/jquery-1.10.0.min.js"></script>
		<script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
	</body>
</html>