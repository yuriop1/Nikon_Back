package com.nikon.view;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nikon.biz.nikonnoticeDAO;
import com.nikon.model.nikonnoticeVO;

@WebServlet("/GetnikonnoticeCtrl")
public class GetnikonnoticeCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int seq = Integer.parseInt(request.getParameter("seq"));
		
		nikonnoticeVO vo = new nikonnoticeVO();
		vo.setSeq(seq);
		
		nikonnoticeDAO dao = new nikonnoticeDAO();
		nikonnoticeVO nikonnotice = dao.getnikonnotice(vo);
		
		if(nikonnotice != null) {
			request.setAttribute("nikonnotice", nikonnotice);
			RequestDispatcher view = request.getRequestDispatcher("/notice/getnikonnotice.jsp");
			view.forward(request, response);
			} else {
				response.sendRedirect("GetnikonnoticeListCtrl");
			}
		}
	}
