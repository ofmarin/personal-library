package cl.omarin.springstudyproject.controller;

import cl.omarin.springstudyproject.model.Book;
import cl.omarin.springstudyproject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@Restcontroller annotation includes @ResponseBody at class level
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
        return ResponseEntity.status(HttpStatus.OK).body(bookService.getBooks());
    }

    @PostMapping("")
    public ResponseEntity<Book> saveBook(@RequestBody Book book){
        return ResponseEntity.status(HttpStatus.OK).body(bookService.saveBook(book));
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(bookService.deleteBook(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findBook(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(bookService.findBook(id));
    }
}
