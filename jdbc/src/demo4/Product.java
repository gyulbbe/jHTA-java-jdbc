package demo4;

import java.util.Date;

public class Product {

	private int no;
	private String name;
	private String company;
	private int price;
	private int stock;
	private String soldout;
	private Date createdDate;
	private Date updatedDate;
	private String deleted;
	
	public Product() {}

	public Product(int no, String name, String company, int price, int stock, String soldout, Date createdDate,
			Date updatedDate, String deleted) {
		this.no = no;
		this.name = name;
		this.company = company;
		this.price = price;
		this.stock = stock;
		this.soldout = soldout;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.deleted = deleted;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getSoldout() {
		return soldout;
	}

	public void setSoldout(String soldout) {
		this.soldout = soldout;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getDeleted() {
		return deleted;
	}

	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}

	@Override
	public String toString() {
		return "Product [no=" + no + ", name=" + name + ", company=" + company + ", price=" + price + ", stock=" + stock
				+ ", soldout=" + soldout + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate
				+ ", deleted=" + deleted + "]";
	}
}
