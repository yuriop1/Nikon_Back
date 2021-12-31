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
<%
	String mid = (String) application.getAttribute("mid");
	String bid = "";
%>
<div class="container">
	<div class="content">	
		<form action="AddnikonmemberCtrl" class="frm" method="post" id="frm1" name="joinform" onsubmit="return joinCheck(this)">
		<h2 class="fr_tit">회원 가입</h2>
		<p class="fr_com">* 항목은 필수 입력 항목입니다.</p>
		<ul class="fr_list">
			<li>
				<label for="mid" class="lb rep">*아이디</label>
				<span class="lb_data">
					<input type="text" name="mid" id="mid" placeholder="8~12 문자 및 숫자로 입력" maxlength="12" class="in_data" required autofocus />
					<a class="in_btn" id="idckbtn" target="_blank" href="" style="text-align:center; ">ID중복 확인</a>
					<input type="hidden" value="<%=mid %>" name="idck" id="idck" />
						<script>
						$(function(){
							$("#mid").keyup(function(){
								$("#idckbtn").attr("href", "DupCtrl?mid="+$(this).val())
							});
						});
						</script>
				</span>
			</li>
			<li>
				<label for="mpw" class="lb  rep">*비밀번호</label>
				<span class="lb_data">
					<input type="password" name="mpw" id="mpw" class="in_data" required />
				</span>
			</li>
			<li>
				<label for="mname" class="lb rep">*이름</label>
				<span class="lb_data">
					<input type="text" name="mname" id="mname" placeholder="한글 이름 입력" class="in_data" required />
				</span>
			</li>
			<li>
				<label for="mtel" class="lb rep">전화번호</label>
				<span class="lb_data">
					<input type="text" name="mtel" id="mtel" placeholder="-를 포함하여 입력" class="in_data" required />
				</span>
			</li>
			<li>
			    <label for="maddr1" class="lb">주소</label>
				<span class="lb_data">
					<input type="text" name="maddr1" id="maddr1" class="in_data" />
				</span>
			</li>
			<li>
				<label for="maddr2" class="lb">상세주소</label>
				<span class="lb_data">
					<input type="text" name="maddr2" id="maddr2" class="in_data" />
				</span>
			</li>
			<li>
				<span class="fr_col first">
					<input type="submit" value="회원가입"  class="btn btn-default"/>
				</span>
				<span class="fr_col last">
					<input type="reset" value="취소" class="btn btn-default"/>
				</span>
			</li>
		</ul>
		</form>
</div>
</div>
</body>
</html>