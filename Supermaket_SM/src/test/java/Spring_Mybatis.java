import com.dao.AccountMapper;
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
            ApplicationContext ac  =  new ClassPathXmlApplicationContext("/Spring/spring_mybatis.xml");
            AccountMapper mapper =ac.getBean("accountMapper", AccountMapper.class);
             System.out.println(mapper.CountTodayLoginRecordAll());

    }
}
