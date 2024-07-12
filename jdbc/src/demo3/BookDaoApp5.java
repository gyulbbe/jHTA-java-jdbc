package demo3;

import java.sql.SQLException;
import java.util.List;

public class BookDaoApp5 {

	public static void main(String[] args) throws SQLException {
		
		// 제목으로 검색
		BookDao bookDao = new BookDao();
		List<Book> book = bookDao.getBooksByTitle("자바");
		System.out.println("제목 검색");
		System.out.println(book);
		
		// 작성자로 검색
		List<Book> book2 = bookDao.getBooksByAuthor("남궁성");
		System.out.println("작성자 검색");
		System.out.println(book2);
		
		// 가격으로 검색
		List<Book> book3 = bookDao.getBooksByPrice(10000, 20000);
		System.out.println("가격 검색");
		System.out.println(book3);
	}
}
