package cl.omarin.springstudyproject.controller;

import cl.omarin.springstudyproject.model.Book;
import cl.omarin.springstudyproject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService){
        this.bookService = bookService;
    }


    @GetMapping("")
    public ResponseEntity<List<Book>> getBooks(){
        return ResponseEntity.status(200).body(bookService.getBooks());
    }

    @PostMapping("")
    public EntityResponse<String> addBook(){

        return null;
    }
}
