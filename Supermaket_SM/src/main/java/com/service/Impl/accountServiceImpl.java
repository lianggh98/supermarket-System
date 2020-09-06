package com.service.Impl;

import com.Bean.Account.Account;
import com.Bean.Account.Loginrecord;
import com.dao.accountMapper;
import com.dao.personsMapper;
import com.jfoenix.controls.JFXListView;
import com.service.accountServiceInter;
import com.spring.BaseHolder;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
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
public class accountServiceImpl implements accountServiceInter {
    @Autowired
    accountMapper mapper;
    @Override
    public int get_LoginRecord(JFXListView listView){

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
