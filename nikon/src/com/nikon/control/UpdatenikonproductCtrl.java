package com.nikon.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nikon.biz.nikonproductDAO;
import com.nikon.model.nikonproductVO;

@WebServlet("/UpdatenikonproductCtrl")
public class UpdatenikonproductCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String pcode = request.getParameter("pcode");
		String pname = request.getParameter("pname");
		String pinfo = request.getParameter("pinfo");
		int pprice = Integer.parseInt(request.getParameter("pprice"));
		String pimg = request.getParameter("pimg");
		
		nikonproductVO vo = new nikonproductVO();
		vo.setPcode(pcode);
		vo.setPname(pname);
		vo.setPinfo(pinfo);
		vo.setPprice(pprice);
		vo.setPimg(pimg);
		
		nikonproductDAO dao = new nikonproductDAO();
		int cnt = dao.updatenikonproduct(vo);
		if(cnt>0) response.sendRedirect("GetnikonproductListCtrl");
	}

}
