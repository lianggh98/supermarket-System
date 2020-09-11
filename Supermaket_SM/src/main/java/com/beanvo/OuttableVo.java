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
import java.sql.Timestamp;

/**
 * outtable
 * 
 * @author bianj
 * @version 1.0.0 2020-06-21
 */
public class OuttableVo implements java.io.Serializable {
    @Override
    public String toString() {
        return "OuttableVo{" +
                "selected=" + selected +
                ", outid=" + outid +
                ", gid='" + gid + '\'' +
                ", outquantity='" + outquantity + '\'' +
                ", outtime=" + outtime +
                ", outPid=" + outPid +
                '}';
    }

    /** 选中 **/
    private boolean selected;
    public boolean getSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
    /** 版本号 */
    private static final long serialVersionUID = -1493409353044339710L;

    /** 出库编号 */
    private Integer outid;


    /** 仓库编号**/
    private Integer inventoryid;

    public void setInventoryid(Integer inventoryid) {
        this.inventoryid = inventoryid;
    }

    public Integer getInventoryid() {
        return inventoryid;
    }

    /** 商品编号 */
    private Integer gid;

    /** 出库数量 */
    private String outquantity;

    /** 出库时间 */
    private Timestamp outtime;

    /** 出库人员 */
    private Integer outPid;

    /**
     * 获取出库编号
     * 
     * @return 出库编号
     */
    public Integer getOutid() {
        return this.outid;
    }

    /**
     * 设置出库编号
     * 
     * @param outid
     *          出库编号
     */
    public void setOutid(Integer outid) {
        this.outid = outid;
    }

    /**
     * 获取商品编号
     * 
     * @return 商品编号
     */
    public Integer getGid() {
        return this.gid;
    }

    /**
     * 设置商品编号
     * 
     * @param gid
     *          商品编号
     */
    public void setGid(Integer gid) {
        this.gid = gid;
    }

    /**
     * 获取出库数量
     * 
     * @return 出库数量
     */
    public String getOutquantity() {
        return this.outquantity;
    }

    /**
     * 设置出库数量
     * 
     * @param outquantity
     *          出库数量
     */
    public void setOutquantity(String outquantity) {
        this.outquantity = outquantity;
    }

    /**
     * 获取出库时间
     * 
     * @return 出库时间
     */
    public Timestamp getOuttime() {
        return this.outtime;
    }

    /**
     * 设置出库时间
     * 
     * @param outtime
     *          出库时间
     */
    public void setOuttime(Timestamp outtime) {
        this.outtime = outtime;
    }

    /**
     * 获取出库人员
     * 
     * @return 出库人员
     */
    public Integer getOutPid() {
        return this.outPid;
    }

    /**
     * 设置出库人员
     * 
     * @param outPid
     *          出库人员
     */
    public void setOutPid(Integer outPid) {
        this.outPid = outPid;
    }
}