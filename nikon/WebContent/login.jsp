<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
        <section class="content" style="background-color: #f1f1f1; padding:30px; margin:40px auto;">
			<h2 class="tit">로그인</h2>
			<form action="LoginCtrl" method="post" class="frm" id="frm1">
				<fieldset>
					<input type="text" class="indata" id="mid" name="mid" 
					placeholder="아이디 입력" autofocus required /><br><br>
					
					<input type="password" class="indata" id="mpw" name="mpw"
					 placeholder="비밀번호 입력" required /><br>
					 
					<br /><br />
					
					<div class="btn-group">
						<input type="submit" class="btn btn-default" value="로그인"/>
						<input type="reset" class="btn btn-default" value="취소"/>
						<a href="./member/addnikonmember.jsp" class="btn btn-default">회원가입</a>
					</div>
				</fieldset>
			</form>
        </section>
    </div>
</body>
</html>