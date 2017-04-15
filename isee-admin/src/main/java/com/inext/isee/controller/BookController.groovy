package com.inext.isee.controller

import com.inext.isee.entity.product.Book
import com.inext.isee.service.BookService
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import javax.annotation.Resource

/**
 * BookController
 *
 * @author zhiliao
 * @since 2017-03-30
 */
@RestController
class BookController {

    @Resource
    BookService service;

    @RequestMapping('/books')
    List<Book> getBooks() {
        service.getBooks()
    }

    @RequestMapping('/book/{id}')
    Book getBook(@PathVariable(name = 'id') int id) {
        service.getBook(id)
    }

    @RequestMapping('/getUserName')
    String getUserName(String zipcode) {
        System.out.println("===========----------=========>" + zipcode)
        "zhiliao"
    }
}
