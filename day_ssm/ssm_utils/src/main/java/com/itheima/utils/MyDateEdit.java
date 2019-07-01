package com.itheima.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description: java类作用描述
 * @Author: zx
 * @CreateDate: 2019/3/29 14:02
 * @Version: 1.0
 */


public class MyDateEdit {

    public static String datetostr(Date date,String patt) {
        SimpleDateFormat sdf=new SimpleDateFormat(patt);
        String format = sdf.format(date);
        return format;
    }
    public static Date strtodate(String date,String patt) throws Exception {
        SimpleDateFormat sdf=new SimpleDateFormat(patt);
        Date date1 = sdf.parse(date);
        return date1;
    }


}
