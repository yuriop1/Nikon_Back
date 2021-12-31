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
<title>장바구니 추기</title>
</head>
<body>
<%@ include file="../index.jsp" %>
<div class="container">
		<h2 class="tit">장바구니 추가</h2>
		<form action="../AddnikoninCtrl" method="post" name="frm">
			<table class="table">
				<tr>	
					<th class="item1">장바구니번호</th>
					<td class="item2">
						<input type="text" id="icode" name="icode" value="" />
					</td>
				</tr>
				<tr>	
					<th class="item1">회원아이디</th>
					<td class="item2">
						<input type="text" id="iid" name="iid" value="" />
					</td>
				</tr>	
				<tr>	
					<th class="item1">제품이름</th>
					<td class="item2">
						<input type="text" id="iname" name="iname" value="" />
					</td>
				</tr>	
				<tr>	
					<th class="item1">가격</th>
					<td class="item2">
						<input type="text" id="iprice" name="iprice" value="" />
					</td>
				</tr>			
			</table>
			<!--  버튼 그룹 -->
			<div class="btn-group">
				<input type="submit" class="btn btn-default" value="추가" />
				<input type="reset" class="btn btn-default" value="취소" />
			</div>
		</form>
	</div>
</body>