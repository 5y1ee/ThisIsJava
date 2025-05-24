package sec06.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LogoutServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		// 세션 객체 가져오기
		HttpSession session = request.getSession();
		MemberVO memberSession = (MemberVO)session.getAttribute("loginSession");
		// 세션 객체에서 로그인 세션 삭제
		
		// 1. 전체 삭제
		session.invalidate();
		// 2. 로그인 세션만 삭제
//		session.removeAttribute("loginSession");
		
		// show 페이지로 이동
		pw.println("<script>");
		pw.println("alert('로그아웃되었습니다.');");
		pw.println("location.href='show';");
		pw.println("</script>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
