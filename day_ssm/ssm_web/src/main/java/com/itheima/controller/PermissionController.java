package com.itheima.controller;

import com.itheima.domain.Permission;
import com.itheima.domain.Role;
import com.itheima.domain.Users;
import com.itheima.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: zx
 * @CreateDate: 2019/3/31 18:30
 * @Version: 1.0
 */

@Controller
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private IPermissionService permissionService;
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        List<Permission> permissionList = permissionService.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("permissionList", permissionList);
        mv.setViewName("permission-list");
        return mv;
    }
    @RequestMapping("/save.do")
    public String save(Permission p) throws Exception {
        permissionService.save(p);
        return "redirect:findAll.do";
    }

    @RequestMapping("findById.do")
    public ModelAndView findbyId(String id) throws Exception {
        Permission permission=  permissionService.findById(id);
        ModelAndView mv=new ModelAndView();
        mv.setViewName("permission-show");
        mv.addObject("permission",permission);
        return mv;
    }
    @RequestMapping("/deletePermission")
    public String deletePermission(String id) throws Exception {
        permissionService.deleteById(id);
        return "redirect:findAll.do";
    }

}
