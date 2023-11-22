package org.example;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.List;

public class ProductLoaderTest {
    @Test
    public void testLoadProducts() {
        //путь к тестовому XML-файлу
        String filePath = "src/test/resources/test-products.xml";

        // Вызов метода loadProducts
        List<Product> products = ProductLoader.loadProducts(filePath);

        // Проверка, что список продуктов не пустой
        assertEquals("Product list should not be empty", false, products.isEmpty());
    }
}
