package member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberServlet
 */
@WebServlet("/member3")
public class MemberServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		MemberDAO2 dao = new MemberDAO2();

		String command = request.getParameter("command");
		System.out.println("command : " + command);
		if ("addMember".equals(command)) {
			MemberVO vo = new MemberVO();
			vo.setId(request.getParameter("id"));
			vo.setPwd(request.getParameter("pwd"));
			vo.setName(request.getParameter("name"));
			vo.setEmail(request.getParameter("email"));
			dao.addMember(vo);
		} else if ("delMember".equals(command)) {
			;
		}
		
		List<MemberVO> list = dao.listMembers();
		
		String html = """
				<html><body>
				<table border=1> <tr align='center' bgcolor='lightgreen'>
				<td>아이디</td><td>비밀번호</td><td>이름</td><td>이메일</td><td>가입일</td>
				</tr>
				""";
		
		for (int i=0; i<list.size(); ++i) {
			MemberVO vo = list.get(i);
			String id = vo.getId();
			String pwd = vo.getPwd();
			String name = vo.getName();
			String email = vo.getEmail();
			Date joinDate = vo.getJoindate();
			
			html += "<tr><td>" + id + "</td><td>" + pwd + "</td><td>" + name + "</td><td>" + email + "</td><td>" + joinDate + "</td></tr>";
		}
		
		html += "</table></body></html>";
		
		out.print(html);
		
		System.out.println(list.size());
		System.out.println(html);
		
	}

}
