package ch20.oracle.sec05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionExample {

	public static void main(String[] args) {
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521/xe",
					"testuser",
					"test1234"
					);
			System.out.println("연결 성공");
			
			
			String sql = "" +
					"INSERT INTO boards (bno, btitle, bcontent, bwriter, bdate, bfilename, bfiledata)"
					+ "VALUES (SEQ_BNO.NEXTVAL,?,?,?,SYSDATE,?,?)";
			
			PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"bno"});
			pstmt.setString(1, "눈이 와요");
			pstmt.setString(2, "많이 와요");
			pstmt.setString(3, "winter");
			pstmt.setString(4, "C:\\snow.jpg");
			pstmt.setBlob(5, BoardWithFileInsertExample.class.getResourceAsStream("snow"));
			
			int rows = pstmt.executeUpdate();
			System.out.println("행수" + rows);
			
			if (rows==1) {
				ResultSet rs = pstmt.getGeneratedKeys();
				if (rs.next()) {
					int bno = rs.getInt(1);
					System.out.println("bno : " + bno);
				}
				rs.close();
				
			}
			
			pstmt.close();
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (conn != null) {
				try {
					conn.close();
					System.out.println("연결 끊기");
				} catch (SQLException e) {}
			}
		}
		
	}

}
