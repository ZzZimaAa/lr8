package org.example;

import org.example.Product;
import org.example.ProductLoader;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = ProductLoader.loadProducts("F:\\ProgSP\\lr8\\src\\main\\webapp\\products.xml");
        request.setAttribute("products", products);

        RequestDispatcher dispatcher = request.getRequestDispatcher("src/main/webapp/products.jsp");
        dispatcher.forward(request, response);
    }
}