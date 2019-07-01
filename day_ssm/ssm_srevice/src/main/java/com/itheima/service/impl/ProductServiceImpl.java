package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.dao.IProductDao;
import com.itheima.domain.Product;
import com.itheima.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: zx
 * @CreateDate: 2019/3/28 15:07
 * @Version: 1.0
 */

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private IProductDao iProductDao;


    @Override
    public List<Product> findAll(int page, int pageSize) {
        PageHelper.startPage(page,pageSize);
        return iProductDao.findAll(page,pageSize);
    }

    @Override
    public void save(Product product) {
        Date datetime = product.getDepartureTime();
        if(datetime.getTime()<new Date().getTime()+24*60*60*1000){
            throw new RuntimeException("时间不对");
        }
        iProductDao.save(product);
    }
}
