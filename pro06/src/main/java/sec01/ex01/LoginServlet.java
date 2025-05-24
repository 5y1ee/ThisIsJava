package sec01.ex01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	public void init() throws ServletException {
		System.out.println("[login sv] init");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		System.out.println(user_id + " " + user_pw);
		
		String[] subjects = request.getParameterValues("subject");
		for (String sub : subjects) {
			System.out.println("과목 : " + sub);
		}
		
		String data = "<html><body>아이디 :" + user_id + "<br>패스워드 : " + user_pw + "</body></html>";
		response.getWriter().print(data);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	public void destroy() {
		System.out.println("[login sv] destroy");
	}

}
