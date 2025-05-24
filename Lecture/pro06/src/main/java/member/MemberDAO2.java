package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO2 {
	
	private PreparedStatement pstmt;
//	private Statement stmt;
	private Connection con;
	
//	private String driver = "oracle.jdbc.OracleDriver";
//	private String url = "jdbc:oracle:thin:@localhost:1521/xe";
//	private String user = "testuser";
//	private String pwd = "test1234";
	private DataSource dataFactory;
	
	public MemberDAO2() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context)ctx.lookup("java:/comp/env");
			System.out.println(envContext);
			dataFactory = (DataSource)envContext.lookup("jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public List<MemberVO> listMembers() {
		List<MemberVO> list = new ArrayList<MemberVO>();
		
		try {
//			connDB();
			// Connection Pool에서 객체 가져오기
			con = dataFactory.getConnection();
			System.out.println("##"+con);
			String query = "SELECT * FROM t_member";
//			ResultSet rs = stmt.executeQuery(query);
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setPwd(rs.getString("pwd"));
				vo.setName(rs.getString("name"));
				vo.setEmail(rs.getString("email"));
				vo.setJoindate(rs.getDate("joindate"));
				list.add(vo);
			}
			rs.close();
//			stmt.close();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void addMember(MemberVO m) {
		try {
			con = dataFactory.getConnection();
			System.out.println("#"+con);
			String query = "INSERT INTO t_member (id,pwd,name,email) VALUES (?,?,?,?)";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getPwd());
			pstmt.setString(3, m.getName());
			pstmt.setString(4, m.getEmail());
			pstmt.executeUpdate();
			pstmt.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// DB 연결
//	private void connDB() {
//		try {
//			Class.forName(driver);
//			con = DriverManager.getConnection(url, user, pwd);
//			stmt = con.createStatement();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	

}
