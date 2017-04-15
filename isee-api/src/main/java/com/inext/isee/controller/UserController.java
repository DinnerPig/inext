package com.inext.isee.controller;

import com.inext.isee.entity.product.Book;
import com.inext.isee.entity.sys.SysUser;
import com.inext.isee.service.BookService;
import com.inext.isee.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 在 @PreAuthorize 中我们可以利用内建的 SPEL 表达式：比如 'hasRole()' 来决定哪些用户有权访问。
 * 需注意的一点是 hasRole 表达式认为每个角色名字前都有一个前缀 'ROLE_'。所以这里的 'ADMIN' 其实在
 * 数据库中存储的是 'ROLE_ADMIN' 。这个 @PreAuthorize 可以修饰Controller也可修饰Controller中的方法。
 **/
//@RestController
//@RequestMapping("/users")
public class UserController {
    @Autowired
    SysUserService sysUserService;
    @Resource
    BookService service;

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(method = RequestMethod.GET)
    /*public List<SysUser> getSysUsers() {
        return sysUserService.findAll();
    }*/
    List<Book> getBooks() {
        return service.getBooks();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(method = RequestMethod.POST)
    SysUser addUser(@RequestBody SysUser addedUser) {
        return sysUserService.create(addedUser);
    }

    /*@PostAuthorize("returnObject.username == principal.username or hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public SysUser getUser(@PathVariable String id) {
        return repository.findOne(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    User updateUser(@PathVariable String id, @RequestBody User updatedUser) {
        updatedUser.setId(id);
        return repository.save(updatedUser);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    User removeUser(@PathVariable String id) {
        User deletedUser = repository.findOne(id);
        repository.delete(id);
        return deletedUser;
    }*/

    /**
     * 这个方法定义的权限就是：拥有ADMIN角色或者是当前用户本身
     * @param username
     * @return
     */
    @PostAuthorize("returnObject.username == principal.username or hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public SysUser getUserByUsername(@RequestParam(value="username") String username) {
        return sysUserService.findByUserName(username);
    }
}
