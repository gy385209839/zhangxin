package com.itheima.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.domain.Product;
import com.itheima.service.IProductService;
import com.itheima.utils.MyDateEdit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.Date;
import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: zx
 * @CreateDate: 2019/3/28 15:18
 * @Version: 1.0
 */

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService iProductService;

    /*@InitBinder
    public void initBinder(WebDataBinder binder) {
       // binder.registerCustomEditor(Date.class, new MyDateEdit("yyyy-MM-dd HH:mm"));
    }*/

    @RequestMapping("/save.do")
    public String save(Product product) throws Exception {
        iProductService.save(product);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findAll.do")
    @RolesAllowed("ADMIN")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "size", required =true, defaultValue = "4") Integer size){
        ModelAndView mv=new ModelAndView();
        List<Product> all = iProductService.findAll(page,size);
        PageInfo pageInfo =new PageInfo(all);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("product-list1");
        return mv;

    }
}
