package com.atguigu.dao;

import com.atguigu.pojo.Book;

import java.util.List;

/**
 * @author apple
 * @create 2021-04-25 下午9:03
 */
public interface BookDAO {
    public int addBook(Book book);

    public int deleteBookById(Integer id);

    public int updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();

    public Integer queryForPageTotalCount();

    public List<Book> queryForPageItems(int begin, int pageSize);

    public Integer queryForPageTotalCountByPrice(int min,int max);

    public List<Book> queryForPageItemsByPrice(int begin, int pageSize, int min, int max);
}
