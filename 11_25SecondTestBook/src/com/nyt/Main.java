package com.nyt;


import com.nyt.book.BookList;
import com.nyt.user.User;
import com.nyt.user.Admin;
import com.nyt.user.NormalUser;
import java.util.Scanner;


public class Main {

    public static User login(){
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入姓名：");
        String name = scan.next();
        System.out.println("请输入身份：1.管理员 2.普通用户");
        int id = scan.nextInt();
        if(id == 1){
            return new Admin(name);
        }else {
            return new NormalUser(name);
        }
    }
    public static void main(String[] args) {
        BookList bookList = new BookList();
        User user = login();
        while(true){
            int choice = user.menu();
            user.doOperation(choice, bookList);
        }

    }
}
