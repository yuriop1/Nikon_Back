package com.nikon.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nikon.biz.nikoninDAO;
import com.nikon.biz.nikonnoticeDAO;
import com.nikon.model.nikoninVO;

@WebServlet("/UpdatenikoninCtrl")
public class UpdatenikoninCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		int icode = Integer.parseInt(request.getParameter("icode"));
		String iid = request.getParameter("iid");
		String iname = request.getParameter("iname");
		String iprice = request.getParameter("iprice");
		
		nikoninVO vo = new nikoninVO();
		vo.setIcode(icode);
		vo.setIid(iid);
		vo.setIname(iname);
		vo.setIprice(iprice);
		
		nikoninDAO dao = new nikoninDAO();
		int cnt = dao.updatenikonin(vo);
		if(cnt>0) response.sendRedirect("GetnikoninListCrl");
		
	}

}
