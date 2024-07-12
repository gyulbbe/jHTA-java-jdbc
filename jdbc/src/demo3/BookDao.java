package demo3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utils.ConnectionUtils;

/*
 * SAMPLE_BOOKS 테이블에 대한 CRUD 작업이 구현된 클래스
 * 
 * - 신규 도서 추가 기능
 * 	+ 반환타입: void
 * 	+ 매개변수: Book book
 * 	+ 메소드명: insertBook
 * 
 * - 전체 도서 조회 기능
 *  + 반환타임: List<Book>
 *  + 매개변수: 없음
 *  + 메소드명: findAllBooks
 *  
 * - 특정 도서 조회 기능
 *  + 반환타입: Book
 *  + 매개변수: int bookNo
 *  + 메소드명: getBookByNo
 *  
 * - 도서 정보 변경 기능
 *  + 반환타입: void
 *  + 매개변수: Book book
 *  + 메소드명: updateBook
 *  
 * - 도서 정보 삭제 기능
 *  + 반환타입: void
 *  + 매개변수: int bookNo
 *  + 메소드명: deleteBookByNo
 *  
 * - 도서 정보 제목으로 검색 기능
 *  + 반환타입: List<Book>
 *  + 매개변수: String title
 *  + 메소드명: getBookByTitle
 *  
 *  - 도서 정보 저자로 검색 기능
 *  + 반환타입: List<Book>
 *  + 매개변수: String author
 *  + 메소드명: getBookByAuthor
 *  
 *  - 도서 정보 출판사으로 검색 기능
 *  + 반환타입: List<Book>
 *  + 매개변수: String publisher
 *  + 메소드명: getBookByPublisher
 *  
 *  - 도서 정보 가격으로 검색 기능
 *  + 반환타입: List<Book>
 *  + 매개변수: int minPrice, int maxPrice
 *  + 메소드명: getBookByPrice
 */
public class BookDao {
	
	/**
	 * 신규 도서정보를 전달받아서 테이블에 저장시킨다.
	 * @param book 신규 도서 정보
	 * @throws SQLException 
	 */
	public void insertBook(Book book) throws SQLException {
		 String sql = """
		 		insert into sample_books 
		 		(book_no, book_title, book_author, book_publisher, book_price, book_discount_rate, book_stock) 
		 		values 
		 		(?, ?, ?, ?, ?, ?, ?)
		 		""";
		 
		 Connection con = ConnectionUtils.getConnection();
		 PreparedStatement pstmt = con.prepareStatement(sql);
		 pstmt.setInt(1, book.getNo());
		 pstmt.setString(2, book.getTitle());
		 pstmt.setString(3, book.getAuthor());
		 pstmt.setString(4, book.getPublisher());
		 pstmt.setInt(5, book.getPrice());
		 pstmt.setDouble(6, book.getDiscountRate());
		 pstmt.setInt(7, book.getStock());
		 
		 pstmt.executeUpdate();
		 
		 pstmt.close();
		 con.close();
	}
	
	/**
	 * 테이블에 저장된 모든 도서정보를 반환한다.
	 * @return 도서정보 목록
	 * @throws SQLException
	 */
	public List<Book> findAllBooks() throws SQLException {
		String sql = """
				select book_no, book_title, book_author, book_publisher, book_price, book_discount_rate, book_stock, book_status, book_created_date, book_updated_date 
				from sample_books 
				order by book_no desc
				""";
		
		List<Book> books = new ArrayList<Book>();
		
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
//			int no = rs.getInt("book_no");
//			String title = rs.getString("book_title");
//			String author = rs.getString("book_author");
//			String publisher = rs.getString("book_publisher");
//			int price = rs.getInt("book_price");
//			double discountRate = rs.getDouble("book_discount_rate");
//			int stock = rs.getInt("book_stock");
//			String status = rs.getString("book_status");
//			Date createdDate = rs.getDate("book_created_date");
//			Date updatedDate = rs.getDate("book_updated_date");
			
			Book book = new Book();
			book.setNo(rs.getInt("book_no"));
			book.setTitle(rs.getString("book_title"));
			book.setAuthor(rs.getString("book_author"));
			book.setPublisher(rs.getString("book_publisher"));
			book.setPrice(rs.getInt("book_price"));
			book.setDiscountRate(rs.getDouble("book_discount_rate"));
			book.setStock(rs.getInt("book_stock"));
			book.setStatus(rs.getString("book_status"));
			book.setCreatedDate(rs.getDate("book_created_date"));
			book.setUpdatedDate(rs.getDate("book_updated_date"));
			
			books.add(book);
		}
		
		rs.close();
		pstmt.close();
		con.close();
		
