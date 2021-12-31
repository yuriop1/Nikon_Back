<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"  %>    
<%@ page import="java.util.Date"  %>
<%@ page import="com.nikon.biz.*" %>
<%@ page import="com.nikon.model.*"  %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="../header.jsp" %>
<div class="container">
		<h2 class="tit">공지사항추가</h2>
		<form action="../AddnikonnoticeCtrl" method="post" name="frm">
			<table class="table">
				<tr>
					<th class="item1">제목</th>
					<td class="item2">
						<input type="text" name="ntit" id ="ntit" value=""/>
					</td>
				</tr>	
				<tr>
					<th class="item1">내용</th>
					<td class="item2">
					<textarea name="ncon" id="ncon" cols="90" rows="10"></textarea>
					</td>
				</tr>		
				<tr>
					<th class="item1">작성자</th>
					<td class="item2">
						<span>관리자</span>
						<input type="hidden" name="nname" value="관리자" />
					</td>
				</tr>									
		</table>
		<!-- 버튼 그룹  -->
		<div class="btn-group">
			<input type = "submit" class="btn btn-defauit" value="글등록"/>
		</div>			
		</form>
	</div>
</body>
</html>