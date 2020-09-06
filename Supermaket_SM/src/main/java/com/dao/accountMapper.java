package com.dao;


import com.Bean.Account.Account;
import com.Bean.Account.Loginrecord;
import com.Bean.Account.loginRecordCount;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface accountMapper {
        List<Loginrecord> findLoginRecordAll(HashMap map);
        List<loginRecordCount>CountTodayLoginRecordAll();
        Account findUserPassword(HashMap map);
        void insertLoginrecord(Integer loginid);
}



