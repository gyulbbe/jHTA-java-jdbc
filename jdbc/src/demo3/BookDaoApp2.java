package demo3;

import java.sql.SQLException;
import java.util.List;

public class BookDaoApp2 {

	public static void main(String[] args) throws SQLException {
		
		// 모든 도서정보 조회해서 출력하기
		BookDao bookDao = new BookDao();
		
		List<Book> books = bookDao.findAllBooks();
		if(books.isEmpty()) {
			System.out.println("### 도서정보가 존재하지 않습니다.");
		} else {
			for(Book b : books) {
				System.out.println(b.getNo() + ", " + b.getTitle() + ", " + b.getAuthor());
			}
		}
	}
}
