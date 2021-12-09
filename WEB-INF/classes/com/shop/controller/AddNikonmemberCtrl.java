package com.shop.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.biz.NikonmemberDAO;
import com.shop.model.NikonmemberVO;

@WebServlet("/AddNikonmemberCtrl")
public class AddNikonmemberCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		String mname = request.getParameter("mname");
		String mtel = request.getParameter("mtel");
		String maddr1 = request.getParameter("maddr1");
		String maddr2 = request.getParameter("maddr2");
		
		NikonmemberVO vo = new NikonmemberVO();
		vo.setMid(mid);
		vo.setMpw(mpw);
		vo.setMname(mname);
		vo.setMtel(mtel);
		vo.setMaddr1(maddr1);
		vo.setMaddr2(maddr2);
		
		NikonmemberDAO dao = new NikonmemberDAO();
		int cnt = dao.addNikonmember(vo);
		
		if(cnt!=0) {
			response.sendRedirect("GetNikonmemberListCtrl");     			
		} else {
			response.sendRedirect("/member/addnikonmember.jsp");		
		}
	}

}
