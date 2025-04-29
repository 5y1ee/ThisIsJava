package rentcar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class RentCar {

	static Connection conn = null;
	
	
	public static void main(String[] args) {
		
		// DB 연결
		connectDB();
		
		// 데이터 저장
		
		
		
	}
	
	public static void connectDB() {
		
		if (conn != null) {
			System.out.println("Alread Connected.");
			return;
		}
		
		try {
			// JDBC Driver 등록
			Class.forName("oracle.jdbc.OracleDriver");
			
			// 연결하기
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521/xe",
					"testuser",
					"test1234"
					);
			
			System.out.println("Connection Success.");
			
		} catch (Exception e) {
			System.out.println("Connection Fail.");
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					// 연결 끊기
					conn.close();
					System.out.println("End Connection.");
				} catch (SQLException e) {}
			}
		}
		
	}

}
