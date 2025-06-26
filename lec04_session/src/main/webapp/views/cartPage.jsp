<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
String str = "장바구니가 비어있습니다.";
if(session!=null){
	 int count = 0;
     Enumeration<String> attributeNames = session.getAttributeNames();
     while (attributeNames.hasMoreElements()) {
         attributeNames.nextElement();
         count++;
     }
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>장바구니 목록</p>
	<%
	if(count==0){
		%>
		<p><%= str %></p>
		<%
	}
	for(int i = 0 ; i< count;i++){
		
		str=(String)session.getAttribute(""+i);
		%>
		<p><%= str %></p>
		<%
	}
	
}	
	%>
	
</body>
</html>