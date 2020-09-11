package com.bean.account;/*
 * Welcome to use the TableGo Tools.
 * 
 * http://www.tablego.cn
 * 
 * http://vipbooks.iteye.com
 * http://blog.csdn.net/vipbooks
 * http://www.cnblogs.com/vipbooks
 * 
 * Author: bianj
 * Email: tablego@qq.com
 * Version: 6.8.0
 */
import java.sql.Timestamp;

/**
 * loginrecord
 * 
 * @author bianj
 * @version 1.0.0 2020-07-19
 */
public class Loginrecord implements java.io.Serializable {

    @Override
    public String toString() {
        return "Loginrecord{" +
                "id=" + id +
                ", loginid=" + loginid +
                ", logintime=" + logintime +
                '}';
    }


    /** 账号备注**/
    private String comment;

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

    /**账号**/
    private String user;

    public void setUser(String user) {
        this.user = user;
    }

    public String getUser() {
        return user;
    }

    /** 版本号 */
    private static final long serialVersionUID = 3556195169712073252L;

    /** ID */
    private Integer id;

    /** 账户id */
    private Integer loginid;

    /** 登录时间 */
    private Timestamp logintime;

    /**
     * 获取ID
     * 
     * @return ID
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * 设置ID
     * 
     * @param id
     *          ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取账户id
     * 
     * @return 账户id
     */
    public Integer getLoginid() {
        return this.loginid;
    }

    /**
     * 设置账户id
     * 
     * @param loginid
     *          账户id
     */
    public void setLoginid(Integer loginid) {
        this.loginid = loginid;
    }

    /**
     * 获取登录时间
     * 
     * @return 登录时间
     */
    public Timestamp getLogintime() {
        return this.logintime;
    }

    /**
     * 设置登录时间
     * 
     * @param logintime
     *          登录时间
     */
    public void setLogintime(Timestamp logintime) {
        this.logintime = logintime;
    }
}