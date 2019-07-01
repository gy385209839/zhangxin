package com.itheima.controller;

import com.itheima.domain.Permission;
import com.itheima.domain.Role;
import com.itheima.service.IPermissionService;
import com.itheima.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: zx
 * @CreateDate: 2019/4/1 14:21
 * @Version: 1.0
 */

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private IRoleService roleService;
    @Autowired
    IPermissionService permissionService;
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        List<Role> roleList = roleService.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("roleList", roleList);
        mv.setViewName("role-list");
        return mv;
    }
    @RequestMapping("/save.do")
    public String save(Role role) {
        roleService.save(role);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(String id) throws Exception {
        Role role = roleService.findById(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("role", role);
        mv.setViewName("role-show");
        return mv;
    }
    @RequestMapping("/findRoleByIdAndAllPermission.do")
    public ModelAndView findRoleByIdAndAllPermission(String id) throws Exception {
        ModelAndView mv = new ModelAndView();
        Role role = roleService.findById(id);
        mv.addObject("role", role);
        List<Permission> permissionList = permissionService.findOtherPermission(id);
        mv.addObject("permissionList", permissionList);
        mv.setViewName("role-permission-add");
        return mv;
    }
    @RequestMapping("/addPermissionToRole.do")
    public String addPermissionToRole(String roleId, String[] ids) throws Exception {
        roleService.addPermissionToRole(roleId, ids);
        return "redirect:findAll.do";
    }
}
