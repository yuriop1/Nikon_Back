package com.nikon.view;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nikon.biz.nikonproductDAO;
import com.nikon.model.nikonproductVO;

@WebServlet("/GetnikonproductCtrl")
public class GetnikonproductCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pcode = request.getParameter("pcode");
		
		nikonproductVO vo = new nikonproductVO();
		vo.setPcode(pcode);
		
		nikonproductDAO dao = new nikonproductDAO();
		nikonproductVO nikonproduct = dao.getnikonproduct(vo);
		
		if(nikonproduct != null) {
			request.setAttribute("nikonproduct", nikonproduct);
			RequestDispatcher view = request.getRequestDispatcher("/product/getnikonproduct.jsp");
			view.forward(request, response);
		} else {
			response.sendRedirect("GetnikonproductListCtrl");
		}
	}
}