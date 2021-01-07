<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.javaex.vo.PhoneVo"%>



<%
	//pbc에서 보낸 어트리뷰트 받기 기능
	PhoneVo phoneVo = (PhoneVo)request.getAttribute("udVo");
%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		                            <!-- pbc에서 받은 값 -->
		<form action= "/phonebook2/pbc" method="get">
			이름(name): <input type="text" name="name" value="<%=phoneVo.getName()%>"> <br>
			핸드폰(hp): <input type="text" name="hp" value="<%=phoneVo.getHp()%>"> <br>
			회사(company): <input type="text" name="company" value="<%=phoneVo.getCompany()%>"> <br> 
			
			<!-- 아이디 -->
		    <input type="hidden" name="id" value ="<%=phoneVo.getPhoneId()%>"><br>
			
			<!-- action -->
			<input type="hidden" name="action" value="update"> 
			<button type="submit">수정</button>
		</form>
		
		
</body>
</html>