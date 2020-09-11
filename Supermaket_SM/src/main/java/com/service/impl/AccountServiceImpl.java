package com.service.impl;

import com.bean.account.Account;
import com.bean.account.Loginrecord;
import com.dao.AccountMapper;
import com.jfoenix.controls.JFXListView;
import com.service.AccountServiceInter;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName
 * @Description
 * @Author LGH
 * @Date 2020/7/19 17:02
 * @Version 1.0
 **/
@Service("accountService")
public class AccountServiceImpl implements AccountServiceInter {
    @Autowired
    AccountMapper mapper;
    @Override
    public int getLoginRecord(JFXListView listView){

        listView.getItems().clear();

        LocalDate localDate = LocalDate.now();
        String today = localDate.toString();
        String startTime = today+" 00:00:00";
        String endTime = today+" 23:59:00";
        HashMap map  =new HashMap();
        map.put("startTime",startTime);
        map.put("endTime",endTime);

        List<Loginrecord> loginrecordList   =  mapper.findLoginRecordAll(map);
        for(Loginrecord l: loginrecordList){
            listView.getItems().add(":登录时间"+l.getLogintime()+"  备注:"+l.getComment());
        }

        return loginrecordList.size();
    }
    @Override
    public Account login(TextField user, PasswordField password){
        HashMap<String,String> map = new HashMap<>();
        map.put("user",user.getText());
        map.put("password",password.getText());

        Account account = mapper.findUserPassword(map);
        return account;
    }

}


