<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
</head>
<body>

	<table>
		<thead>
			<tr>
				<th>id</th>
				<th>first name</th>
				<th>last name</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${employee }" var="em">
				<tr>
					<td>${em.id }</td>
					<td>${em.firstName }</td>
					<td>${em.lastName }</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>




	<c:forEach items="${employee }" var="em">
		<ul>
			<li>${em.id }</li>
			<li>${em.firstName }</li>
			<li>${em.lastName }</li>
		</ul>
	</c:forEach>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
		crossorigin="anonymous"></script>
</body>
</html>