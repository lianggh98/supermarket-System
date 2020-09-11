package com.beanvo;/*
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

import java.sql.Timestamp;

/**
 * intable
 * 
 * @author bianj
 * @version 1.0.0 2020-06-21
 */
public class IntableVo extends RecursiveTreeObject<IntableVo> implements java.io.Serializable {


    @Override
    public String toString() {
        return "IntableVo{" +
                "selected=" + selected +
                ", wname='" + wname + '\'' +
                ", quantity='" + quantity + '\'' +
                ", pname='" + pname + '\'' +
                ", gname='" + gname + '\'' +
                ", inid=" + inid +
                ", buyid=" + buyid +
                ", gid=" + gid +
                ", cometime=" + cometime +
                ", inPerid=" + inPerid +
                ", inStockroom=" + inStockroom +
                '}';
    }

    /** 选中 **/
    private Boolean selected=false;

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    public Boolean getSelected() {
        return selected;
    }

    /**仓库名称**/
    private String wname;

    public void setWname(String wname) {
        this.wname = wname;
    }

    public String getWname() {
        return wname;
    }

    /** 入库量**/
    private String quantity;

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getQuantity() {
        return quantity;
    }

    /** 人员姓名**/
    private String pname;

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPname() {
        return pname;
    }
    /** 商品名称**/
    private String gname ;

    public void setGname(String gname) {
        this.gname = gname;
    }

    public String getGname() {
        return gname;
    }

    /** 版本号 */
    private static final long serialVersionUID = -7002429573080449852L;

    /** 入库id */
    private Integer inid;

    /** 进货id */
    private Integer buyid;

    /** 商品id */
    private Integer gid;

    /** 入库日期 */
    private Timestamp cometime;

    /**  入库操作人员编号 */
    private Integer inPerid;

    /** 仓库编号 */
    private Integer inStockroom;

    /**
     * 获取入库id
     *
     * @return 入库id
     */
    public Integer getInid() {
        return this.inid;
    }

    /**
     * 设置入库id
     *
     * @param inid
     *          入库id
     */
    public void setInid(Integer inid) {
        this.inid = inid;
    }

    /**
     * 获取进货id
     *
     * @return 进货id
     */
    public Integer getBuyid() {
        return this.buyid;
    }

    /**
     * 设置进货id
     *
     * @param buyid
     *          进货id
     */
    public void setBuyid(Integer buyid) {
        this.buyid = buyid;
    }

    /**
     * 获取商品id
     *
     * @return 商品id
     */
    public Integer getGid() {
        return this.gid;
    }

    /**
     * 设置商品id
     *
     * @param gid
     *          商品id
     */
    public void setGid(Integer gid) {
        this.gid = gid;
    }

    /**
     * 获取入库日期
     *
     * @return 入库日期
     */
    public Timestamp getCometime() {
        return this.cometime;
    }

    /**
     * 设置入库日期
     *
     * @param cometime
     *          入库日期
     */
    public void setCometime(Timestamp cometime) {
        this.cometime = cometime;
    }

    /**
     * 获取 入库操作人员编号
     *
     * @return  入库操作人员编号
     */
    public Integer getInPerid() {
        return this.inPerid;
    }

    /**
     * 设置 入库操作人员编号
     *
     * @param inPerid
     *           入库操作人员编号
     */
    public void setInPerid(Integer inPerid) {
        this.inPerid = inPerid;
    }

    /**
     * 获取仓库编号
     *
     * @return 仓库编号
     */
    public Integer getInStockroom() {
        return this.inStockroom;
    }

    /**
     * 设置仓库编号
     *
     * @param inStockroom
     *          仓库编号
     */
    public void setInStockroom(Integer inStockroom) {
        this.inStockroom = inStockroom;
    }
}