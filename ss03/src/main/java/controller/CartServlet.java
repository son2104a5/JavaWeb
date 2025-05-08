package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Product;
import model.CartManager;

import java.io.IOException;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        CartManager cart = (CartManager) session.getAttribute("cart");
        if (cart == null) {
            cart = new CartManager();
            session.setAttribute("cart", cart);
        }

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));

        boolean exists = cart.getCart().stream().anyMatch(p -> Integer.parseInt(p.getId()) == id);

        if (exists) {
            request.setAttribute("message", "Sản phẩm đã tồn tại trong giỏ hàng.");
        } else {
            cart.addProduct(new Product(String.valueOf(id), name, price));
            request.setAttribute("message", "Đã thêm vào giỏ hàng.");
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("product.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        HttpSession session = request.getSession();
        CartManager cart = (CartManager) session.getAttribute("cart");
        if (cart != null) {
            cart.removeProduct(id);
        }
        response.sendRedirect("cart.jsp");
    }
}
