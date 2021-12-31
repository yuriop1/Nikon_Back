package com.nikon.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nikon.biz.nikonpayDAO;
import com.nikon.model.nikonpayVO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nikon.biz.nikonpayDAO;
import com.nikon.model.nikonpayVO;

@WebServlet("/DeletenikonpayCtrl")
public class DeletenikonpayCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String payid = request.getParameter("payid");
		String proid = request.getParameter("proid");
		String num = request.getParameter("cnt");
		
		nikonpayVO vo = new nikonpayVO();
		vo.setPayid(payid);
		vo.setProid(Integer.parseInt(proid));
		vo.setCnt(Integer.parseInt(num));
		
		nikonpayDAO dao = new nikonpayDAO();
		int cnt1 = dao.deletenikonpay(vo);
		
		if(cnt1>0) {
			response.sendRedirect("GetUsernikonpayListCtrl");
		}  else {
			response.sendRedirect("admin.jsp");
		}
	}
}
