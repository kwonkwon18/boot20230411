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

<h1>공급자 등록 탭</h1>

<form action="/sub15/link12" method = "post">

이름 : <input type="text" name = "SupplierName" />
컨택 : <input type="text" name = "ContactName" />
주소 : <input type="text" name = "Address" />
도시 : <input type="text" name = "City" />
PostalCode : <input type="text" name = "PostalCode" />
국가 : <input type="text" name = "Country" />
핸드폰 : <input type="text" name = "Phone" />
<br />
<input type="submit" value = "제출 ~ "/>









</form>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
</body>
</html>