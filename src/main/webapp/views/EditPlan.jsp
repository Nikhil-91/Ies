<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Plans</title>
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
			<h3 class="text-center">Edit Plan</h3>
			<form:form action="updatePlan" method="POST" modelAttribute="plans"
				autocomplete="off">
				<div class="form-group">
					<form:hidden path="planId" class="form-control"
						placeholder="Plan Name" />
				</div>
				<div class="form-group">
					<label for="fname">Plan Name</label>
					<form:input path="pname" class="form-control"
						placeholder="Plan Name" />
				</div>
				<div class="form-group">
					<label for="pdesc">Plan Descripton</label>
					<form:textarea path="pdesc" class="form-control"
						placeholder="Plan Descripton" />
				</div>
				<div class="form-group">
					<label for="sdate">Plan StartDate</label>
					<form:input path="sdate" class="form-control"
						placeholder="mm-dd-yyy" />
				</div>
				<div class="form-group">
					<label for="edate">Plan EndDate</label>
					<form:input path="edate" class="form-control"
						placeholder="mm-dd-yyy" />
				</div>
				<div class="form-group">
					<form:hidden path="status" class="form-control"
						placeholder="status" />
				</div>
				
				<div class="form-group d-flex justify-content-around">
					<input type="submit" value="Update" id="submitBtn" />
				</div>
			</form:form>
		</div>
	</div>

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
</body>
</html>