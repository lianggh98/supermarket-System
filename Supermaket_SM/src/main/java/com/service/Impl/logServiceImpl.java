package com.service.Impl;

import com.service.logServiceInter;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
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
public class logServiceImpl implements logServiceInter {

    private static Boolean Login_log=false;//表示文件是否存在
    private static File file;

    @Override
    public void Login_log(String user) throws IOException {
        if (Login_log == false) {
            file  = new File("./log/log.txt");
            if(!file.exists())
                file.createNewFile();//创建文件
            Login_log=true;//已经创建了日志文件
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
