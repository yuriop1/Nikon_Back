package com.nikon.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nikon.biz.nikonmemberDAO;
import com.nikon.model.nikonmemberVO;

@WebServlet("/AddnikonmemberCtrl")
public class AddnikonmemberCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		String mname = request.getParameter("mname");
		String mtel = request.getParameter("mtel");
		String memail = request.getParameter("memail");
		String mzipcode = request.getParameter("mzipcode");
		String maddr1 = request.getParameter("maddr1");
		String maddr2 = request.getParameter("maddr2");
		
		nikonmemberVO vo = new nikonmemberVO();
		vo.setMid(mid);
		vo.setMpw(mpw);
		vo.setMname(mname);
		vo.setMtel(mtel);
		vo.setMemail(memail);
		vo.setMzipcode(mzipcode);		
		vo.setMaddr1(maddr1);
		vo.setMaddr2(maddr2);
		
		nikonmemberDAO dao = new nikonmemberDAO();
		int cnt = dao.addnikonmember(vo);
		
		if(cnt!=0) {
			response.sendRedirect("GetnikonmemberListCtrl");
		} else {
			response.sendRedirect("/member/addnikonmember.jsp");
		} 
	}
}