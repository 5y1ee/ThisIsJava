package sec03.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/secondForward", "/dd"},
			initParams = {@WebInitParam(name="id", value="lee")})
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ServletContext context;
	
	@Override
	public void init(ServletConfig config) {
		// ServletContext -> 프로젝트 전체
		context = config.getServletContext(); 
		// init 파라미터 출력
		System.out.println(context.getInitParameter("name"));
		
		// ServletConfig -> 서블릿용
		System.out.println(config.getInitParameter("id"));
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String html = """
				<html><body>
				secondForward
				한글한글
				</body></html>
				""";
		out.print(html);
		
		out.print(context.getInitParameter("name"));

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
