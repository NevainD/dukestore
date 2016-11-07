package demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BookCatalogServlet", urlPatterns = "/bookcatalog")
public class BookCatalogServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            BookDBAO db = new BookDBAO();
            List books = db.getAllBook();
            // store bookdetails object in request scope with attribut name "book"
            // bookdetails.jsp will retrieve this stored object later to display the content
            request.setAttribute("books", books);
            // forward the request to bookdetails.jsp, there must be a "/" before the web resource reference
            getServletContext().getRequestDispatcher("/catalog.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }
}