package sec06.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/show")
public class ShowMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ShowMember() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		
		HttpSession session = request.getSession();
		MemberVO memberSession = (MemberVO)session.getAttribute("loginSession");
		
		if (memberSession == null) {
			pw.println("<input type='button' value='로그인' onclick='location.href=\"login.html\";'>");
		} else {
			pw.print(memberSession.getName() + "님 안녕하세요.");
			pw.println("<input type='button' value='로그인' onclick='location.href=\"logout\";'>");
		}
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
