<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>도서 대출 내역</h1>
<h4>[고객 정보]</h4>
<ul>
	<li>고객명: &nbsp;<%=request.getAttribute("user_name") %></li>
	<li>전화번호: &nbsp;<%=request.getAttribute("user_phone")%></li>
	<li>이메일:&nbsp; <%=request.getAttribute("user_email")%></li>
</ul>

<h4>[대출 정보]</h4>
<ul>
	<li>도서 제목: &nbsp;
	<% /* String book = request.getAttribute("book_name").toString(); */
		String book = (String)request.getAttribute("book_name");
		String period = request.getAttribute("borrow_period").toString();
		String bo=null;
		int num = Integer.parseInt(period);
		String price=null;
	 	switch (book){
	 	case "1" :
	 		bo = "자바 프로그래밍 입문";
	 		price = ""+(1500+(num-1)*500);
	 		break;
	 	case "2" :
	 		bo = "웹 개발의 기초";
	 		price = ""+(1800+(num-1)*500);
	 		break;
	 	case "3" :
	 		bo= "데이터베이스 시스템";
	 		price = ""+(2000+(num-1)*500);
	 		break;
	 	}
	%>
	<%= bo %>
	</li>
	<li>대출 기간: &nbsp;<%=period%></li>
</ul>
<h3>대출 금액:&nbsp; <%=price %></h3>
</body>
</html>