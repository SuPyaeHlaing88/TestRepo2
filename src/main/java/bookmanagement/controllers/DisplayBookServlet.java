package bookmanagement.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bookmanagement.models.Book;
import bookmanagement.persistance.BookReposistory;


@WebServlet("/books")
public class DisplayBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DisplayBookServlet() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookReposistory bookRespo = new BookReposistory();
		List<Book> books=bookRespo.getAll();
	
		
		request.setAttribute("books", books);
		request.getRequestDispatcher("display_books.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
