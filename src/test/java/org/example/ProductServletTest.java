package org.example;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import java.util.List;

public class ProductServletTest {
    @Test
    public void testDoGet() throws Exception {
        // Создание объекта ProductServlet
        ProductServlet productServlet = new ProductServlet();

        // Создание фиктивных объектов HttpServletRequest и HttpServletResponse
        HttpServletRequest request = new MockHttpServletRequest();
        HttpServletResponse response = new MockHttpServletResponse();

        // Вызов метода doGet
        productServlet.doGet(request, response);

        // Проверка, что атрибут "products" установлен в запросе
        List<Product> products = (List<Product>) request.getAttribute("products");
        assertEquals(false, products.isEmpty());
    }
}
