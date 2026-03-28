package library_system.service;

import library_system.model.Book;

public class FineCalculatorDecorator extends BorrowDecorator {
    public FineCalculatorDecorator(BorrowHandler delegate) {
        super(delegate);
    }

    @Override
    public BorrowResult borrow(Book book, String memberName) {
        BorrowResult result = super.borrow(book, memberName);
        if (!result.isSuccess()) {
            return result;
        }
        return new BorrowResult(true, result.getMessage() + " Phi phat hien tai: 0 VND.");
    }

    @Override
    public BorrowResult returnBook(Book book, String memberName) {
        BorrowResult result = super.returnBook(book, memberName);
        if (!result.isSuccess()) {
            return result;
        }
        return new BorrowResult(true, result.getMessage() + " Phi phat tam tinh: 0 VND.");
    }
}