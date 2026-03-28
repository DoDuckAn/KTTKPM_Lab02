package library_system.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import library_system.model.Book;
import library_system.repository.LibraryRepository;

public class LibraryService {
    private final LibraryRepository repository;
    private final BookSearcher bookSearcher;
    private final BorrowHandler borrowHandler;

    public LibraryService(LibraryRepository repository, Consumer<String> notificationSink) {
        this.repository = repository;
        this.bookSearcher = new BookSearcher();

        CoreBorrowHandler coreBorrowHandler = new CoreBorrowHandler();
        coreBorrowHandler.addObserver(new BorrowNotifier(notificationSink));
        this.borrowHandler = new FineCalculatorDecorator(new DueCheckDecorator(coreBorrowHandler));
    }

    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    public BorrowResult addBook(String id, String title, String author) {
        String normalizedId = normalize(id);
        String normalizedTitle = normalize(title);
        String normalizedAuthor = normalize(author);

        if (normalizedId.isBlank() || normalizedTitle.isBlank() || normalizedAuthor.isBlank()) {
            return new BorrowResult(false, "Thong tin sach khong duoc de trong.");
        }

        if (repository.findById(normalizedId).isPresent()) {
            return new BorrowResult(false, "Ma sach da ton tai.");
        }

        repository.save(Book.create(normalizedId, normalizedTitle, normalizedAuthor));
        return new BorrowResult(true, "Da them sach moi vao thu vien.");
    }

    public List<Book> searchBooks(String keyword, boolean searchByAuthor) {
        SearchStrategy strategy = searchByAuthor ? new SearchByAuthor() : new SearchByTitle();
        return bookSearcher.search(repository.findAll(), normalize(keyword), strategy);
    }

    public BorrowResult borrowBook(String bookId, String memberName) {
        Optional<Book> optionalBook = repository.findById(normalize(bookId));
        if (optionalBook.isEmpty()) {
            return new BorrowResult(false, "Khong tim thay sach theo ma da chon.");
        }
        if (normalize(memberName).isBlank()) {
            return new BorrowResult(false, "Can nhap ten nguoi muon.");
        }
        return borrowHandler.borrow(optionalBook.get(), normalize(memberName));
    }

    public BorrowResult returnBook(String bookId, String memberName) {
        Optional<Book> optionalBook = repository.findById(normalize(bookId));
        if (optionalBook.isEmpty()) {
            return new BorrowResult(false, "Khong tim thay sach theo ma da chon.");
        }
        if (normalize(memberName).isBlank()) {
            return new BorrowResult(false, "Can nhap ten nguoi tra sach.");
        }
        return borrowHandler.returnBook(optionalBook.get(), normalize(memberName));
    }

    private String normalize(String value) {
        return value == null ? "" : value.trim();
    }
}