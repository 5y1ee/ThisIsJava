package sec06.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	public void init() throws ServletException {
		System.out.println("[login sv] init");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		System.out.println(user_id + " " + user_pw);
		
		MemberVO memberVO = new MemberVO();
		memberVO.setId(user_id);
		memberVO.setPwd(user_pw);
		
		MemberDAO dao = new MemberDAO();
		boolean result = dao.isExisted(memberVO);
		
		if (result) {
			HttpSession session = request.getSession();
			session.setAttribute("isLogon", true);
			session.setAttribute("login.id", user_id);
			session.setAttribute("login.pwd", user_pw);
			
			response.sendRedirect("show");
		} else {
//			PrintWriter pw = new PrintWriter();
		}
		response.sendRedirect("show");
		
		
		String data = "<html><body>아이디 :" + user_id + "<br>패스워드 : " + user_pw + "</body></html>";
		response.getWriter().print(data);
		
	}
	
	public void destroy() {
		System.out.println("[login sv] destroy");
	}

}
