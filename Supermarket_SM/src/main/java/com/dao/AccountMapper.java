package com.dao;


import com.bean.account.Account;
import com.bean.account.Loginrecord;
import com.bean.account.loginRecordCount;

import java.util.HashMap;
import java.util.List;

/**
 * @author liamg
 */
public interface AccountMapper {
        /**
         * 根据时间来查询登录记录
         * @param map 
         * @return java.util.List<com.bean.account.Loginrecord> 
         * @Author Ryo     
         * @create 2020/9/8 15:49
        */
        List<Loginrecord> findLoginRecordAll(HashMap map);
        /**
         * 找出今天的登录记录
         * @return java.util.List<com.bean.account.loginRecordCount> 
         * @Author Ryo     
         * @create 2020/9/8 15:50
        */
        List<loginRecordCount>CountTodayLoginRecordAll();
        /**
         * 验证账号密码
         * @param map 
         * @return com.bean.account.Account 
         * @Author Ryo
         * @create 2020/9/8 15:50
        */
        Account findUserPassword(HashMap map);
        /**
         * 插入登录记录
         * @param LoginId
         * @return void 
         * @Author Ryo     
         * @create 2020/9/8 15:50
        */
        void InsertLoginRecord(Integer LoginId);
}



