package com.shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.biz.NikonmemberDAO;
import com.shop.model.NikonmemberVO;

@WebServlet("/DeleteNikonmemberCtrl")
public class DeleteNikonmemberCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String mid = request.getParameter("mid");
		NikonmemberVO vo = new NikonmemberVO();
		vo.setMid(mid);
		
		NikonmemberDAO dao = new NikonmemberDAO();
		
	}

}
