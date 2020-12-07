<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Plans</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" />
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
		<div class="col-md-4 mx-auto">
			<h3 class="text-center">View Plans</h3>
		</div>
		<div class="col-md-8 mx-auto">
			<table class="table">
				<thead>
					<tr>
						<th>Application No</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Date Of Birth</th>
						<th>SSN</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${apps}" var="app">
						<tr>
							<td>${app.appId}</td>
							<td>${app.fname}</td>
							<td>${app.lname}</td>
							<td>${app.dob}</td>
							<td>${app.ssn}</td>
							<td><a href="editApp?appId=${app.appId}"><i class="fa fa-edit"> </i></a>
								<a href="deleteApp?appId=${app.appId}"
								onclick="return deletePlan()"> 
								  <c:set var = "status" value = "${app.status}"/>
								<c:if test ="${status == \"D\"}">
								<i class="fa fa-key"> </i>
								</c:if>
								<c:if test ="${status == \"A\"}"><i class="fa fa-trash"> </i></c:if>
								
							</a></td>
						</tr>
					</c:forEach>


				</tbody>
			</table>
		</div>
	</div>
	<Script>
		function deletePlan() {
			confirm("Are you sure to make change?");
		}
	</Script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
</body>
</html>