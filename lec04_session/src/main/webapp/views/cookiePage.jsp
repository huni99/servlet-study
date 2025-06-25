<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% 
Cookie[] cookies = request.getCookies();
String nick = "____";

%>
<html>
<head>
<meta charset="UTF-8">
<title>닉네임 입력</title>
</head>
<body>
	<form action="/saveNick" method="post">
		
		<label id="ni">닉네임 입력</label>
		<input id="ni" type="text" name= "nick">
		<button> 저장</button>
	
	</form>
	<p>닉네임 삭제</p>
	<form action="/removeNick" method="post">
		<button> 클릭</button>
	</form>
	<%
		if(cookies!=null){
			for(Cookie c : cookies){
				if(c.getName().equals("nick")){
					nick= c.getValue();
					break;
				}
			}
		}
	%>
	<p>닉네임 : <%=nick %> </p>
</body>
</html>