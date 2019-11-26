package com.nyt.operation;

import com.nyt.book.BookList;

public class DisplayOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        int i = 0;
        for(;i<bookList.getUsedSize();i++){
            System.out.println(bookList.getBook(i));
        }

    }
}
