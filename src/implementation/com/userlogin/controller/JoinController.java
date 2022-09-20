package implementation.com.userlogin.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import implementation.com.userlogin.dao.MemberDao;
import implementation.com.userlogin.service.JoinService;

public class JoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException
	{
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		MemberDao dao = new MemberDao();
		dao.setUser_id(req.getParameter("id"));
		dao.setUser_pass(req.getParameter("pass1"));
		dao.setUser_name(req.getParameter("name"));
		dao.setPhone_num(req.getParameter("phone_num"));
		dao.setAddress(req.getParameter("address"));
		dao.setUser_lvl(req.getParameter("id"));
		
		System.out.println(dao.getUser_id());
		JoinService js = new JoinService();
		js.join(dao);
		
		resp.sendRedirect("http://localhost:8085/userlogin_7/loginPage.jsp");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		doGet(req, resp);
	}
}
