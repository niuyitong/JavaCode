package com.operation;

import com.book.BookList;

public class DisplayOperation implements IOperation{
    public void work(BookList bookList){
        System.out.println("显示所有书籍");
        for (int i = 0; i < bookList.getUsedSize(); i++) {
            System.out.println(bookList.getBook(i));
        }
    }
}
