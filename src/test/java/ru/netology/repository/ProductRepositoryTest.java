package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.TShirt;
import ru.netology.exception.NotFoundException;
import ru.netology.manager.ProductManager;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    private ProductRepository repository = new ProductRepository();
    private Product first = new Product(1, "XX", 100);
    private Book second = new Book(2, "Прованс", 150, "Мейл", 300, 2010);
    private TShirt third = new TShirt(3, "Lacoste", 200, "green", "medium");

    @BeforeEach
    public void setUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
    }

    @Test
    public void shouldRemoveIfExists() {
        repository.removeById(2);

        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{first, third};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveIfNotExists() {

        assertThrows(NotFoundException.class, () -> repository.removeById(7));
    }
}