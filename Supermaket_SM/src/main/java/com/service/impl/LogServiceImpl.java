package com.service.impl;

import com.service.LogServiceInter;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Date;


/**
 * @ClassName
 * @Description
 * @Author LGH
 * @Date 2020/6/3 18:00
 * @Version 1.0
 **/
@Lazy
@Service("logService")
public class LogServiceImpl implements LogServiceInter {

    //表示文件是否存在
    private static Boolean Login_log=false;
    private static File file;

    @Override
    public void loginLog(String user) throws IOException {
        if (Login_log == false) {
            file  = new File("./log/log.txt");
            if(!file.exists()) {
                //创建文件
                file.createNewFile();
            }
            //已经创建了日志文件
            Login_log=true;
        }
        String string = "登录账号: "+user +" 登录时间:"+new Date().toString();
        //开始写入日志
        write_Log(file,string);
    }


    private void write_Log(File file, String string) throws IOException {
        //开始写入日志
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file,true));
        // 写入信息
        bufferedWriter.write("\n"+string);
        bufferedWriter.newLine();// 表示换行
        bufferedWriter.flush();// 清空缓冲区
        bufferedWriter.close();// 关闭输出流
    }
}
