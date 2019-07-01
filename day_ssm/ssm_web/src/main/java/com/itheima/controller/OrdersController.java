package com.itheima.controller;


import com.github.pagehelper.PageInfo;
import com.itheima.domain.Orders;
import com.itheima.domain.Product;
import com.itheima.service.IOrdersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: zx
 * @CreateDate: 2019/3/29 15:27
 * @Version: 1.0
 */


@Controller
@RequestMapping("/orders")
public class OrdersController {


    @Autowired
    private IOrdersService iOrdersService;


    @RequestMapping("/findAll.do")
    @Secured("ROLE_ADMIN")//访问权限
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "size", required =true, defaultValue = "4") Integer size) {
        List<Orders> all = iOrdersService.findAll(page, size);
        ModelAndView mv = new ModelAndView();
        PageInfo pageInfo=new PageInfo(all);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("orders-list");
        return mv;
    }
    @RequestMapping("findById.do")
    public ModelAndView findbyid(String id) {
      Orders orders=  iOrdersService.findbyid(id);
      ModelAndView mv=new ModelAndView();
      mv.addObject("orders",orders);
      mv.setViewName("orders-show");
      return mv;
    }
    @RequestMapping("delectbyid.do")
    public String deletebyid(String[] ids) {
        for (String id : ids) {
            iOrdersService.deleyebyid(id);
        }
        return "redirect:findAll.do";
    }
}

