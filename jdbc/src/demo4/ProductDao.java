package demo4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utils.ConnectionUtils;

public class ProductDao {

	// 키워드로 상품조회
	public List<Product> getProdutsByKeyword(String keyword) throws SQLException{
		// 1. sql
		
		// 2. 연결
		
		// 3. ?에 값 넣기
		
		// 4. sql 전송하여 rs에 담기
		
		// 5. 닫기 및 반환
	}
	
	// 모든 상품 삭제
	public void deleteAllProducts() {
		// 1. sql
		
		// 2. 연결
		
		// 3. 닫기
	}
	
	public void deleteProductByNo(int no) throws SQLException {
		// 1. sql문
		String sql = """
				update sample_products 
				set PRODUCT_DELETED = 'Y' 
				where PRODUCT_NO = ?
			""";
		
		// 2. 연결
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		// 3. ?에 값 넣기
		pstmt.setInt(1, no);
		
		// 4. 보내기
		pstmt.executeUpdate();
		
		// 5. 닫기
		pstmt.close();
		con.close();
	}
	
	/**
	 * 번호로 상품 객체를 반환한다.
	 * @param no
	 * @return Product
	 */
	public Product getProductByNo(int no) throws SQLException {
		// 1. sql문
		String sql = """
				select * 
				from sample_products 
				where product_no = ?
			""";
		
		// 2. 연결
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		// 3. ?에 값 담기
		pstmt.setInt(1, no);
		
		// 4. sql문 보내고 rs에 담기
		ResultSet rs = pstmt.executeQuery();
		Product product = null;
		
		// 5. rs
		while(rs.next()) {
			product = new Product();
			product.setNo(rs.getInt("product_no"));
			product.setName(rs.getString("product_name"));
			product.setCompany(rs.getString("PRODUCT_COMPANY"));
			product.setPrice(rs.getInt("PRODUCT_PRICE"));
			product.setStock(rs.getInt("PRODUCT_STOCK"));
		}
		
		// 6. 닫기 및 반환
		rs.close();
		pstmt.close();
		con.close();
		
		return product;
	}
	
	/**
	 * 모든 상품 반환
	 * @return 모든 상품 리스트에 담아 반환
	 */
	public List<Product> findAllProducts() throws SQLException {
		// 1. sql문
		String sql = """
				select * 
				from sample_products 
				order by product_no desc
			""";
		
		// 2. 연결
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		// 3. resultSet에 담기
		ResultSet rs = pstmt.executeQuery();
		
		// 4. 그릇 생성
		List<Product> products = new ArrayList<Product>();
		
		// 5. while문으로 반환하기
		while (rs.next()) {
			Product product = new Product();
			product.setNo(rs.getInt("PRODUCT_NO"));
			product.setName(rs.getString("PRODUCT_NAME"));
			product.setCompany(rs.getString("PRODUCT_COMPANY"));
			product.setPrice(rs.getInt("PRODUCT_PRICE"));
			product.setStock(rs.getInt("PRODUCT_STOCK"));
			product.setSoldout(rs.getString("PRODUCT_SOLDOUT"));
			product.setCreatedDate(rs.getDate("PRODUCT_CREATED_DATE"));
			product.setUpdatedDate(rs.getDate("PRODUCT_UPDATED_DATE"));
			product.setDeleted(rs.getString("PRODUCT_DELETED"));
			
			products.add(product);
		}
		
		// 6. 닫기
		rs.close();
		pstmt.close();
		con.close();
		
		return products;
	}
	
	/**
	 * 책 등록
	 * @throws SQLException
	 */
	public void insertProduct(Product product) throws SQLException {
		// 1. sql문 작성
		String sql = """
				insert into sample_products (
				PRODUCT_NO
				, PRODUCT_NAME
				, PRODUCT_COMPANY
				, PRODUCT_PRICE
				, PRODUCT_STOCK)
				values (?, ?, ?, ?, ?)
			""";
		
		
		// 2. 연결
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		// 3. ?에 값 넣기
		pstmt.setInt(1, product.getNo());
		pstmt.setString(2, product.getName());
		pstmt.setString(3, product.getCompany());
		pstmt.setInt(4, product.getPrice());
		pstmt.setInt(5, product.getStock());
		
		// 4. 보내기
		pstmt.executeUpdate();
		
		// 5. 닫기
		pstmt.close();
		con.close();
	}
}
