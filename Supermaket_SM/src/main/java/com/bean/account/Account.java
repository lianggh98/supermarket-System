package com.bean.account;

import java.sql.Timestamp;

/**
 * account
 * 
 * @author bianj
 * @version 1.0.0 2020-07-19
 */
public class Account implements java.io.Serializable {

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", regintime=" + regintime +
                ", comment='" + comment + '\'' +
                '}';
    }

    /** 版本号 */
    private static final long serialVersionUID = 3115591071696770304L;

    /** 账号ID */
    private Integer id;

    /** 账号 */
    private String user;

    /** 密码 */
    private String password;

    /** 注册时间 */
    private Timestamp regintime;

    /** 备注 */
    private String comment;

    /**
     * 获取账号ID
     * 
     * @return 账号ID
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * 设置账号ID
     * 
     * @param id
     *          账号ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取账号
     * 
     * @return 账号
     */
    public String getUser() {
        return this.user;
    }

    /**
     * 设置账号
     * 
     * @param user
     *          账号
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * 获取密码
     * 
     * @return 密码
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * 设置密码
     * 
     * @param password
     *          密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取注册时间
     * 
     * @return 注册时间
     */
    public Timestamp getRegintime() {
        return this.regintime;
    }

    /**
     * 设置注册时间
     * 
     * @param regintime
     *          注册时间
     */
    public void setRegintime(Timestamp regintime) {
        this.regintime = regintime;
    }

    /**
     * 获取备注
     * 
     * @return 备注
     */
    public String getComment() {
        return this.comment;
    }

    /**
     * 设置备注
     * 
     * @param comment
     *          备注
     */
    public void setComment(String comment) {
        this.comment = comment;
    }
}