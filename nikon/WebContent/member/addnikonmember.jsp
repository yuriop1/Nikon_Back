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
<title>회원추가</title>
</head>
<body>
<%@ include file="../index.jsp" %>
<div class="container">
		<h2 class="tit">회원가입</h2>
		<form action="../AddnikonmemberCtrl" method="post" name="frm">
			<table class="table">
				<tr>	
					<th class="item1">아이디</th>
					<td class="item2">
						<input type="text" name="mid" id="mid" placeholder="8~12 문자 및 숫자로 입력" maxlength="12" value="" required autofocus />
						<a class="in_btn" id="idckbtn" target="_blank" href="idcheck.jsp" style="text-align:center; ">ID중복 확인</a>
						<input type="hidden" value="<%=mid %>" name="idck" id="idck" />
						<script>
						$(function(){
							$("#mid").keyup(function(){
								$("#idckbtn").attr("href", "DupCtrl?mid="+$(this).val())
							});
						});
						</script>
					</td>
				</tr>	
				<tr>	
					<th class="item1">비밀번호</th>
					<td class="item2">
						<input type="password" id="mpw" name="mpw" value="" />
					</td>
				</tr>
				<tr>	
					<th class="item1">이름</th>
					<td class="item2">
						<input type="text" id="mname" name="mname" value="" />
					</td>
				</tr>	
				<tr>	
					<th class="item1">전화번호</th>
					<td class="item2">
						<input type="text" id="mtel" name="mtel" value="" />
					</td>
				</tr>	
				<tr>	
					<th class="item1">주소</th>
					<td class="item2">
						<input type="text" id="maddr1" name="mnaddr1" value="" />
					</td>
				</tr>	
				<tr>	
					<th class="item1">상세주소</th>
					<td class="item2">
						<input type="text" id="maddr2" name="maddr2" value="" />
					</td>
				</tr>						
			</table>
			<!--  버튼 그룹 -->
			<div class="btn-group">
				<input type="submit" class="btn btn-default" value="가입" />
				<input type="reset" class="btn btn-default" value="취소" />
			</div>
		</form>
	</div>
</body>
</html>