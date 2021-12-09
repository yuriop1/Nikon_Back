<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.shop.model.*" %>    
<%@ page import="com.shop.biz.*" %>
<%@ page import="com.shop.view.*" %>
<%
	ArrayList<NikonmemberVO> nikonmemberList = (ArrayList<NikonmemberVO>) request.getAttribute("nikonmemberList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width; initial-scale=1.0, userscalable=no"/>
<title>공지사항 목록</title>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<style>
.tit { font-size:48px; text-align: center; }
.btn-default { color:#fff; background-image: linear-gradient(to bottom,#111 0,#222 100%); }
.btn-default:hover { background-color:deepskyblue; }
</style>
</head>
<body>
	<%@ include file="../header.jsp" %>
	<div class="container">
		<h2 class="tit">회원 목록</h2>
		<form action="" method="post">
		<table class="table">
			<tr>
				<th class="item1">회원아이디</th>
				<th class="item2">이름</th>
				<th class="item3">전화번호</th>
				<th class="item4">주소</th>
				<th class="item5">상세주소</th>
			</tr>
<%
	for(int i=0;i<nikonmemberList.size();i++) {
		NikonmemberVO nikonmember = nikonmemberList.get(i);
%>		
	<tr>
		<td class="item1"><%=nikonmember.getMid() %></td>
		<td class="item2"><%=nikonmember.getMname() %></td>
		<td class="item3"><%=nikonmember.getMtel() %></td>
		<td class="item4"><%=nikonmember.getMaddr1() %></td>
		<td class="item5"><%=nikonmember.getMaddr2() %></td>
<%
	}
%>	
	</table>	
	<nav>
		<ul class="pagination">
			<li><a href="" arial-label="Previous"><span arial-hidden="true">&laquo;</span></a></li>
			<li><a href="GetNikonmemberListCtrl">1</a></li>
			<li><a href="" arial-label="Next"><span arial-hidden="true">&raquo;</span></a></li>
		</ul>
	</nav>
	
	<div class="btn-group">
		<a href="./member/addNikonmember.jsp" class="btn btn-default">글 작성</a>
	</div>
	</div>
		<%@ include file="../footer.jsp" %>
</body>
</html>