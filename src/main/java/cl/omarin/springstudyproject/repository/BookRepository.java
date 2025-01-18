package cl.omarin.springstudyproject.repository;

import cl.omarin.springstudyproject.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    //add custom methods here
    List<Book> findByAuthor(String author);
    Book findByTitle(String title);
}
