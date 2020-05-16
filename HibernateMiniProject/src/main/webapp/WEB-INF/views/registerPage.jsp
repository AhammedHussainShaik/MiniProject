<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Page</title>
</head>
<body>
	<%@include file="menu.jsp"%>
	<div class="container">
		<div class="card">
			<div class="card-header bg-info text-white">
				<h3>Welcome Employee Register Page</h3>
			</div>
			<div class="card-body">
				<form:form action="saveEmp" method="POST" modelAttribute="employee">
					<div class="row" style="padding: 10px;">
						<div class="col-4">Employee Name :</div>
						<div class="col-4">
							<form:input path="empName" class="form-control" />
						</div>
					</div>
					<div class="row" style="padding: 10px;">
						<div class="col-4">Salary :</div>
						<div class="col-4">
							<form:input path="empSal" class="form-control" />
						</div>
					</div>
					<div class="row" style="padding: 10px;">
						<div class="col-4">Department</div>
						<div class="col-4">
							<form:select path="dept" class="form-control">
								<form:option value="Developer">Developer</form:option>
								<form:option value="QualityAssurance">QA</form:option>
								<form:option value="Tester">Testing</form:option>
							</form:select>
						</div>
					</div>
					<div class="row" style="padding: 10px;">
						<div class="col-4">
							<input type="submit" value="Register" class="btn btn-success">
						</div>

					</div>
				</form:form>
			</div>
			<div class="card-footer bg-primary text-white">
			  ${message}
			</div>

		</div>

	</div>


</body>
</html>