package com.nikon.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nikon.biz.nikonpayDAO;
import com.nikon.model.nikonpayVO;

@WebServlet("/AddnikonpayCtrl")
public class AddnikonpayCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		//String payid = request.getParameter("payid");
		String userid = request.getParameter("userid");
		int proid = Integer.parseInt(request.getParameter("proid"));
		int cnt = Integer.parseInt(request.getParameter("cnt"));
		String addr1 = request.getParameter("addr1");
		String contact = request.getParameter("contact");
		int paytype = Integer.parseInt(request.getParameter("paytype"));
		String creditnum = request.getParameter("creditnum");
		String credipw = request.getParameter("credipw");
		
		nikonpayVO vo = new nikonpayVO();
		vo.setUserid(userid);
		vo.setProid(proid);
		vo.setCnt(cnt);
		vo.setAddr1(addr1);
		vo.setContact(contact);
		vo.setPaytype(paytype);
		vo.setCreditnum(creditnum);
		vo.setCredipw(credipw);
		
		nikonpayDAO dao = new nikonpayDAO();
		int cnt1 = dao.addnikonpay(vo);
		
		if(cnt1 > 0) {
			response.sendRedirect("GetnikonproductListCtrl");
		} else {
			response.sendRedirect("GetnikonproductCtrl?proid="+proid);
		}
	}
}