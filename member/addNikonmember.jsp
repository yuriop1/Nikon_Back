<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"  %>    
<%@ page import="java.util.Date"  %>
<%@ page import="com.shop.biz.*"  %>
<%@ page import="com.shop.model.*"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width; initial-scale=1.0, userscalable=no"/>
<title>공지사항 글 보기</title>
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
		<h2 class="tit">회원추가</h2>
		<form action="../AddNikonmemberCtrl" method="post" name="frm">
			<table class="table">
				<tr>
					<th class="item1">제목</th>
					<td class="item2">
						<input type="text" name="mid" id="mid" value="" />
					</td>
				</tr>	
				<tr>
					<th class="item1">비밀번호</th>
					<td class="item2">
						<input type="password" name="mpw" id="mpw" value="" />
					</td>
				</tr>
				<tr>
					<th class="item1">이름</th>
					<td class="item2">
						<span>관리자</span>
						<input type="text" name="mname" value="" />
					</td>
				</tr>
				<tr>
					<th class="item1">전화번호</th>
					<td class="item2">
						<input type="text" name="mtel" id="mtle" value="" />
					</td>
				</tr>	
				<tr>
					<th class="item1">주소</th>
					<td class="item2">
						<input type="text" name="maddr1" id="maddr1" value="" />
					</td>
				</tr>	
				<tr>
					<th class="item1">상세주소</th>
					<td class="item2">
						<input type="text" name="maddr2" id="maddr2" value="" />
					</td>
				</tr>				
			</table>
		
			<div class="btn-group">
				<input type="submit" class="btn btn-default" value="회원추가" />
			</div>
		</form>
	</div>
		<%@ include file="../footer.jsp" %>
</body>
</html>