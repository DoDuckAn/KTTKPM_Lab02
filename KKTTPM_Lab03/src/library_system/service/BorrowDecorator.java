package library_system.service;

import library_system.model.Book;

public abstract class BorrowDecorator implements BorrowHandler {
    protected final BorrowHandler delegate;

    protected BorrowDecorator(BorrowHandler delegate) {
        this.delegate = delegate;
    }

    @Override
    public BorrowResult borrow(Book book, String memberName) {
        return delegate.borrow(book, memberName);
    }

    @Override
    public BorrowResult returnBook(Book book, String memberName) {
        return delegate.returnBook(book, memberName);
    }
}