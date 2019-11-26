package com.nyt.user;

import com.nyt.book.BookList;
import com.nyt.operation.IOperation;

public abstract class User {
    String name;
    public IOperation[] operations;
    public abstract int menu();
    public void doOperation(int choice, BookList bookList) {
        operations[choice].work(bookList);
    }
}
