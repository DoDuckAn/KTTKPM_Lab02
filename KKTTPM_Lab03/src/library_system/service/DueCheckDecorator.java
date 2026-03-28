package library_system.service;

import library_system.model.Book;

public class DueCheckDecorator extends BorrowDecorator {
    public DueCheckDecorator(BorrowHandler delegate) {
        super(delegate);
    }

    @Override
    public BorrowResult borrow(Book book, String memberName) {
        BorrowResult result = super.borrow(book, memberName);
        if (!result.isSuccess()) {
            return result;
        }
        return new BorrowResult(true, result.getMessage() + " Han tra du kien: 14 ngay.");
    }

    @Override
    public BorrowResult returnBook(Book book, String memberName) {
        BorrowResult result = super.returnBook(book, memberName);
        if (!result.isSuccess()) {
            return result;
        }
        return new BorrowResult(true, result.getMessage() + " Kiem tra han tra da hoan tat.");
    }
}