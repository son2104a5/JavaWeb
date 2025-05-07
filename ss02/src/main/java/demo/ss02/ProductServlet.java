package demo.ss02;

import demo.ss02.model.Product;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/products")
public class ProductServlet extends HttpServlet {
    private final List<Product> productList = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        List<Product> productList = (List<Product>) getServletContext().getAttribute("productList");
        if (productList == null) {
            productList = new ArrayList<>();
            getServletContext().setAttribute("productList", productList);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("products", productList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("productList.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("update".equals(action)) {
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            String priceStr = request.getParameter("price");

            String error = null;

            // Validate
            if (name == null || name.trim().isEmpty()) {
                error = "Tên không được để trống";
            } else if (priceStr == null || !priceStr.matches("\\d+(\\.\\d{1,2})?")) {
                error = "Giá không hợp lệ";
            }

            if (error != null) {
                request.setAttribute("error", error);
                request.setAttribute("id", id);
                request.setAttribute("name", name);
                request.setAttribute("price", priceStr);
                request.getRequestDispatcher("updateProduct.jsp").forward(request, response);
                return;
            }

            double price = Double.parseDouble(priceStr);
            List<Product> list = (List<Product>) getServletContext().getAttribute("productList");

            for (Product p : list) {
                if (p.getId() == Integer.parseInt(id)) {
                    p.setName(name);
                    p.setPrice(price);
                    break;
                }
            }

            response.sendRedirect("productList.jsp");
        }

        if ("delete".equals(action)) {
            String id = request.getParameter("id");

            List<Product> list = (List<Product>) getServletContext().getAttribute("productList");

            boolean found = false;
            Iterator<Product> iterator = list.iterator();
            while (iterator.hasNext()) {
                Product p = iterator.next();
                if (p.getId() == Integer.parseInt(id)) {
                    iterator.remove();
                    found = true;
                    break;
                }
            }

            if (found) {
                request.setAttribute("message", "Xóa sản phẩm thành công!");
            } else {
                request.setAttribute("message", "Không tìm thấy sản phẩm cần xóa!");
            }

            request.setAttribute("products", list);
            request.getRequestDispatcher("productList.jsp").forward(request, response);
        }

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));

        Product newProduct = new Product(id, name, price);
        productList.add(newProduct);

        response.sendRedirect("products");
    }
}
