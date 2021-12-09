package com.shop.view;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.biz.NikonNoticeDAO;
import com.shop.model.NikonNoticeVO;

@WebServlet("/GetNikonNoticeListCtrl")
public class GetNikonNoticeListCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		NikonNoticeDAO dao = new NikonNoticeDAO();
		ArrayList<NikonNoticeVO> nikonnoticeList = dao.getNikonNoticeList();
		
		request.setAttribute("nikonnoticeList",  nikonnoticeList);
		RequestDispatcher view = request.getRequestDispatcher("/notice/getNikonNoticeList.jsp");
		view.forward(request, response);
	
	}
}
