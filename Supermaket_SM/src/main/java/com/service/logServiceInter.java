package com.service;

import java.io.File;
import java.io.IOException;

public interface logServiceInter {
    /**
    * @Description: 记录登录记录
    * @Param: [user]
    * @return: void
    * @Author: Ryo
    * @Date: 2020/6/3
    */
    public void Login_log(String user) throws IOException;


}
