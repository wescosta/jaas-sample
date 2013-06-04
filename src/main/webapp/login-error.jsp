<!DOCTYPE html>
<html>
	<head>
		<title>JAAS Sample - Login Error</title>
		<meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1.0">
		<link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet">
	</head>
	<body>
		<div class="container">
			<div class="alert alert-error">
				Login failed. The username or password is wrong.<br/>
				<a id="back-button" href="#">Try again</a>
			</div>
		</div>
		<script src="http://code.jquery.com/jquery-1.10.0.min.js"></script>
		<script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
		
		<script type="text/javascript">
			$(function(){
				$("#back-button").on("click", function(e){
					e.preventDefault();
					window.history.back();
				});
			});
		</script>
	</body>
</html>