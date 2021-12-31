package com.nikon.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nikon.biz.nikonmemberDAO2;
import com.nikon.model.nikonmemberVO;

@WebServlet("/LoginCtrl")
public class LoginCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  response.setContentType("text/html; charset=UTF-8");
	      request.setCharacterEncoding("UTF-8");
	      
	      String mid = request.getParameter("mid");
	      String mpw = request.getParameter("mpw");
	      
	      nikonmemberVO vo = new nikonmemberVO();
	      vo.setMid(mid);
	      vo.setMpw(mpw);
	      
	      nikonmemberVO member = new nikonmemberVO();
	      nikonmemberDAO2 dao = new nikonmemberDAO2();

	      member = dao.getnikonmember(vo);
	      HttpSession session = request.getSession();
	      if(member.getMid()!= null) {
	         session.setAttribute("mid",member.getMid());
	         session.setAttribute("mname",member.getMname());
	         if(member.getMid().equals("admin") && member.getMpw().equals("1234")) {
	            response.sendRedirect("adminheader.jsp");
	         }else {
	            response.sendRedirect("index.jsp");
	         }
	         }else {
	            response.sendRedirect("login.jsp");
	         }
	      }
	}