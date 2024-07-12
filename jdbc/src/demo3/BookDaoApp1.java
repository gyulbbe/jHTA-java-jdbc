package demo3;

import java.sql.SQLException;
import java.util.List;

public class BookDaoApp1 {

	public static void main(String[] args) throws SQLException {
		
		// 신규 도서 등록하기
		Book book = new Book();
		book.setNo(1001);
		book.setTitle("ETS 토익 정기시험 기출문제집");
		book.setAuthor("ETS");
		book.setPublisher("YBM");
		book.setPrice(19800);
		book.setDiscountRate(0.1);
		book.setStock(100);
		
		BookDao bookDao = new BookDao();
		bookDao.insertBook(book);
	}
	
	
}