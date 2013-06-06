<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>JAAS Sample - User List</title>
		<meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1.0">
		<link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet">
	</head>
	<body>
		<div class="container">
			<c:if test='<%=request.isUserInRole("ADMIN")%>'>
				<div class="btn-toolbar">
					<a href="?add" class="btn btn-primary">New User</a>
				</div>
			</c:if>
			<div class="well">
			    <table class="table">
			      <thead>
			        <tr>
			          <th>#</th>
			          <th>Login</th>
			          <th>Password</th>
			          <th style="width: 36px;"></th>
			        </tr>
			      </thead>
			      <tbody>
			      	<c:forEach items="${users}" var="user">
			      		<tr>
				          <td>${user.id}</td>
				          <td>${user.login}</td>
				          <td>${user.password}</td>
				          <td>
				              <a href="#"><i class="icon-pencil"></i></a>
				              <a href="#confirm-deletion-modal" role="button" data-toggle="modal"><i class="icon-remove"></i></a>
				          </td>
				        </tr>
			      	</c:forEach>
			      </tbody>
			    </table>
			</div>
			<div class="pagination">
			    <ul>
			        <li><a href="#">Prev</a></li>
			        <li><a href="#">1</a></li>
			        <li><a href="#">2</a></li>
			        <li><a href="#">3</a></li>
			        <li><a href="#">4</a></li>
			        <li><a href="#">Next</a></li>
			    </ul>
			</div>
			<div class="modal small hide fade" id="confirm-deletion-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			    <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
			        <h3 id="myModalLabel">Delete Confirmation</h3>
			    </div>
			    <div class="modal-body">
			        <p class="error-text">Are you sure you want to delete the user?</p>
			    </div>
			    <div class="modal-footer">
			        <button class="btn" data-dismiss="modal" aria-hidden="true">Cancel</button>
			        <button class="btn btn-danger" data-dismiss="modal">Delete</button>
			    </div>
			</div>
		</div>
		<script src="http://code.jquery.com/jquery-1.10.0.min.js"></script>
		<script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
	</body>
</html>