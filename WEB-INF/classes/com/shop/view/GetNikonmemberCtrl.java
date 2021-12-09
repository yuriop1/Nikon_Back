package com.shop.view;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.biz.NikonmemberDAO;
import com.shop.model.NikonmemberVO;

@WebServlet("/GetNikonmemberCtrl")
public class GetNikonmemberCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mid = request.getParameter("mid");
		
		NikonmemberVO vo = new NikonmemberVO();
		vo.setMid(mid);
		
		NikonmemberDAO dao = new NikonmemberDAO();
		NikonmemberVO nikonmember = dao.getNikonmember(vo);
		
		if(nikonmember!=null) {
			request.setAttribute("nikonmember", nikonmember);
			RequestDispatcher view = request.getRequestDispatcher("/member/getNikonmember.jsp");
			view.forward(request, response);
		} else {
			response.sendRedirect("GetNikonmemberListCtrl");
		}
	}

}
