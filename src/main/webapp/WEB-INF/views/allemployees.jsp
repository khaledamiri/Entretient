<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Employments</title>

<style>
tr:first-child {
	font-weight: bold;
	background-color: #C6C9C4;
}
</style>

</head>


<body>
	<h2>List of Employees</h2>
	<table>
		<tr>
			<td>ID</td>
			<td>NAME</td>
			<td>Matricule</td>
			<td>Statut</td>
			<td>Type employee</td>
			<td></td>
		</tr>
		<c:forEach items="${employees}" var="employee">
			<tr>
				<td>${employee.idEmp}</td>
				<td>${employee.nameEmp}</td>
				<td>${employee.matricule}</td>
				<td>${employee.statut}</td>
				<td>${employee.typeEmp}</td>
				<td><a
					href="<c:url value='/edit-${employee.idEmp}-employee' />">Update</a></td>
				<td><a
					href="<c:url value='/delete-${employee.idEmp}-employee' />">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<a href="<c:url value='/new' />">Add New Employee</a>
</body>
</html>