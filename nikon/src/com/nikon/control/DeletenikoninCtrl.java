package com.nikon.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nikon.biz.nikoninDAO;
import com.nikon.model.nikoninVO;

@WebServlet("/DeletenikoninCtrl")
public class DeletenikoninCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		int icode = Integer.parseInt(request.getParameter("icode"));
		int cnt = 0;
		nikoninVO vo = new nikoninVO();
		vo.setIcode(icode);
		
		nikoninDAO dao = new nikoninDAO();
		cnt = dao.deletenikonin(vo);
		if(cnt!=0) response.sendRedirect("GetnikoninListCtrl");
	}
}