package library_system.service;

import library_system.model.Book;

public interface BorrowHandler {
    BorrowResult borrow(Book book, String memberName);
    BorrowResult returnBook(Book book, String memberName);
}