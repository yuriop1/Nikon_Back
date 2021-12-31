<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String mid = (String) session.getAttribute("mid");
	String name = (String) session.getAttribute("mname");
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
<meta name="viewport" content="width=device-width; initial-scale=1.0, userscalable=no"/>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<style>
ul { list-style:none; }
.logo { float:left; }
.tnb { float:right; }
.tnb li { float:left; margin-left:15px; height: 42px;  }
.tnb li a { display:block; height:42px; line-height: 42px; }
#gnb { clear:both; }
.tit { font-size:48px; text-align: center; }
.btn-default { color:#fff; background-image: linear-gradient(to bottom,#111 0,#222 100%); }
.btn-default:hover { background-color:deepskyblue; }
</style>
</head>
<body>
<div class="container">
	<%@ includ file="header.jsp"  %>
	<h2>메인 페이지</h2>
	<div class="content">
		<a href="GetProductListCtrl">제품보러가기</a><br>
		<a href="GetInformListCtrl2">공지사항보러가기</a>
	</div>
</div>	
</body>
</html>