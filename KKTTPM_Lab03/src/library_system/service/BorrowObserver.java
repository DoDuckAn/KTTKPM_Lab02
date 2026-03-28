package library_system.service;

import library_system.model.Book;

public interface BorrowObserver {
    void onBorrow(Book book, String memberName);
    void onReturn(Book book, String memberName);
}