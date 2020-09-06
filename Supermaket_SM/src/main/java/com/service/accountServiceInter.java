package com.service;

import com.Bean.Account.Account;
import com.jfoenix.controls.JFXListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public interface accountServiceInter {
    /**
    * @Description: 获取登录记录
    * @Param: [listView]
    * @return: int
    * @Author: Ryo
    * @Date: 2020/7/23
    */
    int get_LoginRecord(JFXListView listView);
    /**
    * @Description: 登录
    * @Param: [user, password]
    * @return: com.Bean.Account.Account
    * @Author: Ryo
    * @Date: 2020/7/23
    */
    Account login(TextField user, PasswordField password);

}
