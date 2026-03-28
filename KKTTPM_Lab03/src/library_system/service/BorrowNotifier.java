package library_system.service;

import java.util.function.Consumer;

import library_system.model.Book;

public class BorrowNotifier implements BorrowObserver {
    private final Consumer<String> sink;

    public BorrowNotifier(Consumer<String> sink) {
        this.sink = sink;
    }

    @Override
    public void onBorrow(Book book, String memberName) {
        sink.accept(memberName + " da muon sach " + book.getTitle());
    }

    @Override
    public void onReturn(Book book, String memberName) {
        sink.accept(memberName + " da tra sach " + book.getTitle());
    }
}