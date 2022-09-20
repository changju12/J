package implementation.com.userlogin.controller;

import java.io.IOException; 

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import implementation.com.userlogin.dao.MemberDao;
import implementation.com.userlogin.service.UserLoginService;

public class UpdateUserLevelController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int ret;
	RequestDispatcher diapatcher = null;

	// 추진호 개발

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
		
		
		UserLoginService usersvc = new UserLoginService();
		
		ret = usersvc.updateUserInfo(dao);
		System.out.println(ret);
	
		
		if(ret != 0) {
			req.setAttribute("success", "회원정보 수정 성공");
			diapatcher = req.getRequestDispatcher("/WEB-INF/views/success.jsp");
			System.out.println("회원정보 수정 성공");
//			resp.sendRedirect("http://localhost:8090/userlogin_7/loginPage.jsp");
		}else{
			req.setAttribute("searchResult", "회원정보 수정 실패");
			diapatcher = req.getRequestDispatcher("/WEB-INF/views/error.jsp");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		doGet(req, resp);
	}
}
