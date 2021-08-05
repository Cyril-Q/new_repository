package com.atguigu.test;

import com.atguigu.dao.BookDAO;
import com.atguigu.dao.impl.BookDAOImpl;
import com.atguigu.pojo.Book;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author apple
 * @create 2021-04-25 下午9:50
 */
public class BookDAOTest {
    private BookDAO bookDAO = new BookDAOImpl();

    @Test
    public void queryForPageTotalCountByPrice(){
        System.out.println(bookDAO.queryForPageTotalCountByPrice(10,50));
    }

    @Test
    public void queryForPageTotalCount(){
        System.out.println(bookDAO.queryForPageTotalCount());
    }

    @Test
    public void queryForPageItemsByPrice(){
        List<Book> list = bookDAO.queryForPageItemsByPrice(0, 4,10,50);
        list.forEach(System.out::println);
    }

    @Test
    public void queryForPageItems(){
        List<Book> list = bookDAO.queryForPageItems(4, 4);
        list.forEach(System.out::println);
    }

    @Test
    public void addBook() {
        bookDAO.addBook(new Book(null, "Hello JavaWeb", new BigDecimal(999), "191125", 110000, 0, null));
    }

    @Test
    public void deleteBookById() {
        bookDAO.deleteBookById(21);
    }

    @Test
    public void updateBook() {
        bookDAO.updateBook(new Book(21, "Hello JavaWeb", new BigDecimal(999), "191125", 110000, 100, null));
    }

    @Test
    public void queryBookById() {
        Book book = bookDAO.queryBookById(21);
        System.out.println(book);

    }

    @Test
    public void queryBooks() {
        bookDAO.queryBooks().forEach(System.out::println);
    }
}