package com.nikon.view;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nikon.biz.nikonmemberDAO;
import com.nikon.model.nikonmemberVO;

@WebServlet("/GetnikonmemberListCtrl")
public class GetnikonmemberListCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		nikonmemberDAO dao = new nikonmemberDAO();
		ArrayList<nikonmemberVO> nikonmemberList = dao.getnikonmemberList();
		
		System.out.println(nikonmemberList);	
		
		request.setAttribute("nikonmemberList", nikonmemberList);	//보낼 객체를 선언
		RequestDispatcher view = request.getRequestDispatcher("/member/getnikonmemberList.jsp");	//보내질 곳 선언
		view.forward(request, response);  //실제 보낼 객체를 보내질 곳에 송신
	}
}