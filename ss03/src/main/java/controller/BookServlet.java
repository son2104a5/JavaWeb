package controller;

import model.Book;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/book")
public class BookServlet extends HttpServlet {
    private ArrayList<Book> bookList;

    @Override
    public void init() throws ServletException {
        bookList = new ArrayList<>();
        getServletContext().setAttribute("books", bookList);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String title = req.getParameter("title");
        String author = req.getParameter("author");
        int year = Integer.parseInt(req.getParameter("year"));

        Book newBook = new Book(title, author, year);
        bookList.add(newBook);

        resp.sendRedirect("home.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String keyword = req.getParameter("search");
        ArrayList<Book> filtered = new ArrayList<>();

        if (keyword != null && !keyword.isEmpty()) {
            for (Book b : bookList) {
                if (b.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                    filtered.add(b);
                }
            }
        }

        req.setAttribute("result", filtered);
        req.getRequestDispatcher("result.jsp").forward(req, resp);
    }
}
