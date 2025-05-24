package ch20.oracle.sec11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransactionExample {

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
			
			// 트랜잭션 시작
			conn.setAutoCommit(false);
			
			System.out.println("ddDDDD");

			
			// 출금
			String sql1 = "UPDATE accounts SET balance=balance-? WHERE ano=?";
			PreparedStatement pstmt1 = conn.prepareStatement(sql1);
			pstmt1.setInt(1, 10000);
			pstmt1.setString(2, "111-111-1111");
			int row1 = pstmt1.executeUpdate();
			if (row1 == 0) throw new Exception("출금 실패");
			pstmt1.close();
			
			System.out.println("DDDD");

			
			// 입금
			String sql2 = "UPDATE accounts SET balance=balance+? WHERE ano=?";
			PreparedStatement pstmt2 = conn.prepareStatement(sql2);
			pstmt2.setInt(1, 10000);
			pstmt2.setString(2, "222-222-2222");
			int row2 = pstmt2.executeUpdate();
			if (row2 == 0) throw new Exception("입금 실패");
			pstmt2.close();
			
			conn.commit();
			
			
			System.out.println("DDDDone");

			
		}
		catch (Exception e) {
			System.out.println("DDDD");
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				System.out.println("계좌 이체 실패");
				e.printStackTrace();
			} finally {
				if (conn != null) {
					try {
						conn.setAutoCommit(true);
						conn.close();
						System.out.println("연결 끊기");
					} catch (SQLException e2) {}
				}
			}

		}
		
	}

}
