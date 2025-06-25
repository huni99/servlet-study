<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% Cookie[] c = request.getCookies();
String count =null;
if(c!=null){
	for(Cookie co : c){
		if(co.getName().equals("visit_count")){
			count = co.getValue();
			break;
		}
	}
}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p> 당신은 이 페이지를
	<strong> <%= count %></strong>번 방문했습니다.
	</p>
</body>
</html>