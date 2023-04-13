<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Reports</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" rel="stylesheet">
</head>



<body class="text-bg-light">

	<div class="container text-center">
		<h1 class="pb-3 pt-3">Reports Application</h1>
		<form:form action="/search" modelAttribute="search" method="get">
			<div class="container text-center">
				<table>
					<tr>
						<td>Plan Name:</td>
						<td><form:select path="planName">
								<form:option value="">-Select-</form:option>
								<form:options items="${names }" />
							</form:select></td>
						<td>Plan Status:</td>
						<td><form:select path="status">
								<form:option value="">-Select-</form:option>
								<form:options items="${status }" />
							</form:select></td>
						<td>Gender:</td>
						<td><form:select path="gender">
								<form:option value="">-Select-</form:option>
								<form:option value="male">Male</form:option>
								<form:option value="female">FeMale</form:option>
							</form:select></td>
					</tr>

					<tr>
						<td>Start date:</td>
						<td><form:input path="startDate" type="date" /></td>
						<td>End date:</td>
						<td><form:input path="endDate" type="date" /></td>
					</tr>
					<tr>
						<td><a href="/" class="btn btn-danger">Reset <i class="fa-solid fa-arrow-rotate-left fa-sm"></i></a> 
						<button type="submit" value="Search" class="btn btn-success">Search <i class="fa-solid fa-magnifying-glass fa-sm"></i></button>
					</tr>
				</table>
			</div>
		</form:form>
		<hr />
		<table class="table table-striped">
			<thead>
				<tr>
					<th>S.No</th>
					<th>Customer Name</th>
					<th>Gender</th>
					<th>Plan Name</th>
					<th>Plane Status</th>
					<th>Start Date</th>
					<th>End date</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach items="${plans }" var="cust" varStatus="index">
					<tr>
						<td>${index.count }</td>
						<td>${cust.name }</td>
						<td>${cust.gender }</td>
						<td>${cust.planName }</td>
						<td>${cust.status }</td>
						<td>${cust.startDate }</td>
						<td>${cust.endDate }</td>
					</tr>
				</c:forEach>
				<tr>
					<c:if test="${empty plans }">
						<td colspan="7" style="text-align: center">Records Not Found!!!
							</td>
					</c:if>
				</tr>
			</tbody>

		</table>
		
		<hr />
		<a href="/excel" class="btn btn-success">Excel <i class="fa-solid fa-table fa-beat fa-sm" style="color: #c3c7c2;"></i></a> 
		<a href="/pdf"class="btn btn-secondary">PDF <i class="fa-solid fa-file-pdf fa-beat fa-sm" style="color: #1d1b1b;"></i></a> 
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
		crossorigin="anonymous"></script>
</body>
</html>