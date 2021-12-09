package com.shop.view;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.biz.NikonmemberDAO;
import com.shop.model.NikonmemberVO;

@WebServlet("/GetNikonmemberListCtrl")
public class GetNikonmemberListCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		NikonmemberDAO dao = new NikonmemberDAO();
		ArrayList<NikonmemberVO> nikonmemberList = dao.getNikonmember();      
		
		request.setAttribute("nikonmemberList", nikonmemberList);
		RequestDispatcher view = request.getRequestDispatcher("member/getNikonmemberList.jsp");
		view.forward(request, response);
		
	}
}
