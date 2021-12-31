package com.nikon.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nikon.biz.nikonmemberDAO2;
import com.nikon.model.nikonmemberVO;

@WebServlet("/DeletenikonmemberCtrl")
public class DeletenikonmemberCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String mid = request.getParameter("mid");
		int cnt = 0;
		nikonmemberVO vo = new nikonmemberVO();
		vo.setMid(mid);
		
		nikonmemberDAO2 dao = new nikonmemberDAO2();
		cnt = dao.deletenikonmember(vo);
		if(cnt!=0) response.sendRedirect("GetnikonmemberListCtrl");
	}
}