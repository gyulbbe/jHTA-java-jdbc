package demo2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utils.ConnectionUtils;

public class App3 {

	public static void main(String[] args) throws SQLException {
		
		/*
		 * 책정보 조회하기
		 * 
		 * 번호, 제목, 저자, 출판사, 가격, 재고수량을 조회하기
		 * 
		 * SELECT BOOK_NO, BOOK_TITLE, BOOK_AUTHOR, BOOK_PRICE, BOOK_STATUS, BOOK_STOCK
		 * FROM SAMPLE_BOOKS
		 * ORDER BY BOOK_NO DESC;
		 */
		
		// 1. sql문
		String sql = """
				SELECT 
				BOOK_NO, BOOK_TITLE, BOOK_AUTHOR, BOOK_PRICE, BOOK_STATUS, BOOK_STOCK 
				FROM 
				SAMPLE_BOOKS 
				ORDER BY BOOK_NO DESC
				""";
		// 2. 연결 Connection
		Connection con = ConnectionUtils.getConnection();
		
		// 3. sql 전송 PreparedStatement
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		// 4. ResultSet에 담기
		ResultSet rs = pstmt.executeQuery();
		
		// 5. while문으로 꺼내기
		while (rs.next()) {
			int value1 = rs.getInt("BOOK_NO");
			String value2 = rs.getString("BOOK_TITLE");
			String value3 = rs.getString("BOOK_AUTHOR");
			int value4 = rs.getInt("BOOK_PRICE");
			String value5 = rs.getString("BOOK_STATUS");
			int value6 = rs.getInt("BOOK_STOCK");
			
			System.out.println(value1 + ", " + value2 + ", " + value3 + ", " + value4 + ", " + value5 + ", " + value6);
		}
		
		// 6. 닫기
		rs.close();
		pstmt.close();
		con.close();
	}
	
}
