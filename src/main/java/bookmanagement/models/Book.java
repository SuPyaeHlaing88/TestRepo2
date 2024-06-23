package bookmanagement.models;

public class Book {
	private String code;
	private String name;
	private double price;
	private String author;
	
	public Book() {
		
	}
	public Book(String code,String name,double price,String author) {
		this.code=code;
		this.name=name;
		this.price=price;
		this.author=author;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String toString() {
		return this.code + " : " + this.name +" : "+this.price+" $ "+this.author;
	}

}
