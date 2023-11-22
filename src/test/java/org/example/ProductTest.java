package org.example;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ProductTest {
    @Test
    public void testProductGettersAndSetters() {
        // Создание объекта Product
        Product product = new Product();

        // Установка значений с использованием сеттеров
        product.setName("TestProduct");
        product.setPrice(100.0);
        product.setCategory("TestCategory");
        product.setQuantity(5);

        // Проверка значений с использованием геттеров
        assertEquals("TestProduct", product.getName());
        assertEquals(100.0, product.getPrice(), 0.001);
        assertEquals("TestCategory", product.getCategory());
        assertEquals(5, product.getQuantity());
    }
}
