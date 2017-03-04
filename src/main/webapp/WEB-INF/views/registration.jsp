<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Registration Form</title>

<style>
.error {
	color: #ff0000;
}
</style>

</head>

<body>

	<h2>Registration Form</h2>

	<form:form method="POST" modelAttribute="employee">
		<form:input type="hidden" path="idEmp" id="idEmp" />
		<table>
			<tr>
				<td><label for="nameEmp">Name: </label></td>
				<td><form:input path="nameEmp" id="nameEmp" /></td>
				<td><form:errors path="nameEmp" cssClass="error" /></td>
			</tr>

			<tr>
				<td><label for="matricule">Matricule: </label></td>
				<td><form:input path="matricule" id="matricule" /></td>
				<td><form:errors path="matricule" cssClass="error" /></td>
			</tr>

			<tr>
				<td><label for="statut">Statut: </label></td>
				<td><form:checkbox path="statut" id="statut" /></td>
				<td><form:errors path="statut" cssClass="error" /></td>
			</tr>

			<tr>
				<td><label for="typeEmp">Type Employee: </label></td>
				<td><form:select path="typeEmp" id="typeEmp">
						<form:option value="Ingenieur"></form:option>
						<form:option value="Ouvrier"></form:option>
						<form:option value="Technicien"></form:option>
					</form:select></td>

			</tr>



			<tr>
				<td colspan="3"><c:choose>
						<c:when test="${edit}">
							<input type="submit" value="Update" />
						</c:when>
						<c:otherwise>
							<input type="submit" value="Register" />
						</c:otherwise>
					</c:choose></td>
			</tr>
		</table>
	</form:form>
	<br />
	<br /> Go back to
	<a href="<c:url value='/list' />">List of All Employees</a>
</body>
</html>