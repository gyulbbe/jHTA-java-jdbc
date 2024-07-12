package demo4;

import java.sql.SQLException;
import java.util.List;

public class ProductDaoApp2 {

	public static void main(String[] args) throws SQLException {
		
		// 모든 책 조회
		ProductDao pDao = new ProductDao();
		List<Product> products = pDao.findAllProducts();
		
		if(products.isEmpty()) {
			System.out.println("상품이 존재하지 않습니다.");
		} else {
			for(Product p : products) {
				System.out.println(p.getNo() + ", " + p.getName() + ", " + p.getCompany() + ", " + p.getPrice() + ", " + p.getStock());
			}
		}
	}
}
