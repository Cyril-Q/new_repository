package com.atguigu.test;

import com.atguigu.pojo.Book;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author apple
 * @create 2021-04-25 下午10:29
 */
public class BookServiceTest {
    BookService bookService = new BookServiceImpl();

    @Test
    public void pageByPrice(){
        System.out.println(bookService.pageByPrice(1, 4,10,50));
    }

    @Test
    public void page(){
        System.out.println(bookService.page(2, 4));
    }

    @Test
    public void addBook() {
        bookService.addBook(new Book(null, "Hello JavaEE", new BigDecimal(888), "199229", 99999, 123, null));
    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(22);
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(21, "Hello JavaEE", new BigDecimal(998), "192211", 99999, 123, null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(21));
    }

    @Test
    public void queryBooks() {
        bookService.queryBooks().forEach(System.out::println);
    }
}