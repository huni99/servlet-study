<%@page import="java.util.ArrayList"%>
<%@page import="com.gn.dto.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	
	List<Product> list = (ArrayList<Product>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 목록 페이지</title>
</head>
<body>
	<form action="/addToCart" method ="post">
		<select name = "pro">
		<%for(int i = 0 ; i<list.size();i++){ %>
		<%
			
		%>
			<option>
			<%= list.get(i).getName() %>
			</option>
		<%} %>
		</select>
		<button>장바구니에 추가</button>
		
	</form>
	<form action="/cartList">
		<button>장바구니 목록 보기</button>
	</form>

</body>
</html>