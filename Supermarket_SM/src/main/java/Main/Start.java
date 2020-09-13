package Main;

import com.spring.BaseHolder;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import view.loginFx;
import javafx.application.Application;
import view.util.StageManage;
import view.util.ViewAssistImpl;

import java.io.IOException;

import static com.spring.BeanManage.viewAssistImpl;


/**
 * @ClassName
 * @Description
 * @Author LGH
 * @Date 2020/5/31 8:26
 * @Version 1.0
 **/

public class Start   {
    public static void main(String[] args) throws IOException {
        new ClassPathXmlApplicationContext("/Spring/bean.xml");
        Application.launch(loginFx.class);
    }


}
