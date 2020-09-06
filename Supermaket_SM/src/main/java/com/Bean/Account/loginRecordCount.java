package com.Bean.Account;

/**
 * @ClassName
 * @Description
 * @Author LGH
 * @Date 2020/7/19 17:36
 * @Version 1.0
 **/
public class loginRecordCount {

    @Override
    public String toString() {
        return "loginRecordCount{" +
                "comment='" + comment + '\'' +
                ", Lcount=" + Lcount +
                '}';
    }

    private String comment;

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

    private Integer Lcount;

    public void setLcount(Integer lcount) {
        Lcount = lcount;
    }

    public Integer getLcount() {
        return Lcount;
    }
}
