package com.nikon.control;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nikon.biz.nikonnoticeDAO;
import com.nikon.model.nikonnoticeVO;

@WebServlet("/AddnikonnoticeCtrl")
public class AddnikonnoticeCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response, Date nregdate) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");	
		
		int seq = Integer.parseInt(request.getParameter("seq"));
		String nname = request.getParameter("nname");
		String ntit = request.getParameter("ntit");
		String ncon = request.getParameter("ncon");
		int nvisited = Integer.parseInt(request.getParameter("nvisited"));
	
		nikonnoticeVO vo = new nikonnoticeVO();
		vo.setSeq(seq);
		vo.setNname(nname);
		vo.setNtit(ntit);
		vo.setNcon(ncon);
		vo.setNvisited(nvisited);
		
		nikonnoticeDAO dao = new nikonnoticeDAO();
		int cnt = dao.addnikonnotice(vo);
		if(cnt!=0) {
			response.sendRedirect("GetnikonnoticeListCtrl");
		} else {
			response.sendRedirect("/product/addnikonnotice.jsp");
		} 
	}
}