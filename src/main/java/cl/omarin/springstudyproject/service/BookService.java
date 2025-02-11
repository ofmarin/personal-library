package cl.omarin.springstudyproject.service;

import cl.omarin.springstudyproject.model.Book;
import cl.omarin.springstudyproject.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class BookService {

    BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    public Book saveBook(Book book){
        return bookRepository.save(book);
    }

    public Book deleteBook(Long id){
        if(bookRepository.findById(id).isPresent()){
            Book toDelete = bookRepository.findById(id).get();
            bookRepository.deleteById(id);
            return toDelete;
        }

        throw new NoSuchElementException();

    }

    public Book findBook(Long id) {
        if (bookRepository.findById(id).isPresent()) {
            return bookRepository.findById(id).get();
        }else{
            throw new NoSuchElementException();
        }

    }
}
