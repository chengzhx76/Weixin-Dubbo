package com.cheng.weixin.web.mobile.controller;

import com.cheng.weixin.web.mobile.model.Book;
import com.cheng.weixin.web.mobile.model.Response;
import com.cheng.weixin.web.mobile.model.User;
import com.cheng.weixin.web.mobile.param.ProductDto;
import com.cheng.weixin.web.mobile.result.index.Index;
import com.cheng.weixin.web.mobile.result.index.IndexBuy;
import com.cheng.weixin.web.mobile.security.IgnoreSecurity;
import com.cheng.weixin.web.mobile.service.SysIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

/**
 * Desc: 首页
 * Author: cheng
 * Date: 2016/6/21
 */
@RestController
public class IndexController extends BaseController {
    @Autowired
    private SysIndexService sysIndexService;

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
    @RequestMapping(value = "v1/index")
    public ResponseEntity<Response> index(HttpServletRequest request) {

        Enumeration enu=request.getParameterNames();
        while(enu.hasMoreElements()){
            String paraName=(String)enu.nextElement();
            System.out.println(paraName+": "+request.getParameter(paraName));
        }

        Index index = sysIndexService.getIndexInfo("1");
        return success(index);
    }

    @IgnoreSecurity
    @RequestMapping(value = "v1/add")
    public ResponseEntity<Response> add(HttpServletRequest request) {
        ProductDto productDto = (ProductDto) getDto(request, ProductDto.class);
        IndexBuy indexBuy = sysIndexService.addProduct("1", productDto.getProductId());
        return success(indexBuy);
    }

    @IgnoreSecurity
    @RequestMapping(value = "v1/sub")
    public ResponseEntity<Response> sub(HttpServletRequest request) {
        ProductDto productDto = (ProductDto) getDto(request, ProductDto.class);
        IndexBuy indexBuy = sysIndexService.subProduct("1", productDto.getProductId());
        return success(indexBuy);
    }
















}
