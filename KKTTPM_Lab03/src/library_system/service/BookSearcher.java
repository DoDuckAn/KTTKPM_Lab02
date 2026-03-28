package library_system.service;

import java.util.List;

import library_system.model.Book;

public class BookSearcher {
    public List<Book> search(List<Book> books, String keyword, SearchStrategy strategy) {
        if (keyword == null || keyword.isBlank()) {
            return books;
        }
        return strategy.search(books, keyword);
    }
}