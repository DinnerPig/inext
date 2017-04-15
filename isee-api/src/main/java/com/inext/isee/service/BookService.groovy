package com.inext.isee.service

import com.inext.isee.dao.IBookDao
import com.inext.isee.entity.product.Book
import org.springframework.stereotype.Service

import javax.annotation.Resource

/**
 * BookService
 *
 * @author zhiliao
 * @since 2017-03-30
 */
@Service
class BookService {
    @Resource
    IBookDao bookDao;

    List<Book> getBooks() {
        bookDao.getBooks()
    }

    Book getBook(int id){
        bookDao.getBook(id)
    }
}
