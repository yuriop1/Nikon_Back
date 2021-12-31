<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"  %>    
<%@ page import="java.util.Date"  %>
<%@ page import="com.nikon.biz.*" %>
<%@ page import="com.nikon.model.*" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품추가</title>
</head>
<body>
<div class="container">
<%@ include file="../adminheader.jsp" %>
		<h2 class="tit">제품추가</h2>
		<form action="../AddnikonproductCtrl" method="post" name="frm">
			<table class="table">
			<tr>	
				<th class="item1">제품코드</th>
				<td class="item2">
					<input type="text" name="pcode" id="pcode" value="" />
				</td>
			</tr>
			<tr>	
				<th class="item1">제품명</th>
				<td class="item2">
					<input type="text" name="pname" id="pname" value="" />
				</td>
			</tr>	
			<tr>	
				<th class="item1">제품설명</th>
				<td class="item2">
					<input type="text" name="pinfo" id="pinfo" value="" />
				</td>
			</tr>	
			<tr>	
				<th class="item1">가격</th>
				<td class="item2">
					<input type="text" name="pprice" id="pprice" value="" />
				</td>
			</tr>		
			<tr>	
				<th class="item1">제품사진</th>
				<td class="item2">
					<input type="text" name="pimg" id="pimg" value="" />
				</td>
			</tr>	
			</table>
			<div class="btn-group">
				<input type="submit" class="btn btn-default" value="등록" />
				<input type="reset" class="btn btn-default" value="취소" />
			</div>
		</form>
</body>
</html>