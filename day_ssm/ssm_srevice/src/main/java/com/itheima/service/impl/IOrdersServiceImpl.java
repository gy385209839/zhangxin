package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.dao.IOrdersDao;
import com.itheima.domain.Orders;
import com.itheima.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: zx
 * @CreateDate: 2019/3/29 16:28
 * @Version: 1.0
 */

@Service
public class IOrdersServiceImpl implements IOrdersService {
    @Autowired
    private IOrdersDao iOrdersDao;

    @Override
    public List<Orders> findAll(int page, int pageSize) {
        PageHelper.startPage(page,pageSize);
        return iOrdersDao.findAll(page,pageSize);
    }

    @Override
    public Orders findbyid(String id) {
        return iOrdersDao.findbyid(id);
    }

    @Override
    public void deleyebyid(String id) {
        iOrdersDao.deleteorderbyid(id);
    }
}
