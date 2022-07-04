<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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

<title>Students List Directory</title>
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

	<div class="container">

		<h3 class="studentheader">Students Directory List</h3>
		<hr>

		<form action="/Student_Management/student/save" class="form-inline">
			<a href="/Student_Management/student/studentFormForAdd"
				class="btn btn-primary btn-sm mb-3"> Add New Student </a>

		</form>

		<table class="table table-bordered table-striped">
			<thead class="thead-dark">
				<tr>
					<th>FirstName</th>
					<th>LastName</th>
					<th>Department</th>
					<th>Country</th>
					<th>Action</th>

				</tr>
			</thead>

			<tbody>
				<c:forEach items="${Students}" var="studentDetails">
					<tr>
						<td><c:out value="${studentDetails.firstName}" /></td>
						<td><c:out value="${studentDetails.lastName}" /></td>
						<td><c:out value="${studentDetails.department}" /></td>
						<td><c:out value="${studentDetails.country}" /></td>
						<td>
							<!-- Add "update" button/link to perform update student action -->

							<a
							href="/Student_Management/student/studentFormForUpdate?studentId=${studentDetails.id}"
							class="btn btn-info btn-sm"> Update </a> <!-- Add "delete" button/link to perform delete student action -->
							<a
							href="/Student_Management/student/delete?studentId=${studentDetails.id}"
							class="btn btn-danger btn-sm"
							onclick="if (!(confirm('Are you sure you want to delete this Student?'))) return false">
								Delete </a>

						</td>

					</tr>
				</c:forEach>

			</tbody>
		</table>

	</div>

</body>
</html>