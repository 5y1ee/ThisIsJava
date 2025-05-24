package ch20.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MariaDB {
/*
	SELECT s.name, s.tel, s.major1, m.name, s.major2, m2.name, s.profno, p.name
	FROM student s
		LEFT JOIN professor p ON s.profno = p.no
		LEFT JOIN major m ON s.major1 = m.code
		LEFT JOIN major m2 ON s.major2 = m2.code
	;
 */
	public static void main(String[] args) {
		
		try {
			func();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void func() throws SQLException, ClassNotFoundException {
		
		Class.forName("org.mariadb.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection(
				"jdbc:mariadb://localhost:3306/study",
				"testuser",
				"test1234"
				);
		
		String sql = "SELECT s.name, s.tel, s.major1, m.name, s.major2, m2.name, s.profno, p.name"
				+ "	FROM student s"
				+ "		LEFT JOIN professor p ON s.profno = p.no"
				+ "		LEFT JOIN major m ON s.major1 = m.code"
				+ "		LEFT JOIN major m2 ON s.major2 = m2.code"
				+ "	;";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			System.out.printf("%-6s%-12s%-8d%-16s%-8d%-16s%-8d%-12s\n",
					rs.getString("s.name"),
					rs.getString("s.tel"),
					rs.getInt("s.major1"),
					rs.getString("m.name"),
					rs.getInt("s.major2"),
					rs.getString("m2.name"),
					rs.getInt("s.profno"),
					rs.getString("p.name")
					);
		}
		rs.close();
		pstmt.close();
		
		
		
	}

}
