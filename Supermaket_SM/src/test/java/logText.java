import org.junit.Test;

import java.io.*;

/**
 * @ClassName
 * @Description
 * @Author LGH
 * @Date 2020/6/3 18:06
 * @Version 1.0
 **/
public class logText {

    /**
    * @Description: 测试文件写入文件是否存在 自动创建写入错误信息
    * @Param:
    * @return:
    * @Author: Ryo
    * @Date: 2020/6/3
    */
    private static Boolean Login_log=false;
    private static File file;
    @Test
    public void logText() throws IOException {

        if (Login_log == false) {
            file  = new File("./log/log.txt");
            if(!file.exists()){
                System.out.println("文件不存在");
                file.createNewFile();//创建文件
                System.out.println("文件创建成功");
                Login_log=true;//已经创建了日志文件
            }
        }
        //开始写入日志
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file,true));
        // 写入信息
        bufferedWriter.write("\n你好世界");
        bufferedWriter.newLine();// 表示换行
        bufferedWriter.write("hello world");
        bufferedWriter.flush();// 清空缓冲区
        bufferedWriter.close();// 关闭输出流


    }
}
