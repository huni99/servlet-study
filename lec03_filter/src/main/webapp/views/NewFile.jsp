<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String title = (String)request.getAttribute("title"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>title 확인</title>
</head>
<body>
	<h1>메시지</h1>
	<p><%=title%></p>
	
</body>
</html>