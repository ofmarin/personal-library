package cl.omarin.springstudyproject.controller;

import cl.omarin.springstudyproject.model.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import cl.omarin.springstudyproject.service.BookService;
import org.springframework.http.ResponseEntity;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class BookControllerTest {

    @Mock
    BookService bookService;

    @InjectMocks
    private BookController bookController;


    @BeforeEach
    void setup(){
        bookController = new BookController(bookService);
    }

    @Test
    void shouldReturnEmptyBookList(){
        List<Book> expected = List.of();
        ResponseEntity<List<Book>> actual = bookController.getBooks();
        
    }
}
