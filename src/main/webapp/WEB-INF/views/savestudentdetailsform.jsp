<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

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

<title>Save Student Details Form</title>
<style type="text/css">
.studentForm{

}
</style>
</head>
<body>
	<div class="container">
		<h3>Add Student Details to Directory</h3>
		<!-- <form action="Student_Management/students/save" method="post"> -->
		<form action="save" method="post">
			<input type="hidden" name="id" value="${student.student_Id}">
			<div class="form-inline">
				<label class="studentForm">Student First Name</label><br>
			</div>
			<div class="form-inline">
				<input type="text" name="firstName" value="${student.firstName}"
					placeholder="Enter student First Name"
					class="form-control mb-4 col-4">
			</div>
			<div class="form-inline">
				<label class="studentForm">Student Last Name</label><br>
			</div>
			<div class="form-inline">
				<input type="text" name="lastName" value="${student.lastName}"
					placeholder="Enter student Last Name"
					class="form-control mb-4 col-4">
			</div>
			<div class="form-inline">
				<label class="studentForm">Student Department</label><br>
			</div>
			<div class="form-inline">
				<input type="text" name="department" value="${student.department}"
					placeholder="Enter student Department"
					class="form-control mb-4 col-4">
			</div>
			<div class="form-inline">
				<label class="studentForm">Student Country</label><br>
			</div>
			<div class="form-inline">
				<input type="text" name="country" value="${student.country}"
					placeholder="Enter student Country" class="form-control mb-4 col-4">
			</div>
			<button type="submit" class="btn btn-info col-2">Submit</button>
		</form>
		<!--  <a href="Student_Management/students/list">Back to Students Lists</a>-->
		<a href="list">Back to Students Lists</a>
	</div>


</body>
</html>