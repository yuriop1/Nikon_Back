<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"  %>    
<%@ page import="java.util.Date"  %>
<%@ page import="com.nikon.biz.*" %>
<%@ page import="com.nikon.model.*"  %>   
<%
   nikonproductVO nikonproduct = (nikonproductVO) request.getAttribute("nikonproduct");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품 목록 보기</title>
</head>
<body>
<div class="container">
<%@ include file="../adminheader.jsp" %>
   <h2 class="tit">제품 목록 보기</h2>
   <form action="" method="post" name="frm">
      <table class="table">
         <tr>
            <th class="item1">제품 코드</th>
            <td class="item2"><%=nikonproduct.getPcode() %>
               <input type="hidden" name="pcode" value="<%=nikonproduct.getPcode() %>"/>
            </td>
         </tr>
         <tr>
            <th class="item1">제품명</th>
            <td class="item2"><%=nikonproduct.getPname() %>
               <input type="hidden" name="pname" value="<%=nikonproduct.getPname() %>"/>
            </td>
         </tr>
         <tr>
            <th class="item1">제품 설명</th>
            <td class="item2"><%=nikonproduct.getPinfo() %>
               <input type="hidden" name="pinfo" value="<%=nikonproduct.getPinfo() %>"/>
            </td>
         </tr>
         <tr>
            <th class="item1">가격</th>
            <td class="item2"><%=nikonproduct.getPprice() %>
               <input type="hidden" name="pprice" value="<%=nikonproduct.getPprice() %>"/>
            </td>
         </tr>
         <tr>
            <th class="item1">제품 사진</th>
            <td class="item2"><%=nikonproduct.getPimg() %>
               <input type="hidden" name="pstar" value="<%=nikonproduct.getPimg() %>"/>
            </td>
         </tr>
		</table>
      <div class="btn-group">
         <a href="GetnikonproductListCtrl" class="btn btn-default">목록</a>
         <a href="DeletenikonproductCtrl?pcode=<%=nikonproduct.getPcode() %>" class="btn btn-default">제품삭제</button>
      </div>
   </form>
</div>
</body>
</html>