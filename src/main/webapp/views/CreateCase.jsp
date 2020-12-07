<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Case</title>
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
						<a href="/appl" class="dropdown-item">Create Application</a> <a
							href="/ViewApplication" class="dropdown-item">View
							Application</a>
					</div></li>

				<li class="nav-item"><a href="/createCase" class="nav-link">Data
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
		<div class="text-danger text-center">
			<h4 class="msg"></h4>
		</div>
		<div class="col-md-4 mx-auto d-flex py-3">
			<input type="text" class="form-control mr-2 text-input" placeholder="Enter Application No" />
			<input type="submit" value="submit" class="btn btn-primary"/>
		</div>
			<div class="col-md-6 mx-auto" id="output"></div>
	</div>
	<script>
	class Http_lib{
		async get(val){
				const resp=await fetch('/getApplDetails/'+val);
				if(resp.ok){
				const data=resp.json();
				 return data;
				}else{
					return null;
				}
		}
	}
	const http=new Http_lib();
	document.addEventListener('click',(e) =>{
		if(e.target.id=='caseCreation'){
		http.get(document.querySelector('.text-input').value).then(res => { if(res!=null){
			var myHeaders = new Headers();
			myHeaders.append("Content-Type", "application/json");

			var raw = JSON.stringify({"appId":res.appId,"fname":res.fname,"lname":res.lname,"dob":res.dob,"gender":res.gender,"ssn":res.ssn,"phoneNo":res.phoneNo,"email":res.email});

			var requestOptions = {
			  method: 'POST',
			  headers: myHeaders,
			  body: raw,
			  redirect: 'follow'
			};

			fetch("/createCaseDtls", requestOptions)
			  .then(response => response.text())
			  .then(result => {
				  if(result == 'valid'){
					  window.location = "http://localhost:9090/loadPlanSelection";
				  }else if(result == 'duplicate'){
					  document.querySelector('.msg').innerHTML='Case Already Created for User';
				  }
			  })
			  .catch(error => console.log('error', error));
		}
		})
		}
	})
	
	document.querySelector(".btn").addEventListener('click',(e) => {				
			
			http.get(document.querySelector('.text-input').value).then(
			resp => {
				if(resp!=null){
					
			  let output=` 
							<div class="card">
							    <div class="card-body">
								     <h3>Create Case</h3>
								     ApplicationId: ${resp.appId}<br>
								     Name: ${resp.fname}<br>
								     DOB: ${resp.dob}<br>
								     Gender:${resp.gender}<br>
								     SSN:${resp.ssn}<br>
								     Phone No: ${resp.PhoneNo}<br>
								     Email: ${resp.email}<br>
								     <input type="button" class="btn btn-success py-2" value="Create Case" id="caseCreation"/>
							    </div>
							 </div>
							 
					`
					document.querySelector('#output').innerHTML=output;
			        document.querySelector('.msg').innerHTML='';
					
				} else{
					document.querySelector('#output').innerHTML=`
						  <div class="alert alert-danger">
					    Invalid Application Number!! 
					  </div>`
						document.querySelector('.msg').innerHTML='';
					
				}
			}		
			);
			
			
			
	
		})
	</script>

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
</body>
</html>