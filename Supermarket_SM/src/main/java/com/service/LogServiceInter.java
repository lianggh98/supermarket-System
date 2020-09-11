package com.service;

import java.io.File;
import java.io.IOException;

/**
 * @author liamg
 */
public interface LogServiceInter {

    /**
     * 记录登录记录
     * @param user
     * @return void
     * @Author Ryo
     * @create 2020/9/11 21:41
    */
    public void loginLog(String user) throws IOException;


}
