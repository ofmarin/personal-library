package cl.omarin.springstudyproject.service;


import cl.omarin.springstudyproject.model.Book;
import cl.omarin.springstudyproject.repository.BookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @BeforeEach
    void setup() {
        bookService = new BookService(bookRepository);
    }

    @Test
    void shouldReturnEmptyList() {
        Mockito.when(bookRepository.findAll()).thenReturn(List.of());
        List<Book> result = bookService.getBooks();
        Assertions.assertTrue(result.isEmpty());
    }

    //add book then get list again
    @Test
    void shouldAddBookAndReturnListWithOneBook() {
        Book book = new Book(0L, "It", "Stephen King", 1181, "2019");
        Mockito.when(bookRepository.save(book)).thenReturn(book);

        Book actual = bookService.saveBook(book);
        Assertions.assertEquals(book, actual);

        List<Book> expectedList = List.of(book);
        Mockito.when(bookRepository.findAll()).thenReturn(expectedList);
        List<Book> actualList = bookService.getBooks();

        Assertions.assertFalse(actualList.isEmpty());
        Assertions.assertEquals(1, actualList.size());
        Assertions.assertEquals(expectedList, actualList);


    }


    @Test
    void shouldRemoveBook() {
        Book expectedBook = new Book(0L, "It", "Stephen King", 1181, "2019");

        Mockito.doNothing().when(bookRepository).deleteById(expectedBook.getId());


        bookService.deleteBook(expectedBook.getId());

        Mockito.verify(bookRepository, Mockito.times(1)).deleteById(expectedBook.getId());


    }
}
