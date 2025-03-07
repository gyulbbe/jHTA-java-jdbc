package demo3;

import java.util.Date;

public class Book {

	private int no;
	private String title;
	private String author;
	private String publisher;
	private int price;
	private double discountRate;
	private int stock;
	private String status;
	private Date createdDate;
	private Date updatedDate;
	
	public Book() {}

	public Book(int no, String title, String author, String publisher, int price, double discountRate, int stock,
			String status, Date createdDate, Date updatedDate) {
		this.no = no;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.discountRate = discountRate;
		this.stock = stock;
		this.status = status;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public double getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(double discountRate) {
		this.discountRate = discountRate;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	@Override
	public String toString() {
		return "Book [no=" + no + ", title=" + title + ", author=" + author + ", publisher=" + publisher + ", price="
				+ price + ", discountRate=" + discountRate + ", stock=" + stock + ", status=" + status
				+ ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + "]";
	}
}