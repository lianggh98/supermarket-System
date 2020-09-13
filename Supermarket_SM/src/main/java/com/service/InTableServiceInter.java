package com.service;

import com.beanvo.IntableVo;
import com.jfoenix.controls.JFXTreeTableColumn;
import javafx.beans.value.ObservableValue;

import java.sql.Timestamp;
import java.util.List;
import java.util.function.Function;

public interface InTableServiceInter {
     /**
      * 设置inTableTreeTable的显示数据类型
      * @param columns
      * @return void
      * @Author Ryo
      * @create 2020/9/11 21:39
     */
    void setInTableJFXTreeTableColumn(JFXTreeTableColumn...columns);
    /**
     * 显示inTableTreeTable
     * @return void
     * @Author Ryo
     * @create 2020/9/11 21:39
    */
    void showInTableJFXTreeTableColumn();
    /**
     * 设置:inTableTreeView数据源
     * @param column
     * @param mapper
     * @return void
     * @Author Ryo
     * @create 2020/9/11 21:40
    */
    <T> void setinTableCellValueFactory(JFXTreeTableColumn<IntableVo, T> column, Function<IntableVo, ObservableValue<T>> mapper);
   /**
    * 查询被选中的对象然后删除
    * @return int
    * @Author Ryo
    * @create 2020/9/11 21:40
   */
    int Selected();

    /**
     * 向数据库提交
     * @param list
     * @param timestamp
     * @return int
     * @Author Ryo
     * @create 2020/9/11 21:40
    */
    int inTableUpdate(List<String> list, Timestamp timestamp);

    /**
     * 获取最后的id然后递增一个
     * @return Integer
     * @Author Ryo
     * @create 2020/9/12 13:02
     */
    Integer getNewIDByLastID();
}
