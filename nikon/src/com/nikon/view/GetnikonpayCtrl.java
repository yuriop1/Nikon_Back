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

@WebServlet("/GetnikonpayCtrl")
public class GetnikonpayCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String payid = request.getParameter("payid");
		
		nikonpayVO vo = new nikonpayVO();
		vo.setPayid(payid);
		
		nikonpayDAO dao = new nikonpayDAO();
		ArrayList<nikonpayVO> nikonpayList = dao.getnikonpayList();
		
		if(nikonpayList != null) {
			request.setAttribute("nikonpayList", nikonpayList);
			RequestDispatcher view = request.getRequestDispatcher("pay/getnikonpay.jsp");
			view.forward(request, response);
		} else {
			response.sendRedirect("GetnikonpayListCtrl");
		}
	}
}
