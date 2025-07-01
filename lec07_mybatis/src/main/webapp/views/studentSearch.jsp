<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach var="n" items="${name }">
	
	<p>학생 넘버 : ${n.studentNo}</p>
	<p>학생 이름 : ${n.studentName}</p>
	<p>학생 나이 :${n.studentAge}</p>
	</c:forEach>

</body>
</html>