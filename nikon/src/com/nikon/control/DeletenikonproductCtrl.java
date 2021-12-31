package com.nikon.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nikon.biz.nikonproductDAO;
import com.nikon.model.nikonproductVO;

@WebServlet("/DeletenikonproductCtrl")
public class DeletenikonproductCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String pcode = request.getParameter("pcode");
		int cnt=0;
		nikonproductVO vo = new nikonproductVO();
		vo.setPcode(pcode);
		
		nikonproductDAO dao = new nikonproductDAO();
		cnt = dao.deletenikonproduct(vo);
		if(cnt!=0) response.sendRedirect("GetnikonproductListCtrl");
	}
}