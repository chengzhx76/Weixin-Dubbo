package com.cheng.weixin.web.mobile.controller;

import com.cheng.weixin.web.mobile.exception.TokenException;
import com.cheng.weixin.web.mobile.model.Book;
import com.cheng.weixin.web.mobile.model.Response;
import com.cheng.weixin.web.mobile.model.User;
import com.cheng.weixin.web.mobile.security.IgnoreSecurity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Desc: 首页
 * Author: cheng
 * Date: 2016/6/21
 */
@RestController
public class IndexController extends BaseController {

    @RequestMapping(value = "v1/index1")
    public ResponseEntity<Response> index1() {

        User user = new User();
        //user.setAge(21);
        user.setName("张三");
        //user.setHaveAmount(new BigDecimal(26.5));
        //user.setNickName("kaixin001");
        user.setSex(true);

        user.setBirthday(new Date());

        List<Book> books = new ArrayList<>();
       /* Book book1 = new Book();
        book1.setName("数学");
        book1.setPageNum(308);
        book1.setHasPage(201);
        books.add(book1);

        Book book2 = new Book();
        book2.setName("语文");
        book2.setPageNum(296);
        book2.setHasPage(101);
        books.add(book2);*/

        user.setBooks(books);


        return success(user);
    }
    @IgnoreSecurity
    @RequestMapping(value = "v1/login")
    public ResponseEntity<Response> login1() {
        return failure();
    }

    @IgnoreSecurity
    @RequestMapping(value = "v1/login2")
    public ResponseEntity<Response> login2() {
        return success();
    }


    @IgnoreSecurity
    @RequestMapping(value = "v1/test")
    public ResponseEntity<Response> test1() {
        throw new RuntimeException("===RuntimeException===");
    }
    @IgnoreSecurity
    @RequestMapping(value = "v1/test2")
    public ResponseEntity<Response> test2() throws Exception {

        throw new Exception("===Exception===");
    }
    @IgnoreSecurity
    @RequestMapping(value = "v1/test3")
    public ResponseEntity<Response> test3() throws Exception {

        throw new TokenException("===TokenException===");
    }


    public ResponseEntity<Response> indexHeader() {


        return null;
    }


















}
