package Main;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import view.loginFx;
import javafx.application.Application;


/**
 * @ClassName
 * @Description
 * @Author LGH
 * @Date 2020/5/31 8:26
 * @Version 1.0
 **/

public class Start {
    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("/Spring/bean.xml");
        Application.launch(loginFx.class);

    }


}
