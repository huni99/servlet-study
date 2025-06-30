<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>별 찍기</title>
</head>
<body>
<c:forEach begin="0" end="${star-1}" varStatus="vs">

	<c:forEach begin="0" end="${vs.count-1}">
	⭐
	</c:forEach>
<br>
</c:forEach>

</body>
</html>