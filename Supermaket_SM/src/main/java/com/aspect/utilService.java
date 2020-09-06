package com.aspect;



import com.Bean.Account.Account;
import com.Bean.Account.Loginrecord;
import com.dao.accountMapper;
import com.jfoenix.controls.JFXTextField;
import com.service.Impl.accountServiceImpl;
import com.service.Impl.logServiceImpl;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import view.util.Manage;


/**
 * @ClassName
 * @Description
 * @Author LGH
 * @Date 2020/6/1 13:34
 * @Version 1.0
 **/
@Component("utilService")
@Aspect//表示当前类是一个切面类
public class utilService {

    @Autowired
    accountMapper accountMapper;
    @Autowired
    Manage manage;

    //切入点
        @Pointcut("execution(* com.service.Impl.accountServiceImpl.login(..))")
            private void Auto_loginLog(){};
    @Around("Auto_loginLog()")
    /**
    * @Description: 自动写入登录记录进入io
    * @Param: [point]
    * @return: java.lang.Object
    * @Author: Ryo
    * @Date: 2020/6/20
    */
    public Object login_log(ProceedingJoinPoint point) throws Throwable {
        Object rtValue = null;//返回值
            Object[] args = point.getArgs();//得到方法所需要的的参数;
            rtValue = point.proceed(args);//明确业务层的方法 切入点;
           if(rtValue!=null){
//               获取账号密码 然后写入登录记录
               Account account = (Account) rtValue;
               accountMapper.insertLoginrecord(account.getId());
           }


       return rtValue;
    }




//    @Pointcut("execution(* com.service.Impl.personsServiceImpl.*(..))")
//    private void refresh(){};
//    @Around("refresh()")
//    public Object refreshPersonsCharts(ProceedingJoinPoint point) throws Throwable {
//        Object rtValue = null;//返回值
//        Object[] args = point.getArgs();//得到方法所需要的的参数;
//        rtValue = point.proceed(args);//明确业务层的方法 切入点;
//        System.out.println("方法切入");
////        manage.PersonsModelRStart();
//        return rtValue;
//    }
//




}
