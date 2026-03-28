package library_system.service;

import java.util.ArrayList;
import java.util.List;

import library_system.model.Book;

public class SearchByAuthor implements SearchStrategy {
    @Override
    public List<Book> search(List<Book> books, String keyword) {
        String normalizedKeyword = keyword.trim().toLowerCase();
        List<Book> results = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().toLowerCase().contains(normalizedKeyword)) {
                results.add(book);
            }
        }
        return results;
    }
}