package com.Bean.Persons;
/**
 * department
 * 
 * @author bianj
 * @version 1.0.0 2020-06-07
 */
public class Department implements java.io.Serializable {


    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", depname='" + depname + '\'' +
                '}';
    }

    /** 版本号 */
    private static final long serialVersionUID = -3688888074019064740L;

    /** 部门id */
    private Integer id;

    /** 部门名称 */
    private String depname;

    /**
     * 获取部门id
     * 
     * @return 部门id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * 设置部门id
     * 
     * @param id
     *          部门id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取部门名称
     * 
     * @return 部门名称
     */
    public String getDepname() {
        return this.depname;
    }

    /**
     * 设置部门名称
     * 
     * @param depname
     *          部门名称
     */
    public void setDepname(String depname) {
        this.depname = depname;
    }
}