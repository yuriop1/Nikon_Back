package com.nikon.view;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nikon.biz.nikoninDAO;
import com.nikon.model.nikoninVO;

@WebServlet("/GetnikoninCtrl")
public class GetnikoninCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int icode = Integer.parseInt(request.getParameter("icode"));
		
		nikoninVO vo = new nikoninVO();
		vo.setIcode(icode);
		
		nikoninDAO dao = new nikoninDAO();
		nikoninVO nikonin = dao.getnikonin(vo);
		
		if(nikonin != null) {
			request.setAttribute("nikonin", nikonin);
			RequestDispatcher view = request.getRequestDispatcher("/in/getnikonin.jsp");
			view.forward(request, response);
		} else {
			response.sendRedirect("GetnikoninListCtrl");
		}
	}
}