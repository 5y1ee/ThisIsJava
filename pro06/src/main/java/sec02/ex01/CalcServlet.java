package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc")
public class CalcServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");	// 요청시 인코딩, 파라미터
		res.setContentType("text/html;charset=utf-8");	// 응답시 인코딩 + 마임타입(mime type)
		
		PrintWriter pw = res.getWriter();	// 브라우저로 출력하는 객체
		
		String command = req.getParameter("command");	// command : 변환버튼 눌러서 온건지, 그냥 온건지
		String won = req.getParameter("won");
		String operator = req.getParameter("operator");
		
		if (command != null && command.equals("calculate")) {
			String result = calculate(Float.parseFloat(won), operator);
			pw.print("<html><font size=10>변환 결과</font><br>");
			pw.print("<html><font size=10>"+result+"</font><br>");
			pw.print("<a href='/pro06/calc'>환율 계산기</a>");
			return;
		}
		
		pw.print("<html><title>환율 계싼기</title>");
		pw.print("<font size=5>환율 계산기</font><br>");
		pw.print("<form name='frmCalc' method='get' action='/pro06/calc'  />");
		pw.print("원화 : <input type='text' name='won'size=10  />  ");
		pw.print("<select name='operator' >");
		pw.print("<option value='dollar'>달러</option>");
		pw.print("<option value='en'>엔</option>");
		pw.print("</select>");
		pw.print("<input type='hidden' name='command' value='calculate'  />");
		pw.println("<input type='submit' value='변환'  />");
		pw.println("</form>");
		pw.print("</html>");
		pw.close();
	}
	
	private static String calculate(float won, String operator) {
		String result = null;
		
		if (operator.equals("dollar")) {
			result = String.format("%.6f", won / 1399);
		} else if (operator.equals("en")) {
			result = String.format("%.6f", won / 901);
		} else {
			result = "1234";
		}
		
		
		return result;
	}

}
