package com.itheima.controller;

import com.itheima.domain.Role;
import com.itheima.domain.Users;


import com.itheima.service.IusersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: zx
 * @CreateDate: 2019/3/31 16:34
 * @Version: 1.0
 */

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IusersService iusersService;


    @RequestMapping("/findAll.do")
    @PreAuthorize("hasRole('ROLE_ADMIN')")//访问权限
    public ModelAndView findall() {
        List<Users> users = iusersService.findall();
        ModelAndView mv = new ModelAndView();
        mv.addObject("userList", users);
        mv.setViewName("user-list");
        return mv;
    }

    @RequestMapping("/save.do")
    @PreAuthorize("authentication.principal.username=='tom'")//指定访问权限的名字
    public String saveuser(Users users) {
        iusersService.saveuser(users);
        return "redirect:findAll.do";
    }
   @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id", required = true)String id){
        Users user = iusersService.findById(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("user", user);
        mv.setViewName("user-show");
        return mv;
    }

    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(String id) throws Exception {
        Users user = iusersService.findById(id);
        List<Role> roleList = iusersService.findOtherRole(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("user", user);
        mv.addObject("roleList", roleList);
        mv.setViewName("user-role-add");
        return mv;
    }
    @RequestMapping("/addRoleToUser.do")
    public String addRoleToUser(String userId, String[] ids) throws Exception {
        iusersService.addRoleToUser(userId,ids);
        return "redirect:findAll.do";
    }



}
