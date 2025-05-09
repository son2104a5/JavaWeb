package demo.ss04;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Product;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1, "Laptop", 1500));
        productList.add(new Product(2, "Smartphone", 800));
        productList.add(new Product(3, "Tablet", 500));

        req.setAttribute("productList", productList);
        req.getRequestDispatcher("/productList.jsp").forward(req, resp);
    }
}
