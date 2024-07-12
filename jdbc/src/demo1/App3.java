package demo1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utils.ConnectionUtils;

public class App3 {

	public static void main(String[] args) throws SQLException {
		
		String sql = """
				select product_no, product_name, product_company, product_price 
				from sample_products 
				order by product_no desc
				""";
		
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		/*
		 * ResultSet
		 * - SELECT구문 조회결과를 담고 있고, 조회결과를 처리하는 기능이 제공된다.
		 */
		ResultSet rs = pstmt.executeQuery();
		
		/*
		 * boolean next()
		 * - ResultSet 객체에 내장된 커서를 이동시키는 메소드다.
		 * - next() 메소드를 실행하면 커서가 한 행 아래로 이동한다.
		 * - 해당 위치에 데이터 행이 존재하면 true를 반환한다.
		 * - 조회결과를 모두 처리하기 위해서는 커서를 한 행씩 아래로 이동시키면서 커서가 위치한 행에서 데이터를 뽑는다.
		 */
		while (rs.next()) {
			int value1 = rs.getInt("product_no");
			String value2 = rs.getString("product_name");
			String value3 = rs.getString("product_company");
			int value4 = rs.getInt("product_price");
			
			System.out.println(value1 + ", " + value2 + ", " + value3 + ", " + value4);
		}
		
		rs.close();
		pstmt.close();
		con.close();
	}
}