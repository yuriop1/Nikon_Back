<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.nikon.model.*" %>    
<%@ page import="com.nikon.biz.*" %>
<%@ page import="com.nikon.view.*" %>
<%
	ArrayList<nikoninVO> nikoninList = (ArrayList<nikoninVO>) request.getAttribute("nikoninList");
%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<%@ include file="../index.jsp" %>
	<h2 class="tit">장바구니목록</h2>
	<form action="" method="post">
		<table class="table">
			<tr>
				<th class="item1">장바구니번호</th>
				<th class="item2">회원아이디</th>
				<th class="item3">제품이름</th>
				<th class="item4">가격</th>
			</tr>
<%
for(int i=0;i<nikoninList.size();i++) {
	nikoninVO nikonin = nikoninList.get(i);
%>
	<tr>
		<td class="item1"><a href="GetnikoninCtrl?icode=<%=nikonin.getIcode() %>"><%=nikonin.getIcode() %></td>
		<td class="item2"><%=nikonin.getIid() %></td>
		<td class="item3"><%=nikonin.getIname() %></td>
		<td class="item4"><%=nikonin.getIprice() %></td>
	</tr>	
		
<%
}
%>
		<div class="btn-group">
			<a href="./in/addnikonin.jsp" class="btn btn-default">장바구니 추가</a>
			<a href="login.jsp" class="btn btn-default">로그인</a>
			
		</div>
	</div>
</div>
</body>
</html>