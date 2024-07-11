package demo2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import utils.ConnectionUtils;

public class App2 {

	public static void main(String[] args) throws SQLException {
		
		/*
		 * 도서정보 변경하기
		 * 
		 * 100번 도서의 도서가격, 할인율, 재고수량을 변경하기
		 * 
		 * UPDATE SAMPLE_BOOKS
		 * SET
		 * 	BOOK_PRICE = ?,
		 * 	BOOK_DISCOUNT_RATE = ?,
		 * 	BOOK_STOCK = ?,
		 * WHERE BOOK_NO = ?
		 */
		
		// 1. sql
		String sql = """
				UPDATE SAMPLE_BOOKS 
				SET BOOK_PRICE = ?, BOOK_DISCOUNT_RATE = ?, BOOK_STOCK = ? 
				WHERE BOOK_NO = ?
				""";
		
		// 2. Connection
		Connection con = ConnectionUtils.getcoConnection();
		
		// 3. PreparedStatement
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		// 4. ?값 바인딩
		pstmt.setInt(1, 25000);
		pstmt.setDouble(2, 0.2);
		pstmt.setInt(3, 98);
		pstmt.setInt(4, 100);
		
		// 5. sql문 전송
		int rowCount = pstmt.executeUpdate();
		System.out.println("수정된 행: " + rowCount);
		
		// 6. 닫기
		pstmt.close();
		con.close();
	}
}
