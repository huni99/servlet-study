<%@page import="com.gn.dto.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	
	List<Product> list = (List)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 목록 페이지</title>
</head>
<body>
	<form action="/addToCart" method ="post">
		<select >
		<%for(int i = 0 ; i<list.size();i++){ %>
			<option><%= list.get(i).getName() %></option>
		<%} %>
		</select>
		<button>장바구니에 추가</button>
	</form>

</body>
</html>