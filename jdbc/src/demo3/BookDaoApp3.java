package demo3;

import java.sql.SQLException;

public class BookDaoApp3 {

	public static void main(String[] args) throws SQLException {
		
		// 책번호로 책정보 조회하기
		BookDao bookDao = new BookDao();
		
		Book book1 = bookDao.getBookByNo(200);
		if (book1 != null) {
			System.out.println(book1.getTitle());
		} else {
			System.out.println("책 정보가 존재하지 않습니다.");
		}
		
		Book book2 = bookDao.getBookByNo(1000);
		if (book2 != null) {
			System.out.println(book2.getTitle());
		} else {
			System.out.println("책 정보가 존재하지 않습니다.");
		}
		
		Book book3 = bookDao.getBookByNo(1001);
		if (book3 != null) {
			System.out.println(book3.getTitle());
		} else {
			System.out.println("책 정보가 존재하지 않습니다.");
		}
	}
}