<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Registration</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>

</head>
<body>
	<nav class="navbar navbar-expand-sm navbar-dark bg-dark mb-3">
		<div class="container">
			<a href="/" class="navbar-brand">IES</a>
			<ul class="navbar-nav">
				<li class="nav-item dropdown"><a href="#"
					class="nav-link dropdown-toggle" data-toggle="dropdown">Application
						Registration</a>
					<div class="dropdown-menu">
						<a href="/appl" class="dropdown-item">Create
							Application</a> <a href="/ViewApplication" class="dropdown-item">View
							Application</a>
					</div></li>

				<li class="nav-item"><a href="#" class="nav-link">Data
						Collection</a></li>
				<li class="nav-item dropdown"><a href="#"
					class="nav-link dropdown-toggle" data-toggle="dropdown">Admin</a>
					<div class="dropdown-menu">
						<a href="/account" class="dropdown-item">Create Account</a> <a
							href="/ViewAccounts" class="dropdown-item">View Account</a> <a
							href="plan" class="dropdown-item">Create Plan</a> <a
							href="/ViewPlans" class="dropdown-item">View Plan</a>
					</div></li>
				<li class="nav-item"><a href="#" class="nav-link">Logout</a></li>
			</ul>
		</div>
	</nav>
	
	<div class="container">
		<div class="col-md-6 mx-auto">
			<h3 class="text-center">Update Account</h3>
			<div class="text-danger">
				<h4>${errMsg}</h4>
			</div>
			<div class="text-success">
				<h4>${succMsg}</h4>
			</div>
			<form:form action="updateAccount" method="POST" modelAttribute="account"
				autocomplete="off">
				<div class="form-group">
					<label for="fname">First Name</label>
					<form:input path="fname" class="form-control"
						placeholder="First Name" />
				</div>
				<div class="form-group">
					<form:hidden path="accountId" class="form-control"/>
				</div>
				<div class="form-group">
					<label for="lname">Last Name</label>
					<form:input path="lname" class="form-control"
						placeholder="Last Name" />
				</div>
				<div class="form-group">
					<label for="email">Email</label>
					<form:input path="email" class="form-control" placeholder="Email" />
					<span id="errEmail" class="text-danger"></span>
				</div>
				<div class="form-group">
					<label for="role">Role</label>
					<form:select path="role" class="form-control">
						<form:option value="">--Select--</form:option>
						<form:option value="admin">Admin</form:option>
						<form:option value="caseworker">caseworker</form:option>
					</form:select>
				</div>
				
				<div class="form-group d-flex justify-content-around">
				<input type="submit"
						value="Update" id="submitBtn" />
				</div>
			</form:form>
		</div>
	</div>
	<script>
		$(document).ready(function() {

			$("#email").blur(function() {
				$("#errEmail").text("");
				$.ajax({
					type : "GET",
					url : "uniqueMailCheck?email=" + $("#email").val(),
					success : function(data) {
						console.log(data)
						if (data == "DUPLICATE") {
							$("#errEmail").text("Duplicate Email");
							$("#submitBtn").prop("disabled", true);
						} else {
							$("#submitBtn").prop("disabled", false);
						}
					}

				});
			})

		})
	</script>

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
</body>
</html>