package com.nyt.operation;

import com.nyt.book.Book;
import com.nyt.book.BookList;

public class BorrowOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("借阅图书！");
        System.out.println("请输入书名");
        String name = scan.next();
        int i = 0;
        Book book = null;
        for(;i<bookList.getUsedSize();i++){
            book = bookList.getBook(i);
            if(book.getName().equals(name)){
                break;
            }
        }
        if(i==bookList.getUsedSize()){
            System.out.println("找不到要借阅的图书！");
            return;
        }else {
            if(book.isBorrowed){
                System.out.println("已被借出");
            }else {
                System.out.println("借阅成功！");
                book.setBorrowed(true);
            }
        }

    }
}
