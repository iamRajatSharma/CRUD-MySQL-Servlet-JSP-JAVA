<%@page import="dao.StudentDao"%>
<%@page import="entity.Student"%>
<%@page import="connection.DBConnection"%>
<%@page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<style>
.table-bordered>:not(caption)>*>* {
	vertical-align: middle;
}
</style>
<body>
	<%@include file="header.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-lg-12 mt-3">

				<% if (session.getAttribute("success") != null) { %>
				<div class="alert alert-success mb-3">
					<strong><%= session.getAttribute("success") %></strong>
				</div>
				<% } if(session.getAttribute("error") != null){ %>
				<div class="alert alert-danger mb-3">
					<strong><%= session.getAttribute("error") %></strong>
				</div>
				<% } %>
				
				<%
				session.removeAttribute("success");
				session.removeAttribute("error");
				%>

				<div class="card">
					<div class="card-header">
						<b>Student List</b>
					</div>

					<div class="card-body" style="padding: 0px;">
						<table class="table table-bordered table-striped"
							style="margin-bottom: 0px;">
							<thead class="text-center">
								<tr>
									<th scope="col">S.NO</th>
									<th scope="col">Full Name</th>
									<th scope="col">Email</th>
									<th scope="col">Gender</th>
									<th scope="col">Action</th>
								</tr>
							</thead>
							<tbody class="text-center">
							<%
								int count = 1;
								StudentDao dao = new StudentDao();
								List<Student> stu = dao.getAllData();
								if(stu.size()>0){
								for(Student i: stu){
							%>
								<tr>
									<th scope="row"><%= count++ %></th>
									<td><%= i.getName() %></td>
									<td><%= i.getEmail() %></td>
									<td><%= i.getGender() %></td>
									<td>
										<a href="edit.jsp?id=<%= i.getId() %>" class="btn btn-warning mr-3">Edit</a>
										<a href="delete?id=<%= i.getId() %>" class="btn btn-danger">Delete</a>
									</td>
								</tr>
								<% } } else{ %>
									<tr class="text-center">
									<td colspan="5">NO RECORD FOUND</td>
									</tr>
								<%}  %>
							</tbody>
						</table>
					</div>
				</div>
			</div>
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