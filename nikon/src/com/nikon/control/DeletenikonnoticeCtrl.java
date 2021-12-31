package com.nikon.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nikon.biz.nikonnoticeDAO;
import com.nikon.model.nikonnoticeVO;

@WebServlet("/DeletenikonnoticeCtrl")
public class DeletenikonnoticeCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		int seq = Integer.parseInt(request.getParameter("seq")); 
		int cnt=0;
		nikonnoticeVO vo = new nikonnoticeVO();
		vo.setSeq(seq);
		
		nikonnoticeDAO dao = new nikonnoticeDAO();
		cnt = dao.deletenikonnotice(vo);
		if(cnt!=0) response.sendRedirect("GetnikonnoticeListCtrl");
	
	}

}
