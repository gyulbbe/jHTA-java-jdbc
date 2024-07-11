package demo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class App2 {

	public static void main(String[] args) throws Exception {
		
		String sql = """
				insert into sample_products 
				(product_no, product_name, product_company, product_price) 
				values 
				(?, ?, ?, ?)
				""";
		
		Class.forName("oracle.jdbc.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hta", "zxcv1234");
		
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, 200);	// product_no -> number(4,0)	-- 정수
		pstmt.setString(2, "맥북 에어");	// product_name -> varchar2(255)	-- 가번길이 문자열
		pstmt.setString(3, "애플");	// product_company > varchar2(255)	-- 가변길이 문자열
		pstmt.setInt(4, 1500000);	// product_price -> number(7, 0)	-- 정수
		
		int rowCount = pstmt.executeUpdate();
		System.out.println(rowCount + "행이 추가되었습니다.");
		
		pstmt.close();
		connection.close();
	}
}