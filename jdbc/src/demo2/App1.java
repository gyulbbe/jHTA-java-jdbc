package demo2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import utils.ConnectionUtils;

public class App1 {

	public static void main(String[] args) throws SQLException {
		
		/*
		 * 신규 도서 등록하기
		 * 
		 * 번호 	제목 			저자 		출판사 	가격 		할인율
		 * 100 	자바의 정석		남궁성	도우출판사	30000	0.15
		 * 102	이것이 자바다	신용권	한빛미디어	28000	0.15
		 * 
		 */
		int no = 102;
		String title = "이것이 자바다";
		String author = "한결";
		String publisher = "한빛미디어";
		int price = 28000;
		double discountRate = 0.15;
		
		// 1. INSERT SQL 정의
		String sql = """
				INSERT INTO SAMPLE_BOOKS 
				(BOOK_NO, BOOK_TITLE, BOOK_AUTHOR, BOOK_PUBLISHER, BOOK_PRICE, BOOK_DISCOUNT_RATE) 
				VALUES 
				(?, ?, ?, ?, ?, ?)
				""";
		
		// 2. Connection 획득
		Connection con = ConnectionUtils.getcoConnection();
		
		// 3. PreparedStatement 획득
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		// 4. ?에 값 바인딩
		pstmt.setInt(1, no);
		pstmt.setString(2, title);
		pstmt.setString(3, author);
		pstmt.setString(4, publisher);
		pstmt.setInt(5, price);
		pstmt.setDouble(6, discountRate);
		
		// 5. SQL을 데이터베이스로 전송하고 실행시키기
		int rowCount = pstmt.executeUpdate();
		System.out.println("추가된 행: " + rowCount);
		
		// 6. 사용했던 자원 반납하기
		pstmt.close();
		con.close();
	}
}