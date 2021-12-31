<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.nikon.model.*" %>    
<%@ page import="com.nikon.biz.*" %>
<%@ page import="com.nikon.view.*" %>
<%
	ArrayList<nikonproductVO> nikonproductList = (ArrayList<nikonproductVO>) request.getAttribute("nikonproductList");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
<%@ include file="../adminheader.jsp" %>
	<section class="content">
		<h2 class="tit">제품목록</h2>
		<table class="table">
			<thead>
				<tr>
					<th class="item1">제품코드</th>
					<th class="item2">제품명</th>
					<th class="item3">제품설명</th>
					<th class="item4">가격</th>
					<th class="item5">제품사진</th>
				</tr>
			</thead>
			<tbody>
		<%
		for(int i=0;i<nikonproductList.size();i++) {
			nikonproductVO nikonproduct = nikonproductList.get(i);
		%>
				<tr>
					<td class="item1"><a href="GetnikonproductCtrl?pcode=<%=nikonproduct.getPcode() %>"><%=nikonproduct.getPcode() %></td>
					<td class="item2"><%=nikonproduct.getPname() %></td>
					<td class="item3"><%=nikonproduct.getPinfo() %></td>
					<td class="item4"><%=nikonproduct.getPprice() %></td>
					<%
					if(nikonproduct.getPimg() == null){
					%>
						<td class="item5"><img src="http://placehold.it/100x50/333" alt="이미지 없음" /></td>
					<%
					} else {
					%>
						<td class="item5"><%=nikonproduct.getPimg() %></td>
					<%
					}
					%>
				</tr>	
				<%
				}
				%>
			</tbody>
		</table>
		<!-- 버튼 -->
		<div class="btn-group">
			<a href="./product/addnikonproduct.jsp" class="btn btn-default">제품추가</a>
		</div>
	</section>
</div>
</body>
</html>