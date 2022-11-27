<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add New Student</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>

	<%@include file="header.jsp"%>

	<div class="container">
		<div class="row">
			<div class="col-lg-4"></div>
			<div class="col-lg-4">
				<div class="card mt-5">
					<div class="card-header">
						<b>Add New Student</b>
					</div>
					<div class="card-body">
						<form action="saveUser" method="post">
							<div class="mb-3">
								<label for="exampleInputEmail1" class="form-label">Full
									Name </label> <input type="text" name="name" class="form-control"
									placeholder="Enter Full Name">
							</div>
							<div class="mb-3">
								<label for="exampleInputEmail1" class="form-label">Email
									address</label> <input type="email" name="email" class="form-control"
									placeholder="Enter Email">
							</div>
							<div class="mb-3">
								<label for="exampleInputPassword1" class="form-label">Password</label>
								<input type="password" name="password" class="form-control"
									placeholder="Enter Password">
							</div>
							<div class="mb-3">
								<label for="exampleInputPassword1" class="form-label">Gender</label>
								<select id="disabledSelect" name="gender" class="form-select">
									<option hidden="" value="">Select Gender</option>
									<option value="Male">Male</option>
									<option value="Female">Female</option>
								</select>
							</div>
							<div class="form-group text-center">
								<button type="submit" class="btn btn-primary">Save</button>
							</div>
						</form>
					</div>
				</div>
			</div>
			<div class="col-lg-4"></div>
		</div>
	</div>


	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
		integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
		integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
		crossorigin="anonymous"></script>
</body>
</html>