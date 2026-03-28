package library_system.repository;

import java.util.List;
import java.util.Optional;

import library_system.model.Book;

public interface LibraryRepository {
    List<Book> findAll();
    Optional<Book> findById(String id);
    void save(Book book);
}