<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
	<h1> 방명록 작성</h1>
	<p>이름</p>
	<input id = "guestName">
	<p>내용</p>
	<input id = "guestText">
	<button type="button" id = "info_get_btn">등록</button>
	<div id = "guest_div">
	</div>
	
	<script>
		
	$(function(){
		$("#info_get_btn").click(function(){
			const name = $("#guestName").val();
			const text = $("#guestText").val();
			
			$.ajax({
				url: "/insertAjax",
				type: "post",
				data: {name : name ,
					   text : text	},
				dataType : "json",
				success: function(data){
					console.log(data);
					$("#guest_div").append('<p> name :'+ data.guest.getName()+"</p>");
					$("#guest_div").append('<p> message :'+ data.guest.getText()+"</p>");
					$("#guest_div").append('<p> date :'+ data.guest.getTime()+"</p>");
					
				},
				error: function(){
					alert("오류!");
				}
				
			});
			
		});
	});
	
	
	</script>
	
</body>
</html>