<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.nikon.model.*" %>    
<%@ page import="com.nikon.biz.*" %>
<%@ page import="com.nikon.view.*" %>
<%
	ArrayList<nikonnoticeVO> nikonnoticeList = (ArrayList<nikonnoticeVO>) request.getAttribute("nikonnoticeList");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
		<h2 class="tit">공지사항 목록</h2>
		<table class="table">
			<tr>
				<th class="item1">번호</th>
				<th class="item2">제목</th>
				<th class="item3">작성자</th>
				<th class="item4">작성일</th>
				<th class="item5">방문횟수</th>
			</tr>
<%
	for(int i=0;i<nikonnoticeList.size();i++) {
		nikonnoticeVO nikonnotice = nikonnoticeList.get(i);
%>
	<tr>	
		<td class="item1"><%=nikonnotice.getSeq() %></td>
		<td class="item2"><a href="GetnikonnoticeCtrl?seq=<%=nikonnotice.getSeq() %>"><%=nikonnotice.getNtit() %></td>
		<td class="item3"><%=nikonnotice.getNname() %></td>
		<td class="item4"><%=nikonnotice.getNregdate() %></td>
		<td class="item5"><%=nikonnotice.getNvisited() %></td>
	</tr>
<%
	}
%>		
		<!-- 버튼 -->
		<div class="btn-group">
			<a href="./notice/addnikonnotice.jsp" class="btn btn-default">글 작성</a>
		</div>
	</div>
</body>
</html>