package demo4;

import java.sql.SQLException;
import java.util.List;

public class ProductDaoApp3 {

	public static void main(String[] args) throws SQLException {
		
		// 번호로 상품 조회
		ProductDao pDao = new ProductDao();
		Product product = pDao.getProductByNo(100);
		System.out.println(product);
	}
}
