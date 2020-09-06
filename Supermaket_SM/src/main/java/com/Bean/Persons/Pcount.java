package com.Bean.Persons;

/**
 * @ClassName
 * @Description
 * @Author LGH
 * @Date 2020/7/9 22:18
 * @Version 1.0
 **/
public class Pcount {

    private String depname;
    private Integer Pcount;

    @Override
    public String toString() {
        return "Pcount{" +
                "depname='" + depname + '\'' +
                ", Pcount=" + Pcount +
                '}';
    }

    public String getDepname() {
        return depname;
    }

    public void setDepname(String depname) {
        this.depname = depname;
    }

    public Integer getPcount() {
        return Pcount;
    }

    public void setPcount(Integer pcount) {
        Pcount = pcount;
    }
}
