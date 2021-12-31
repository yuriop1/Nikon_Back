package com.nikon.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nikon.biz.nikonnoticeDAO;
import com.nikon.model.nikonnoticeVO;

@WebServlet("/UpdatenikonnoticeCtrl")
public class UpdatenikonnoticeCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		int seq = Integer.parseInt(request.getParameter("seq"));
		String ntit = request.getParameter("ntit");
		String ncon = request.getParameter("ncon");
		
		nikonnoticeVO vo = new nikonnoticeVO();
		vo.setSeq(seq);
		vo.setNtit(ntit);
		vo.setNcon(ncon);
		
		nikonnoticeDAO dao = new nikonnoticeDAO();
		int cnt = dao.updatenikonnotice(vo);
		if(cnt>0) response.sendRedirect("GetnikonnoticeListCrl");
		
	}

}
