package bookmanagement.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookmanagement.models.Book;
import bookmanagement.persistance.BookReposistory;

@WebServlet("/addbook")
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("add_book.jsp").forward(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Book book=new Book();
		book.setCode(request.getParameter("code"));
		book.setName(request.getParameter("name"));
		String priceStr=request.getParameter("price");
		
		book.setAuthor(request.getParameter("author"));
		
		if(book.getCode().equals("") || book.getName().equals("")|| priceStr.equals("")||book.getAuthor().equals("")) {
			String error="";
			if(book.getCode().equals("")) {
				error+="Code Field is required <br>";
			}
			if(book.getName().equals("")) {
				error+="Name Field is required <br>";
			}
			if(priceStr.equals("")) {
				error+="Price Field is required <br>";
			}else {
				book.setPrice(Double.parseDouble(priceStr));
			}
			if(book.getAuthor().equals("")) {
				error+="Author Field is required <br>";
			}
			request.setAttribute("book",book);
			request.setAttribute("error_msg", error);
			request.getRequestDispatcher("add_book.jsp").forward(request, response);
			
		}else {
			book.setPrice(Double.parseDouble(priceStr));
			
			BookReposistory bookRepo = new BookReposistory();
			int rs=bookRepo.add(book);
			if(rs==0) {
				request.setAttribute("book",book);
				request.setAttribute("error_msg", "SQL Insert Error: ");
				request.getRequestDispatcher("add_book.jsp").forward(request, response);
			}else {
				response.sendRedirect("books");
			}
			
//			response.sendRedirect("books");
			
		}	
	}

}
