<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"  %>    
<%@ page import="java.util.Date"  %>
<%@ page import="com.nikon.biz.*"  %>
<%@ page import="com.nikon.model.*"  %>
<%
	nikonmemberVO nikonmember = (nikonmemberVO) request.getAttribute("nikonmember");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="../index.jsp" %>
<div class="container">
   <h2 class="tit">회원 목록 보기</h2>
   <form action="UpdatenikonmemberCtrl" method="post" name="frm">
      <table class="table">
         <tr>
            <th class="item1">아이디</th>
            <td class="item2"><%=nikonmember.getMid() %>
               <input type="hidden" name="mid" value="<%=nikonmember.getMid() %>"/>
            </td>
         </tr>
         <tr>   
            <th class="item1">비밀번호</th>
            <td class="item2">
               <input type="text" name="mpw" value="<%=nikonmember.getMpw() %>"/>
            </td>
         </tr>   
         <tr>
            <th class="item1">이름</th>
            <td class="item2">
               <input type="text" name="mname" value="<%=nikonmember.getMname() %>"/>
            </td>
         </tr>
         <tr>
            <th class="item1">전화번호</th>
            <td class="item2">
               <input type="text" name="mtel" value="<%=nikonmember.getMtel() %>"/>
            </td>
         </tr>
         <tr>   
            <th class="item1">주소</th>
            <td class="item2">
               <input type="text" name="maddr1" value="<%=nikonmember.getMaddr1() %>"/>
            </td>
         </tr>
         <tr>   
            <th class="item1">상세주소</th>
            <td class="item2">
               <input type="text" name="maddr2" value="<%=nikonmember.getMaddr2() %>"/>            
            </td>
         </tr>
      </table>
      <div class="btn-group">
         <input type="submit" class="btn btn-default" value="회원 정보 수정" />
         <a href="GetnikonmemberListCtrl" class="btn btn-default">목록</a>
         <a href="DeletenikonmemberCtrl?mid=<%=nikonmember.getMid() %>" class="btn btn-default">회원 탈퇴</button>
      </div>
   </form>
</div>
</body>
</html>