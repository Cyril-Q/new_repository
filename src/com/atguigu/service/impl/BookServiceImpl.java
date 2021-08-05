package com.atguigu.service.impl;

import com.atguigu.dao.BookDAO;
import com.atguigu.dao.impl.BookDAOImpl;
import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.service.BookService;

import java.util.List;

/**
 * @author apple
 * @create 2021-04-25 下午10:26
 */
public class BookServiceImpl implements BookService {

    private BookDAO bookDAO = new BookDAOImpl();

    @Override
    public void addBook(Book book) {
        bookDAO.addBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookDAO.deleteBookById(id);

    }

    @Override
    public void updateBook(Book book) {
        bookDAO.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDAO.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDAO.queryBooks();
    }

    @Override
    public Page<Book> page(int pageNo, int pageSize) {
        Page<Book> page = new Page<>();
        if (pageNo < 1) {
            pageNo = 1;
        }
        //设置每页显示的数量
        page.setPageSize(pageSize);
        //求总记录数
        Integer pageTotalCount = bookDAO.queryForPageTotalCount();
        //设置总记录数
        page.setPageTotalCount(pageTotalCount);
        //求总页码
        Integer pageTotal = (int) Math.ceil(pageTotalCount / (pageSize * 1.0));

        //数据边界的有效检查
        if (pageNo > pageTotal) {
            pageNo = pageTotal;
        }
        //设置当前页码
        page.setPageNo(pageNo);

        //设置总页码
        page.setPageTotal(pageTotal);
        //求当前页数据
        List<Book> items = bookDAO.queryForPageItems((pageNo - 1) * pageSize, pageSize);
        //设置当前页数据
        page.setItems(items);

        return page;
    }

    @Override
    public Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max) {
        Page<Book> page = new Page<>();
        if (pageNo < 1) {
            pageNo = 1;
        }
        //设置每页显示的数量
        page.setPageSize(pageSize);
        //求总记录数
        Integer pageTotalCount = bookDAO.queryForPageTotalCountByPrice(min,max);
        //设置总记录数
        page.setPageTotalCount(pageTotalCount);
        //求总页码
        Integer pageTotal = (int) Math.ceil(pageTotalCount / (pageSize * 1.0));

        //数据边界的有效检查
        if (pageNo > pageTotal) {
            pageNo = pageTotal;
        }
        //设置当前页码
        page.setPageNo(pageNo);

        //设置总页码
        page.setPageTotal(pageTotal);
        //求当前页数据
        List<Book> items = bookDAO.queryForPageItemsByPrice((pageNo - 1) * pageSize, pageSize,min,max);
        //设置当前页数据
        page.setItems(items);

        return page;
    }
}
