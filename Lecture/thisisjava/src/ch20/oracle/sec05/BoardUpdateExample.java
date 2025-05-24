package ch20.oracle.sec05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BoardUpdateExample {

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
			
			
			String sql = new StringBuilder()
					.append("Update boards SET ")
					.append("btitle=?, ")
					.append("bcontent=?, ")
					.append("bfilename=?, ")
					.append("bfiledata=?, ")
					.append("WHERE bno=?, ")
					.toString();
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "눈사람");
			pstmt.setString(2, "눈으로 만든 사람");
			pstmt.setString(3, "C:\\snowman.jpg");
			pstmt.setBlob(4, BoardUpdateExample.class.getResourceAsStream("C:\\snowman.jpg"));
			pstmt.setInt(5, 3);
			
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
