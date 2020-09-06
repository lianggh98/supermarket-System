import com.Bean.Inventory.Warehouse;
import com.dao.accountMapper;
import com.dao.setMapper;
import com.spring.BaseHolder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.*;

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
            setMapper mapper = BaseHolder.getApplicationContext().getBean("setMapper",setMapper.class);
        Warehouse w = new Warehouse();
        w.setWid(1);
        w.setWname("仓库1");

        System.out.println(mapper.updateWarehouse(w));


    }
}
