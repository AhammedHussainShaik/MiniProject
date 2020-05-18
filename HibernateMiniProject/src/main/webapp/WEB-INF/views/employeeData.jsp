<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee List</title>
</head>
<body>
	<%@include file="menu.jsp"%>

	<div class="container">
		<div class="card">
			<div class="card-header bg-info text-white">
				<h2 align="center">Welcome Employee List Page</h2>
			</div>
			<div class="card-body">
				<table class="table">
					<tr>
						<th>Employee Id</th>
						<th>Employee Name</th>
						<th>Department</th>
						<th>Salary</th>
						<th colspan="2">OPERATION</th>
					</tr>
					<c:forEach items="${employees}" var="employee">
						<tr>
							<td>${employee.empId}</td>
							<td>${employee.empName}</td>
							<td>${employee.dept}</td>
							<td>${employee.empSal}</td>
							<td><a href="removeEmp?id=${employee.empId}"
								class="btn btn-danger">Delete</a></td>
							<td><a href="editEmp?id=${employee.empId}"
								class="btn btn-success">Edit</a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div class="card-footer bg-info text-white">${result}</div>
		</div>

	</div>

</body>
</html>