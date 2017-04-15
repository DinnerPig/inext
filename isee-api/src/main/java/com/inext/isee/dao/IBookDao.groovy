package com.inext.isee.dao

import com.inext.isee.entity.product.Book
import org.springframework.stereotype.Repository

/**
 * IBookDao
 *
 * @author zhiliao
 * @since 2017-03-30
 */
@Repository
interface IBookDao {
    List<Book> getBooks()
    Book getBook(int id)
}
