package implementation.com.userlogin.controller;

import java.io.IOException; 
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import implementation.com.userlogin.dao.MemberDao;
import implementation.com.userlogin.service.UserLoginService;

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		String user_id = req.getParameter("id");
		String user_pass = req.getParameter("pass");
	
		ArrayList<MemberDao> usersvc = new UserLoginService().userList();
		RequestDispatcher dispatcher = null;
		HttpSession session = req.getSession();
		
		for(int i = 0; i < usersvc.size() ; i++) {
			if(user_id.equals(usersvc.get(i).getUser_id()) && user_pass.equals(usersvc.get(i).getUser_pass())){
				if(usersvc.get(i).getUser_lvl().equals("3")) {
					session.setAttribute("user_id", usersvc.get(i).getUser_id());
					session.setAttribute("user_pass", usersvc.get(i).getUser_pass());
					req.setAttribute("searchResultList", usersvc);
					dispatcher = req.getRequestDispatcher("/WEB-INF/views/adminPage.jsp");
					System.out.println("관리자");
					break;
				}else if(usersvc.get(i).getUser_lvl().equals("2")){
					session.setAttribute("user_id", usersvc.get(i).getUser_id());
					session.setAttribute("user_pass", usersvc.get(i).getUser_pass());
					req.setAttribute("userInfo", usersvc.get(i));
					dispatcher = req.getRequestDispatcher("/WEB-INF/views/userPage.jsp");
					System.out.println("일반");
					break;
				}else if(usersvc.get(i).getUser_lvl().equals("1")){
					session.setAttribute("user_id", usersvc.get(i).getUser_id());
					session.setAttribute("user_pass", usersvc.get(i).getUser_pass());
					req.setAttribute("userInfo", usersvc.get(i));
					dispatcher = req.getRequestDispatcher("/WEB-INF/views/userPage.jsp");
					System.out.println("일반");
					break;
				}	
			}else if(!user_id.equals(usersvc.get(i).getUser_id()) && user_pass.equals(usersvc.get(i).getUser_pass())) {
				req.setAttribute("searchResult", "존재하지 않는 아이디 입니다. ");
				dispatcher = req.getRequestDispatcher("/WEB-INF/views/error.jsp");
				System.out.println("아이디 에러");
				break;
			}else if(user_id.equals(usersvc.get(i).getUser_id()) && !user_pass.equals(usersvc.get(i).getUser_pass())) {
				req.setAttribute("searchResult", "패스워드를 확인해주세요. ");
				dispatcher = req.getRequestDispatcher("/WEB-INF/views/error.jsp");
				System.out.println("패스워드 에러");
				break;
			}
		
		}
		

		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		doGet(req, resp);
	}
}
