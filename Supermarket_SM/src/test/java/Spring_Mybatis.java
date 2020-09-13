import com.spring.BeanManage;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName
 * @Description
 * @Author LGH
 * @Date 2020/7/4 17:20
 * @Version 1.0
 **/
public class Spring_Mybatis {

    @Test
    public void test(){
//
        ApplicationContext ac  =  new ClassPathXmlApplicationContext("/Spring/bean.xml");
        System.out.println(BeanManage.accountService);

    }

    @Test
    public void P(){
        String str = "4501111998";
        System.out.println(Integer.valueOf(str.substring(6,10)));

    }
}
