package demo4;

import java.sql.SQLException;

public class ProductDaoApp1 {

	public static void main(String[] args) throws SQLException {
		
		// 책 등록
		ProductDao pDao = new ProductDao();
		Product product = new Product();
		
		int no = 100;
		String name = "삼성 노트북";
		String company = "삼성";
		int price = 1000000;
		int stock = 50;
		
		product.setNo(no);
		product.setName(name);
		product.setCompany(company);
		product.setPrice(price);
		product.setStock(stock);
		
		pDao.insertProduct(product);
	}
}
