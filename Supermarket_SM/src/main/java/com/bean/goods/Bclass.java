package com.bean.goods;
/**
 * bclass
 * 
 * @author bianj
 * @version 1.0.0 2020-06-07
 */
public class Bclass implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = 6724227044789467013L;

    /** bid */
    private Integer bid;

    /** bNewid**/
    private Integer newid;

    public void setNewid(Integer newid) {
        this.newid = newid;
    }

    public Integer getNewid() {
        return newid;
    }

    /** 大类名 */
    private String bname;

    /**
     * 获取bid
     * 
     * @return bid
     */
    public Integer getBid() {
        return this.bid;
    }

    /**
     * 设置bid
     * 
     * @param bid
     */
    public void setBid(Integer bid) {
        this.bid = bid;
    }

    /**
     * 获取大类名
     * 
     * @return 大类名
     */
    public String getBname() {
        return this.bname;
    }

    /**
     * 设置大类名
     * 
     * @param bname
     *          大类名
     */
    public void setBname(String bname) {
        this.bname = bname;
    }
}