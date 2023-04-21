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


	<h1>link15</h1>

	<table>
		<thead>
			<tr>
				<th>이름</th>
				<th>나이</th>
				<th>가격</th>
				<th>생일</th>
				<th>갱신일</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list }" var="a">
				<tr>
					<td>${a.title }</td>
					<td>${a.published }</td>
					<td>${a.price }</td>
					<td>${a.updated }</td>
					<td>${a.weight }</td>
			</c:forEach>
			</tr>
		</tbody>
		
		<a href="/sub19/link9">추가 항목으로 가기</a>


	</table>
	</form>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
		crossorigin="anonymous"></script>
</body>
</html>