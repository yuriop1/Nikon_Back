package com.nikon.view;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nikon.biz.nikonmemberDAO;
import com.nikon.model.nikonmemberVO;

@WebServlet("/GetnikonmemberCtrl")
public class GetnikonmemberCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mid = request.getParameter("mid");
		
		nikonmemberVO vo = new nikonmemberVO();
		vo.setMid(mid);
		
		nikonmemberDAO dao = new nikonmemberDAO();
		nikonmemberVO nikonmember = dao.getnikonmember(vo);
		
		if(nikonmember != null) {
			request.setAttribute("nikonmember", nikonmember);
			RequestDispatcher view = request.getRequestDispatcher("/member/getnikonmember.jsp");
			view.forward(request, response);
		} else {
			response.sendRedirect("GetnikonmemberListCtrl");
		}
	}
}