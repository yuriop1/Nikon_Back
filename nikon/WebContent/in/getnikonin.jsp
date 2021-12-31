<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"  %>    
<%@ page import="java.util.Date"  %>
<%@ page import="com.nikon.biz.*"  %>
<%@ page import="com.nikon.model.*"  %>
<%
	nikoninVO nikonin = (nikoninVO) request.getAttribute("nikonin");
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
   <h2 class="tit">장바구니 상센 보기</h2>
   <form action="UpdatenikoninCtrl" method="post" name="frm">
      <table class="table">
         <tr>
            <th class="item1">장바구니번호</th>
            <td class="item2"><%=nikonin.getIcode() %>
               <input type="hidden" name="icode" value="<%=nikonin.getIcode() %>"/>
            </td>
         </tr>
         <tr>   
            <th class="item1">회원아이디</th>
            <td class="item2">
               <input type="text" name="iid" value="<%=nikonin.getIid() %>"/>
            </td>
         </tr>   
         <tr>
            <th class="item1">제품이름</th>
            <td class="item2">
               <input type="text" name="iname" value="<%=nikonin.getIname() %>"/>
            </td>
         </tr>
         <tr>
            <th class="item1">가격</th>
            <td class="item2">
               <input type="text" name="iprice" value="<%=nikonin.getIprice() %>"/>
            </td>
         </tr>
      </table>
      <div class="btn-group">
         <input type="submit" class="btn btn-default" value="장바구니 정보 수정" />
         <a href="GetnikoninListCtrl" class="btn btn-default">목록</a>
         <a href="DeletenikoninCtrl?mid=<%=nikonin.getIcode() %>" class="btn btn-default">장바구니 삭제</button>
      </div>
   </form>
</div>
</body>
</html>