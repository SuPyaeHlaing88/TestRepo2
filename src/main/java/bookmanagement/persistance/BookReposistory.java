package bookmanagement.persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmanagement.models.Book;

public class BookReposistory {
	//connection
	public static Connection con=null;
	static {
		con = MyConnection.getConnection();
	}
	
	//crud
	//create
	public int add(Book book) {
		int result=0;
		String sql="INSERT INTO book(code,name,author,price) VALUES(?,?,?,?)";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, book.getCode());
			ps.setString(2, book.getName());
			ps.setString(3, book.getAuthor());
			ps.setDouble(4, book.getPrice());
			
			result = ps.executeUpdate();
//			ps.close();
			
		}catch(SQLException e) {
			result=0;
		}
		return result;
	}
	//Update
		public int edit(Book book) {
			int result=0;
			String sql="UPDATE book SET name=?, author=?, price=? where code=?";
			try {
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1, book.getName());
				ps.setString(2, book.getAuthor());
				ps.setDouble(3, book.getPrice());
				ps.setString(4, book.getCode());
				
				result = ps.executeUpdate();
//				ps.close();
				
			}catch(SQLException e) {
				result=0;
			}
			return result;
		}
	//delete
		public int delete(String code) {
			int result=0;
			String sql="DELETE FROM book WHERE code=?";
			try {
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1,code);
				
				result = ps.executeUpdate();
//				ps.close();
				
			}catch(SQLException e) {
				result=0;
				System.out.println("book delete err: "+e);
			}
			return result;
		}
		//getAll
		public List<Book>getAll(){
			List<Book> books=new ArrayList<>();
			String sql="SELECT * FROM BOOK";
			try {
				PreparedStatement ps=con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					Book book = new Book();
					book.setCode(rs.getString("code"));
					book.setName(rs.getString("name"));
					book.setAuthor(rs.getString("author"));
					book.setPrice(rs.getDouble("price"));
					books.add(book);
				}
//				ps.close();
			}catch(SQLException e) {
				System.out.println("book select err: "+e);
			}
			return books;
		}
		//getOne တစ်ခုပဲ return ပြန်မှာ
		public Book getByCode(String code) {
			Book book = null;
			String sql = "SELECT * FROM book WHERE code=?";
			try {
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1,code);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					book = new Book();
					book.setCode(rs.getString("code"));
					book.setName(rs.getString("name"));
					book.setAuthor(rs.getString("author"));
					book.setPrice(rs.getDouble("price"));
				}
//				ps.close();
				
			}catch(SQLException e) {
				book = null;
				System.out.println("book edit err: "+e);
			}
			return book;
		}
}

