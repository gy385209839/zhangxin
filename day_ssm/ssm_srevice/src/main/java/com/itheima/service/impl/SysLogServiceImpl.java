package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.dao.ISysLogDao;
import com.itheima.domain.SysLog;
import com.itheima.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: zx
 * @CreateDate: 2019/4/2 8:48
 * @Version: 1.0
 */

@Service
public class SysLogServiceImpl implements ISysLogService {
    @Autowired
    private ISysLogDao sysLogDao;
    @Override
    public void save(SysLog sysLog) {
        sysLogDao.save(sysLog);
    }

    @Override
    public List<SysLog> findAll(Integer page, Integer size) {
        PageHelper.startPage(page,size);
        return sysLogDao.findAll(page,size);
    }


}
