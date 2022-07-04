<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">
<title>Student Directory</title>
<style type="text/css">
.studentheader {
	text-align: center;
	veritcal-align: center;
	background: #1abc9c;
	color: white;
	font-size: 30px;
}
</style>
</head>
<body>
	<div class="container"></div>
	<h3 class="studentheader">Students directory</h3>
	<a href="/Student_Management/students/add"
		class="btn btn-primary btn-sm mb-3">List Student Details</a>
	<table class="table table-bodered table-striped">
		<thead class="thead-dark">
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Department</th>
				<th>Country</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${studentModel}" var="student">
				<tr>
					<td><c:out value="${student.firstName}"></c:out></td>
					<td><c:out value="${student.lastName}"></c:out></td>
					<td><c:out value="${student.department}"></c:out></td>
					<td><c:out value="${student.country}"></c:out></td>
					<td>
						<!-- <a href="Student_Management/students/update?id=${student.student_Id}"
						class="btn btn-info btn-sm">Update</a>
						<a href="Student_Management/students/delete?id=${student.student_Id}"
						class="btn btn-danger btn-sm"
						onclick="if(!(confirm('Are you sure  to delete  this book?'))) return false">Delete</a> -->
						
						<a href="update?id=${student.id}" class="btn btn-info btn-sm">Update</a>
						<a href="delete?id=${student.id}"
						class="btn btn-danger btn-sm"
						onclick="if(!(confirm('Are you sure  to delete  this book?'))) return false">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>



</body>
</html>