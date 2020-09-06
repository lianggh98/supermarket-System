package com.Bean.Persons;
import java.sql.Timestamp;
import java.util.Date;

/**
 * persons
 * 
 * @author bianj
 * @version 1.0.0 2020-06-07
 */
public class Persons implements java.io.Serializable {

    @Override
    public String toString() {
        return "Persons{" +
                "id=" + id +
                ", pname='" + pname + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", tel='" + tel + '\'' +
                ", pnumber='" + pnumber + '\'' +
                ", depid=" + depid +
                ", postid=" + postid +
                ", cometime=" + cometime +
                ", outtime=" + outtime +
                '}';
    }

    /** 版本号 */
    private static final long serialVersionUID = 6344451681588542819L;

    /** 人员ID */
    private Integer id;

    /** 姓名 */
    private String pname;

    /** 性别 */
    private String sex;

    /** 年龄 */
    private Integer age;

    /** 联系方式 */
    private String tel;

    /** 身份证号码 */
    private String pnumber;

    /** 部门id */
    private Integer depid;

    /** 职位id */
    private Integer postid;

    /** 入职时间 */
    private Timestamp cometime;

    /** 离职时间 */
    private Timestamp outtime;

    /**
     * 获取人员ID
     * 
     * @return 人员ID
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * 设置人员ID
     * 
     * @param id
     *          人员ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取姓名
     * 
     * @return 姓名
     */
    public String getPname() {
        return this.pname;
    }

    /**
     * 设置姓名
     * 
     * @param pname
     *          姓名
     */
    public void setPname(String pname) {
        this.pname = pname;
    }

    /**
     * 获取性别
     * 
     * @return 性别
     */
    public String getSex() {
        return this.sex;
    }

    /**
     * 设置性别
     * 
     * @param sex
     *          性别
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 获取年龄
     * 
     * @return 年龄
     */
    public Integer getAge() {
        return this.age;
    }

    /**
     * 设置年龄
     * 
     * @param age
     *          年龄
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 获取联系方式
     * 
     * @return 联系方式
     */
    public String getTel() {
        return this.tel;
    }

    /**
     * 设置联系方式
     * 
     * @param tel
     *          联系方式
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * 获取身份证号码
     * 
     * @return 身份证号码
     */
    public String getPnumber() {
        return this.pnumber;
    }

    /**
     * 设置身份证号码
     * 
     * @param pnumber
     *          身份证号码
     */
    public void setPnumber(String pnumber) {
        this.pnumber = pnumber;
    }

    /**
     * 获取部门id
     * 
     * @return 部门id
     */
    public Integer getDepid() {
        return this.depid;
    }

    /**
     * 设置部门id
     * 
     * @param depid
     *          部门id
     */
    public void setDepid(Integer depid) {
        this.depid = depid;
    }

    /**
     * 获取职位id
     * 
     * @return 职位id
     */
    public Integer getPostid() {
        return this.postid;
    }

    /**
     * 设置职位id
     * 
     * @param postid
     *          职位id
     */
    public void setPostid(Integer postid) {
        this.postid = postid;
    }

    /**
     * 获取入职时间
     * 
     * @return 入职时间
     */
    public Timestamp getCometime() {
        return this.cometime;
    }

    /**
     * 设置入职时间
     * 
     * @param cometime
     *          入职时间
     */
    public void setCometime(Timestamp cometime) {
        this.cometime = cometime;
    }

    /**
     * 获取离职时间
     * 
     * @return 离职时间
     */
    public Timestamp getOuttime() {
        return this.outtime;
    }

    /**
     * 设置离职时间
     * 
     * @param outtime
     *          离职时间
     */
    public void setOuttime(Timestamp outtime) {
        this.outtime = outtime;
    }
}