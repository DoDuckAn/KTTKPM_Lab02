package library_system.service;

import java.util.List;

import library_system.model.Book;

public interface SearchStrategy {
    List<Book> search(List<Book> books, String keyword);
}