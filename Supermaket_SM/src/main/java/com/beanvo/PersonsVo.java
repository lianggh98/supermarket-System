package com.beanvo;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @ClassName
 * @Description
 * @Author LGH
 * @Date 2020/6/1 16:07
 * @Version 1.0
 **/
public class PersonsVo extends RecursiveTreeObject<com.beanvo.PersonsVo>  implements Serializable {

    @Override
    public String toString() {
        return "PersonsVo{" +
                "selected=" + selected +
                ", id=" + id +
                ", pname='" + pname + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", tel='" + tel + '\'' +
                ", pnumber='" + pnumber + '\'' +
                ", depname='" + depname + '\'' +
                ", depid=" + depid +
                ", postname='" + postname + '\'' +
                ", postid=" + postid +
                ", cometime=" + cometime +
                ", outtime=" + outtime +
                '}';
    }

    /** 选中 **/
    private Boolean selected = false;

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    public Boolean getSelected() {
        return selected;
    }

    /** 版本号 */
    private static final long serialVersionUID = 7882715536866072181L;
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

    /** 部门名称 */
    private String depname;
    /** 部门id**/
    private Integer depid;

    /** 职位名称**/
    private String postname;
    /** 职位id**/
    private Integer postid;

    public Integer getDepid() {
        return depid;
    }

    public void setDepid(Integer depid) {
        this.depid = depid;
    }

    public Integer getPostid() {
        return postid;
    }

    public void setPostid(Integer postid) {
        this.postid = postid;
    }

    public String getPostname() {
        return postname;
    }

    public void setPostname(String postname) {
        this.postname = postname;
    }

    /** 入职时间 */
    private Timestamp cometime;

    /** 离职时间 */
    private Timestamp outtime;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPnumber() {
        return pnumber;
    }

    public void setPnumber(String pnumber) {
        this.pnumber = pnumber;
    }

    public String getDepname() {
        return depname;
    }

    public void setDepname(String depname) {
        this.depname = depname;
    }

    public Timestamp getCometime() {
        return cometime;
    }

    public void setCometime(Timestamp cometime) {
        this.cometime = cometime;
    }

    public Timestamp getOuttime() {
        return outtime;
    }

    public void setOuttime(Timestamp outtime) {
        this.outtime = outtime;
    }
}
