package kh.semi.alcohol.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.alcohol.member.model.dto.memberDTO;
import kh.semi.alcohol.member.model.service.MemberService;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService service = new MemberService();

	public LoginController() {
		super();
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		memberDTO result = service.selectOne(userId, userPw);
		if (result != null) {
			request.getSession().setAttribute("loginedInfo", result);
			response.sendRedirect(request.getContextPath()+"/");
		} else {
			// 경고창 띄우기 - 1
			request.getSession().setAttribute("msg", "아이디와 패스워드를 다시 확인하고 로그인 시도해주세요.");
			response.sendRedirect(request.getContextPath()+"/");
		}
	}

}
