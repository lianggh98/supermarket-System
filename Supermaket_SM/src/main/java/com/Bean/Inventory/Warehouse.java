package com.Bean.Inventory;/*
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
/**
 * warehouse
 * 
 * @author bianj
 * @version 1.0.0 2020-07-18
 */
public class Warehouse implements java.io.Serializable {


    @Override
    public String toString() {
        return "Warehouse{" +
                "wid=" + wid +
                ", newid=" + newid +
                ", wname='" + wname + '\'' +
                '}';
    }

    /** 版本号 */
    private static final long serialVersionUID = -4414749116926861390L;

    /** 仓库编号 */
    private Integer wid;
    private Integer newid;

    public void setNewid(Integer newid) {
        this.newid = newid;
    }

    public Integer getNewid() {
        return newid;
    }

    /** 仓库名称 */
    private String wname;

    /**
     * 获取仓库编号
     * 
     * @return 仓库编号
     */
    public Integer getWid() {
        return this.wid;
    }

    /**
     * 设置仓库编号
     * 
     * @param wid
     *          仓库编号
     */
    public void setWid(Integer wid) {
        this.wid = wid;
    }

    /**
     * 获取仓库名称
     * 
     * @return 仓库名称
     */
    public String getWname() {
        return this.wname;
    }

    /**
     * 设置仓库名称
     * 
     * @param wname
     *          仓库名称
     */
    public void setWname(String wname) {
        this.wname = wname;
    }
}