package implementation.com.userlogin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import implementation.com.userlogin.dao.MemberDao;
import implementation.com.userlogin.service.UserLoginService;

public class UpdateinfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");

		MemberDao dao = new MemberDao();
		dao.setUser_id(req.getParameter("id"));
		dao.setUser_pass(req.getParameter("pass1"));
		dao.setUser_name(req.getParameter("name"));
		dao.setPhone_num(req.getParameter("phone_num"));
		dao.setAddress(req.getParameter("address"));

		RequestDispatcher dispatcher;
		dispatcher = null;
		UserLoginService usersvc = new UserLoginService();
		int ret;

		ret = usersvc.updateUserInfo(dao);
		System.out.println(ret);

		if (ret == 1) {
			req.setAttribute("success", "회원정보 수정 성공");
			dispatcher = req.getRequestDispatcher("/WEB-INF/views/success.jsp");
			System.out.println("회원정보 수정 성공");
			// resp.sendRedirect("http://localhost:8090/userlogin_7/loginPage.jsp");
		} else {
			req.setAttribute("searchResult", "회원정보 수정 실패");
			dispatcher = req.getRequestDispatcher("/WEB-INF/views/error.jsp");
		}
		
		dispatcher.forward(req, resp);
	}
	


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		doGet(req, resp);
	}
}