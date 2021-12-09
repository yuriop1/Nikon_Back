<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*"  %>    
<%@ page import="java.util.Date"  %>
<%@ page import="com.shop.biz.*"  %>
<%@ page import="com.shop.model.*"  %>
<%
	NikonmemberVO nikonmember = (NikonmemberVO) request.getAttribute("nikonmember");
%>
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
		<h2 class="tit">회원목록 보기</h2>
		<form action="UpdateNikonmemberCtrl" method="post" name="frm">
		<table class="table">
			<tr>
				<th class="item1">아이디</th>
				<td class="item2"><%=nikonmember.getMid() %>
					<input type="hidden" name="mid" value="<%=nikonmember.getMid() %>"/>
				</td>
			</tr>
			<tr>
				<th class="item1">비밀번호</th>
				<td class="item2"><%=nikonmember.getMpw() %>
					<input type="hidden" name="mid" value="<%=nikonmember.getMpw() %>"/>
				</td>
			</tr>
			<tr>
				<th class="item1">이름</th>
				<td class="item2"><%=nikonmember.getMname() %></td>
			</tr>
			<tr>
				<th class="item1">전화번호</th>
				<td class="item2"><%=nikonmember.getMtel() %></td>
			</tr>
			<tr>
				<th class="item1">주소</th>
				<td class="item2"><%=nikonmember.getMaddr1() %></td>
			</tr>
			<tr>
				<th class="item1">상세주소</th>
				<td class="item2"><%=nikonmember.getMaddr2() %></td>
			</tr>		
		</table>
		
		<div class="btn-group">
			<input type="submit" class="btn btn-default" value="글 수정" />
			<a href="GetNikonmemberListCtrl" class="btn btn-default">목록</a>
			<button class="btn btn-default"  onclick="func1(<%=nikonmember.getMid() %>">회원 삭제</button>
		</div>
		</form>
		<script>
		function func1(data) {
			if(confirm("정말로 삭제하시겠습니까?")){
				location.href="DeleteNikonmemberStrl?mid="+data;
			} else {
				return false();
			}
		}
		</script>
	</div>
		<%@ include file="../footer.jsp" %>
</body>
</html>