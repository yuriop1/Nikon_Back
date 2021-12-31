<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.nikon.model.*"  %>
<%
	nikonmemberVO nikonmember = (nikonmemberVO) request.getAttribute("nikonmember");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-latest.js"></script>
</head>
<body>
<div class="container">
	<%@ include file="header.jsp" %>
	<div class="content">	
		<form action="UpdateCtrl" class="frm" method="post" id="frm1" name="joinform" onsubmit="return joinCheck(this)">
		<h2 class="fr_tit">마이페이지</h2>
		<p class="fr_com">* 항목은 필수 입력 항목입니다.</p>
		<ul class="fr_list">
			<li>
				<label for="mid" class="lb rep">아이디</label>
				<span class="lb_data">
					<input type="text" name="mid" id="mid" value="<%=nikonmember.getMid() %>" class="in_data" readonly />
				</span>
			</li>
			<li>
				<label for="mpw" class="lb  rep">비밀번호</label>
				<span class="lb_data">
					<input type="password" name="mpw" id="mpw" value="<%=nikonmember.getMpw() %>" class="in_data" required />
				</span>
			</li>		
			<li>
				<label for="mname" class="lb rep">이름</label>
				<span class="lb_data">
					<input type="text" name="mname" id="mname" value="<%=nikonmember.getMname() %>" class="in_data" required />
				</span>
			</li>
			<li>
				<label for="memail" class="lb rep">이메일</label>
				<span class="lb_data">
					<input type="text" name="memail" id="memail" value="<%=nikonmember.getMemail() %>" class="in_data" required />
				</span>
			</li>
			<li>
				<label for="mtel" class="lb rep">전화번호</label>
				<span class="lb_data">
					<input type="text" name="mtel" id="mtel" value="<%=nikonmember.getMtel() %>" class="in_data" required />
				</span>
			</li>
			<li><label for="zipcode" class="lb">우편번호</label>
				  <span class="lb_data">
				  		<input type="text" name="mzipcode" id="mzipcode" value="<%=nikonmember.getMzipcode() %>" class="in_data" />
				  		<input type="button" value="주소찾기" onclick="findAddr()" class="in_btn"/>	
				  </span>
			</li>
			<li>
			    <label for="address1" class="lb">주소</label>
				<span class="lb_data">
					<input type="text" name="maddr1" id="maddr1" value="<%=nikonmember.getMaddr1() %>" class="in_data" />
				</span>
			</li>
			<li>
				<label for="address2" class="lb">상세주소</label>
				<span class="lb_data">
					<input type="text" name="maddr2" id="maddr2"  value="<%=nikonmember.getMaddr2() %>" class="in_data" />
				</span>
			</li>
			<li>
				<span class="fr_col first">
					<input type="submit" value="정보수정"  class="btn btn-default"/>
				</span>
				<span class="fr_col last">
					<input type="reset" value="취소" class="btn btn-default"/>
				</span>
			</li>
		</ul>
		</form>
</div>
</div>
	<!-- 회원가입시 바뀐 형식의 주소 및 우편번호 취급 처리 스크립트 -->
    <script>
       //다음카카오의 주소 API이용
        function findAddr(){
            new daum.Postcode({
                oncomplete: function(data) {
                    console.log(data);                   
                    var roadAddr = data.roadAddress; // 도로명 주소 변수
                    var jibunAddr = data.jibunAddress; // 지번 주소 변수
                    // 우편번호와 주소 정보를 해당 필드에 넣는다.
                    document.getElementById('zipcode').value = data.zonecode;
                    if(roadAddr !== ''){
                        document.getElementById("addr1").value = roadAddr;
                    } 
                    else if(jibunAddr !== ''){
                        document.getElementById("addr1").value = jibunAddr;
                    }
                }
            }).open();
        }
    </script>
    <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

</body>
</html>