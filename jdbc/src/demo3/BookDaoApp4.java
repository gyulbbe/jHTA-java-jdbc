package demo3;

import java.sql.SQLException;

public class BookDaoApp4 {

	public static void main(String[] args) throws SQLException {
		
		// 책정보 수정하기
		// 가격만 변경하기
		int bookNo = 1000;
		int newPrice = 11500;
		
		BookDao bookDao = new BookDao();
		Book book = bookDao.getBookByNo(bookNo);
		System.out.println("변경 전 책정보");
		System.out.println(book);
		
		// 변경된 가격을 Book객체 반영
		book.setPrice(newPrice);
		System.out.println("변경 후 책정보");
		System.out.println(book);
		
		// 변경된 가격이 반영된 Book객체를 전달해서 테이블의 정보를 수정시킨다.
		bookDao.updateBook(book);
		
		// 책정보 수정하기
		// 재고수량 =0, 도서상태 = 절판
		bookNo = 1000;
		
		// 변경 전 정보 조회
		Book book2 = bookDao.getBookByNo(bookNo);
		System.out.println("수정 전 도서정보 : " + book2);
		
		// 수량 과 상태를 Book객체에 반영
		book2.setStock(0);
		book2.setStatus("절판");
		
		// 수정된 수량과 상태가 반영된 Book객체를 전달해서 테이블의 정보를 수정한다.
		bookDao.updateBook(book2);
	}
}