		return books;
	}
	
	/**
	 * 책번호를 전달받아서 해당 책정보를 반환한다.
	 * @param bookNo 조회할 책 번호
	 * @return 책정보, null이 반환될 수 있다.
	 * @throws SQLException
	 */
	public Book getBookByNo(int bookNo) throws SQLException {
		String sql = """
				select * 
				from sample_books 
				where book_no = ?
				""";
		
		Book book = null;
		
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, 1000);
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			book = new Book();
			
			book.setNo(rs.getInt("book_no"));
			book.setTitle(rs.getString("book_title"));
			book.setAuthor(rs.getString("book_author"));
			book.setPublisher(rs.getString("book_publisher"));
			book.setPrice(rs.getInt("book_price"));
			book.setDiscountRate(rs.getDouble("book_discount_rate"));
			book.setStock(rs.getInt("book_stock"));
			book.setStatus(rs.getString("book_status"));
			book.setCreatedDate(rs.getDate("book_created_date"));
			book.setUpdatedDate(rs.getDate("book_updated_date"));
		}
		
		rs.close();
		pstmt.close();
		con.close();
		
		return book;
	}
	
	/**
	 * 변경된 도서정보를 전달받아서 해당 도서정보를 바꾼다.
	 * @param book 변경된 도서정보
	 * @throws SQLException
	 */
	public void updateBook(Book book) throws SQLException {
		String sql = """
				update sample_books 
				set book_title = ?
					, book_author = ?
					, book_publisher = ?
					, book_price = ?
					, book_discount_rate = ?
					, book_stock = ?
					, book_status = ?
					, book_updated_date = sysdate 
				where book_no = ?
			""";
		
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, book.getTitle());
		pstmt.setString(2, book.getAuthor());
		pstmt.setString(3, book.getPublisher());
		pstmt.setInt(4, book.getPrice());
		pstmt.setDouble(5, book.getDiscountRate());
		pstmt.setInt(6, book.getStock());
		pstmt.setString(7, book.getStatus());
		pstmt.setInt(8, book.getNo());
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
	}
	
	/**
	 * 
	 * @param no
	 * @throws SQLException
	 */
	public void deleteBookByNo(int no) throws SQLException {
		String sql = """
				delete from sample_books 
				where book_no = ?
				""";
		
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, no);
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
	}
	
	public List<Book> getBooksByTitle(String keyword) throws SQLException {
		
		// 1. sql문
		String sql = """
				select * 
				from sample_books 
				where book_title like '%' || ? || '%'
			""";
		
		// 2. 연결
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		// 3. ?에 값 넣기
		pstmt.setString(1, keyword);
		
		ResultSet rs = pstmt.executeQuery();
		
		// 4. 담을 리스트 생성
		List<Book> books = new ArrayList<Book>();
		
		while(rs.next()) {
			Book book = new Book();
			book.setNo(rs.getInt("book_no"));
			book.setTitle(rs.getString("book_title"));
			book.setAuthor(rs.getString("book_author"));
			book.setPublisher(rs.getString("book_publisher"));
			book.setPrice(rs.getInt("book_price"));
			book.setDiscountRate(rs.getDouble("book_discount_rate"));
			book.setStock(rs.getInt("book_stock"));
			book.setStatus(rs.getString("book_status"));
			book.setCreatedDate(rs.getDate("book_created_date"));
			book.setUpdatedDate(rs.getDate("book_updated_date"));
			
			// 5. 리스트에 책 넣기
			books.add(book);
		}
		
		// 6. 닫기 및 반환
		rs.close();
		pstmt.close();
		con.close();
		return books;
	}
	
	public List<Book> getBooksByAuthor(String author) throws SQLException {
		String sql = """
				select * 
				from sample_books 
				where book_author = ?
			""";
		
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, author);
		
		ResultSet rs = pstmt.executeQuery();
		
		List<Book> books = new ArrayList<Book>();
		
		while(rs.next()) {
			Book book = new Book();
			book.setNo(rs.getInt("book_no"));
			book.setTitle(rs.getString("book_title"));
			book.setAuthor(rs.getString("book_author"));
			book.setPublisher(rs.getString("book_publisher"));
			book.setPrice(rs.getInt("book_price"));
			book.setDiscountRate(rs.getDouble("book_discount_rate"));
			book.setStock(rs.getInt("book_stock"));
			book.setStatus(rs.getString("book_status"));
			book.setCreatedDate(rs.getDate("book_created_date"));
			book.setUpdatedDate(rs.getDate("book_updated_date"));
			
			books.add(book);
		}
		
		rs.close();
		pstmt.close();
		con.close();
		return books;
	}
	
	public List<Book> getBooksByPrice(int min, int max) throws SQLException {
		String sql = """
				select * 
				from sample_books 
				where book_price between ? and ?
			""";
		
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setInt(1, min);
		pstmt.setInt(2, max);
		
		ResultSet rs = pstmt.executeQuery();
		
		List<Book> books = new ArrayList<Book>();
		
		while(rs.next()) {
			Book book = new Book();
			book.setNo(rs.getInt("book_no"));
			book.setTitle(rs.getString("book_title"));
			book.setAuthor(rs.getString("book_author"));
			book.setPublisher(rs.getString("book_publisher"));
			book.setPrice(rs.getInt("book_price"));
			book.setDiscountRate(rs.getDouble("book_discount_rate"));
			book.setStock(rs.getInt("book_stock"));
			book.setStatus(rs.getString("book_status"));
			book.setCreatedDate(rs.getDate("book_created_date"));
			book.setUpdatedDate(rs.getDate("book_updated_date"));
			
			books.add(book);
		}
		
		rs.close();
		pstmt.close();
		con.close();
		return books;
	}
}