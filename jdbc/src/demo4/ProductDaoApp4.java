package demo4;

import java.sql.SQLException;

public class ProductDaoApp4 {

	public static void main(String[] args) throws SQLException {
		
		// 번호로 상품 삭제
		ProductDao pDao = new ProductDao();
		pDao.deleteProductByNo(100);
	}
}