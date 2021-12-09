package com.shop.view;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.biz.NikonNoticeDAO;
import com.shop.model.NikonNoticeVO;

@WebServlet("/GetNikonNoticeCtrl")
public class GetNikonNoticeCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int seq = Integer.parseInt(request.getParameter("seq"));
		
		NikonNoticeVO vo = new NikonNoticeVO();
		vo.setSeq(seq);
		
		NikonNoticeDAO dao = new NikonNoticeDAO();
		NikonNoticeVO nikonnotice = dao.getNikonNotice(vo);
		
		if(nikonnotice != null) {
			request.setAttribute("nikonnotice", nikonnotice);
			RequestDispatcher view = request.getRequestDispatcher("/notice/getNikonNotice.jsp");
			view.forward(request, response);
		} else {
			response.sendRedirect("GetNikonNoticeListCtrl");
		}
	}
}