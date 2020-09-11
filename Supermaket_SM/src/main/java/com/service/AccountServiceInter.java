package com.service;

import com.bean.account.Account;
import com.jfoenix.controls.JFXListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * @author liamg
 */
public interface AccountServiceInter {

    /**
     * 获取登录记录
     * @param listView
     * @return int
     * @Author Ryo
     * @create 2020/9/11 21:32
    */
    int getLoginRecord(JFXListView listView);

    /**
     * 登录
     * @param user
     * @param password
     * @return com.bean.account.Account
     * @Author Ryo
     * @create 2020/9/11 21:33
    */
    Account login(TextField user, PasswordField password);

}
