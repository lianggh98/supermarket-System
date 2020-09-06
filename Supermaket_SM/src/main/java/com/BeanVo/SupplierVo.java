package com.BeanVo;/*
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

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

/**
 * supplier
 * 
 * @author bianj
 * @version 1.0.0 2020-06-17
 */
public class SupplierVo extends RecursiveTreeObject<SupplierVo> implements java.io.Serializable {
    @Override
    public String toString() {
        return "Supplier{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", addr='" + addr + '\'' +
                '}';
    }

    /** 版本号 */
    private static final long serialVersionUID = 270911421415879711L;

    /** ID */
    private Integer id;

    /** 进货商名称 */
    private String name;

    /** 联系方式 */
    private String tel;

    /** 地址 */
    private String addr;

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
     * 获取进货商名称
     * 
     * @return 进货商名称
     */
    public String getName() {
        return this.name;
    }

    /**
     * 设置进货商名称
     * 
     * @param name
     *          进货商名称
     */
    public void setName(String name) {
        this.name = name;
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
     * 获取地址
     * 
     * @return 地址
     */
    public String getAddr() {
        return this.addr;
    }

    /**
     * 设置地址
     * 
     * @param addr
     *          地址
     */
    public void setAddr(String addr) {
        this.addr = addr;
    }
}