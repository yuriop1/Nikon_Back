package com.nikon.view;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nikon.biz.nikonmemberDAO2;
import com.nikon.model.nikonmemberVO;

@WebServlet("/MypageCtrl")
public class MypageCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		String mid = request.getParameter("mid");
		
		nikonmemberVO vo = new nikonmemberVO();
		vo.setMid(mid);
		
		nikonmemberDAO2 dao = new nikonmemberDAO2();
		//받을객체 = DAO객체명.메서드명(vo)
		nikonmemberVO nikonmember = new nikonmemberVO();
		nikonmember = dao.myPage(vo);
		System.out.println("처리된 아이디 : "+nikonmember.getMid());		
		if(nikonmember.getMid() == null) {
			response.sendRedirect("login.jsp");
		} else {
			request.setAttribute("nikonmember", nikonmember);
			RequestDispatcher view = request.getRequestDispatcher("mypage.jsp");
			view.forward(request, response);
		}
	}
}