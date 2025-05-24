package sec03.ex03;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login5")
public class LoginServlet5 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet5() {
        super();
    }

	public void init() throws ServletException {
		System.out.println("[login sv] init");
	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
	

}
