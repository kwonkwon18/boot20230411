<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>

 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>
<body>


<h1>link9</h1>

<form action="/sub19/link10" method = "post">
제목 : <input type="text" name = "title" /><br />
개봉일 : <input type="date" name = "published"/><br />
가격 : <input type="text" name = "price"/><br />
업데이트 : <input type="datetime-local" name = "updated" /><br />
무게 : <input type="text" name = "weight"/><br />
<br />
<input type="submit" value = "제출" />

<a href="/sub19/link15">명단 항목으로 가기</a>

</form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
</body>
</html>