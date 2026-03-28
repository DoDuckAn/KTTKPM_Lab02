package library_system.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import library_system.model.Book;

public class InMemoryLibraryRepository implements LibraryRepository {
    private static final InMemoryLibraryRepository INSTANCE = new InMemoryLibraryRepository();

    private final List<Book> books;

    private InMemoryLibraryRepository() {
        books = new ArrayList<>();
        books.add(Book.create("B001", "Clean Code", "Robert C. Martin"));
        books.add(Book.create("B002", "Design Patterns", "Gang of Four"));
        books.add(Book.create("B003", "Refactoring", "Martin Fowler"));
    }

    public static InMemoryLibraryRepository getInstance() {
        return INSTANCE;
    }

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(books);
    }

    @Override
    public Optional<Book> findById(String id) {
        return books.stream().filter(book -> book.getId().equalsIgnoreCase(id)).findFirst();
    }

    @Override
    public void save(Book book) {
        Optional<Book> existingBook = findById(book.getId());
        if (existingBook.isPresent()) {
            int index = books.indexOf(existingBook.get());
            books.set(index, book);
            return;
        }
        books.add(book);
    }
}