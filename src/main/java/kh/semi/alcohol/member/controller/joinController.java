package kh.semi.alcohol.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.semi.alcohol.member.model.dto.MemberDTO;
import kh.semi.alcohol.member.model.service.MemberService;

@WebServlet("/join")
public class joinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService memberService = new MemberService(); // Assuming you have a MemberService class
       
    public joinController() {
        super();
        
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getSession().removeAttribute("join");
		request.getRequestDispatcher("/WEB-INF/view/joinForm.jsp").forward(request, response);
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		-------------- -------- ------------- 
//		USER_ID        NOT NULL VARCHAR2(20)  
//		USER_NAME      NOT NULL VARCHAR2(50)  
//		USER_PW        NOT NULL VARCHAR2(20)  
//		USER_EMAIL              VARCHAR2(255) 
//		USER_HOME               VARCHAR2(255) 
//		USER_CELLPHONE          NUMBER        
//		USER_HOMEPHONE          NUMBER     
			String userId = request.getParameter("userId");
	        String userName = request.getParameter("userName");
	        String userPw = request.getParameter("userPw");
	        String userEmail = request.getParameter("userEmail");
	        String userHome = request.getParameter("userHome");
	        int userCellphone = 0;
	        int userHomePhone = 0;
	        
	        try {
	            userCellphone = Integer.parseInt(request.getParameter("userCellphone"));
	            userHomePhone = Integer.parseInt(request.getParameter("userHomePhone"));
	        } catch (NumberFormatException e) {
	            // Handle parsing error if necessary
	            e.printStackTrace();
	        }

	        if (userId == null || userName == null || userPw == null) {
	            request.setAttribute("errorMsg", "모든 필수 정보를 입력해주세요.");
	            request.getRequestDispatcher("/errorPage.jsp").forward(request, response);
	            return;
	        }

	        MemberDTO newMember = new MemberDTO(userId, userName, userPw, userEmail, userHome, userCellphone, userHomePhone);

	        try {
	            boolean isRegistrationSuccessful = memberService.registerMember(newMember);

	            if (isRegistrationSuccessful) {
	                response.sendRedirect(request.getContextPath() + "/successPage.jsp");
	            } else {
	                request.setAttribute("errorMsg", "회원가입에 실패했습니다. 다시 시도해주세요.");
	                request.getRequestDispatcher("/errorPage.jsp").forward(request, response);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            request.setAttribute("errorMsg", "회원가입 중 오류가 발생했습니다.");
	            request.getRequestDispatcher("/errorPage.jsp").forward(request, response);
	        }
	    }
	}