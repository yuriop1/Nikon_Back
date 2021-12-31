<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.nikon.model.*" %>    
<%@ page import="com.nikon.biz.*" %>
<%@ page import="com.nikon.view.*" %>
<%
	ArrayList<nikonmemberVO> nikonmemberList = (ArrayList<nikonmemberVO>) request.getAttribute("nikonmemberList");
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
	<h2 class="tit">회원목록</h2>
	<form action="" method="post">
		<table class="table">
			<tr>
				<th class="item1">아이디</th>
				<th class="item2">비밀번호</th>
				<th class="item3">이름</th>
				<th class="item4">전화번호</th>
				<th class="item5">주소</th>
				<th class="item6">상세주소</th>
			</tr>
<%
for(int i=0;i<nikonmemberList.size();i++) {
	nikonmemberVO nikonmember = nikonmemberList.get(i);
%>
	<tr>
		<td class="item1"><a href="GetnikonmemberCtrl?mid=<%=nikonmember.getMid() %>"><%=nikonmember.getMid() %></td>
		<td class="item2"><%=nikonmember.getMpw() %></td>
		<td class="item3"><%=nikonmember.getMname() %></td>
		<td class="item4"><%=nikonmember.getMtel() %></td>
		<td class="item5"><%=nikonmember.getMaddr1() %></td>
		<td class="item6"><%=nikonmember.getMaddr2() %></td>
	</tr>	
		
<%
}
%>
		<div class="btn-group">
			<a href="./member/addnikonmember.jsp" class="btn btn-default">회원가입</a>
			<a href="login.jsp" class="btn btn-default">로그인</a>
			
		</div>
	</div>
</div>
</body>
</html>