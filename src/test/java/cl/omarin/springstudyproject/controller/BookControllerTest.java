package cl.omarin.springstudyproject.controller;

import cl.omarin.springstudyproject.model.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import cl.omarin.springstudyproject.service.BookService;
import org.springframework.http.HttpStatus;
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
        Mockito.when(bookService.getBooks()).thenReturn(List.of());
        List<Book> expectedList = List.of();

        //ResponseEntity<List<Book>> expectedResponse = ResponseEntity.status(HttpStatus.OK).body(expectedList);
        ResponseEntity<List<Book>> actualResponse = bookController.getBooks();

        Assertions.assertEquals(HttpStatus.OK, actualResponse.getStatusCode());
        Assertions.assertEquals(expectedList, actualResponse.getBody());
    }

    @Test
    void shouldReturnStatusOkAndSavedBook(){
        Book expectedBook = new Book(0L, "It", "Stephen King", 1181, "2019");
        Mockito.when(bookService.saveBook(expectedBook)).thenReturn(expectedBook);

        ResponseEntity<Book> actualResponse = bookController.addBook(expectedBook);

        Assertions.assertEquals(HttpStatus.OK, actualResponse.getStatusCode());
        Assertions.assertEquals(expectedBook, actualResponse.getBody());
    }

    @Test
    void shouldReturnListWith1Book(){
        Book book = new Book(0L, "It", "Stephen King", 1181, "2019");
        Mockito.when(bookService.getBooks()).thenReturn(List.of(book));

        List<Book> expectedList = List.of(book);
        List<Book> actualList = bookController.getBooks().getBody();

        Assertions.assertFalse(actualList.isEmpty());
        Assertions.assertEquals(expectedList,actualList);
    }
}
