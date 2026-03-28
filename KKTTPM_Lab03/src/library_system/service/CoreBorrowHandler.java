package library_system.service;

import java.util.ArrayList;
import java.util.List;

import library_system.model.Book;

public class CoreBorrowHandler implements BorrowHandler {
    private final List<BorrowObserver> observers;

    public CoreBorrowHandler() {
        observers = new ArrayList<>();
    }

    public void addObserver(BorrowObserver observer) {
        observers.add(observer);
    }

    @Override
    public BorrowResult borrow(Book book, String memberName) {
        if (!book.isAvailable()) {
            return new BorrowResult(false, "Sach dang duoc muon.");
        }
        book.setAvailable(false);
        for (BorrowObserver observer : observers) {
            observer.onBorrow(book, memberName);
        }
        return new BorrowResult(true, "Muon sach thanh cong.");
    }

    @Override
    public BorrowResult returnBook(Book book, String memberName) {
        if (book.isAvailable()) {
            return new BorrowResult(false, "Sach hien dang o trang thai san sang.");
        }
        book.setAvailable(true);
        for (BorrowObserver observer : observers) {
            observer.onReturn(book, memberName);
        }
        return new BorrowResult(true, "Tra sach thanh cong.");
    }
}