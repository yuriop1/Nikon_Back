package com.nikon.view;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nikon.biz.nikoninDAO;
import com.nikon.model.nikoninVO;

@WebServlet("/GetnikoninListCtrl")
public class GetnikoninListCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		nikoninDAO dao = new nikoninDAO();
		ArrayList<nikoninVO> nikoninList = dao.getnikoninList();
		
		System.out.println(nikoninList);	
		
		request.setAttribute("nikoninList", nikoninList);	//보낼 객체를 선언
		RequestDispatcher view = request.getRequestDispatcher("/in/getnikoninList.jsp");	//보내질 곳 선언
		view.forward(request, response);  //실제 보낼 객체를 보내질 곳에 송신
	}
}