package com.nikon.view;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nikon.biz.nikonpayDAO;
import com.nikon.model.nikonpayVO;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GetUsernikonpaytListCtrl")
public class GetUsernikonpaytListCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String mid = request.getParameter("mid");
		nikonpayVO vo = new nikonpayVO();
		vo.setUserid(mid);
		
		nikonpayDAO dao = new nikonpayDAO();
		ArrayList<nikonpayVO> nikonpay = new ArrayList<nikonpayVO>();
		nikonpay = dao.getUsernikonpayList(vo);
		
		if(nikonpay != null) {
			request.setAttribute("nikonpayList", nikonpay);
			RequestDispatcher view = request.getRequestDispatcher("getUsernikonpaytList.jsp");
			view.forward(request, response);			
		} else {
			response.sendRedirect("index.jsp");
		}
	}
}
