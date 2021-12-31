<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.Date" %>
<%@ page import="com.nikon.biz.*" %>
<%@ page import="com.nikon.model.*" %>
<%@ page import="com.nikon.view.*" %>
<%
	nikonnoticeVO nikonnotice = (nikonnoticeVO) request.getAttribute("nikonnotice");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%@ include file="../header.jsp" %>
	<div class="container">
		<h2 class="tit">공지사항 목록</h2>
			<form action="UpdatenikonnoticeCtrl">
				<table class="table">
					<tr>
						<th class="item1">번호</th>
						<td class="item2"><%=nikonnotice.getSeq() %></td>
							<input type="hidden" name="seq" value="<%=nikonnotice.getSeq() %>"/>
					</tr>
					<tr>
						<th class="item1">제목</th>
						<td class="item2">
							<input type="text" name="ntit" value="<%=nikonnotice.getNtit() %>"/></td>
					</tr>	
					<tr>
						<th class="item1">내용</th>
						<td class="item2">
							<textarea name="ncon" id="" rows="10" cols="90"><%=nikonnotice.getNcon() %></textarea></td>
					</tr>	
					<tr>
						<th class="item1">작성자</th>
						<td class="item2"><%=nikonnotice.getNname() %></td>
					</tr>				
					<tr>
						<th class="item1">작성일</th>
						<td class="item2"><%=nikonnotice.getNvisited() %></td>
					</tr>														
					<tr>	
						<th class="item1">방문횟수</th>
						<td class="item2"><%=nikonnotice.getNvisited() %></td>
					</tr>
			</table>
			
			<!-- 버튼 그룹  -->
			<div class="btn-group">
				<input type = "submit" class="btn btn-defauit" value="글수정"/>
				<a href="GetnikonnoticeListCtrl" class="btn btn-default">목록</a>
				<button class="btn btn-default"  onclick="func1(<%=nikonnotice.getSeq() %>)">글 삭제</button>
			</div>		
		</form>	
		<script>
			function func1(data) {
				if(confirm("정말로 삭제하시겠습니까?")) {
					location.href="DeletenikonnoticeCtrl?seq="+data;
				} else {
					return false();
				}		
			}
		</script>
	</div>	
</body>
</html>