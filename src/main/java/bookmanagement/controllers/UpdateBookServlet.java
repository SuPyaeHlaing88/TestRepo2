package bookmanagement.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookmanagement.models.Book;
import bookmanagement.persistance.BookReposistory;

@WebServlet("/editbook")
public class UpdateBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code=request.getParameter("code");
		Book book=new Book();
		
		BookReposistory bookRepo = new BookReposistory();
		book=bookRepo.getByCode(code);
		
		request.setAttribute("book", book);
		request.getRequestDispatcher("edit_book.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Book updateBook=new Book();
		updateBook.setCode(request.getParameter("code"));
		updateBook.setName(request.getParameter("name"));
		String priceStr=request.getParameter("price");
		
		updateBook.setAuthor(request.getParameter("author"));
		
		if(updateBook.getCode().equals("") || updateBook.getName().equals("")|| priceStr.equals("")||updateBook.getAuthor().equals("")) {
			String error="";
			if(updateBook.getCode().equals("")) {
				error+="Code Field is required <br>";
			}
			if(updateBook.getName().equals("")) {
				error+="Name Field is required <br>";
			}
			if(priceStr.equals("")) {
				error+="Price Field is required <br>";
			}else {
				updateBook.setPrice(Double.parseDouble(priceStr));
			}
			if(updateBook.getAuthor().equals("")) {
				error+="Author Field is required <br>";
			}
			request.setAttribute("book",updateBook);
			request.setAttribute("error_msg", error);
			request.getRequestDispatcher("edit_book.jsp").forward(request, response);
			
		}else {
			updateBook.setPrice(Double.parseDouble(priceStr));
			
			BookReposistory bookRepo = new BookReposistory();
			int rs=bookRepo.edit(updateBook);
			if(rs==0) {
				request.setAttribute("book",updateBook);
				request.setAttribute("error_msg", "SQL Update Error: ");
				request.getRequestDispatcher("edit_book.jsp").forward(request, response);
			}else {
				response.sendRedirect("books");
			}
			
		}
		
	}

}
