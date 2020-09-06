package com.service;

import com.BeanVo.IntableVo;
import com.jfoenix.controls.JFXTreeTableColumn;
import javafx.beans.value.ObservableValue;

import java.sql.Timestamp;
import java.util.List;
import java.util.function.Function;

public interface inTableServiceInter {
    /**
    * @Description: 设置inTableTreeTable的显示数据类型
    * @Param: [columns]
    * @return: void
    * @Author: Ryo
    * @Date: 2020/7/23
    */
    void set_inTableJFXTreeTableColumn(JFXTreeTableColumn...columns);
    /**
    * @Description: 显示inTableTreeTable
    * @Param: []
    * @return: void
    * @Author: Ryo
    * @Date: 2020/7/23
    */
    void show_inTableJFXTreeTableColumn();
    /**
    * @Description: //设置:inTableTreeView数据源
    * @Param: [column, mapper]
    * @return: void
    * @Author: Ryo
    * @Date: 2020/7/23
    */
    <T> void setinTableCellValueFactory(JFXTreeTableColumn<IntableVo, T> column, Function<IntableVo, ObservableValue<T>> mapper);
   /**
   * @Description: 查询被选中的对象然后删除
   * @Param: []
   * @return: int
   * @Author: Ryo
   * @Date: 2020/7/23
   */
    int Selected();
    /**
    * @Description: 向数据库提交
    * @Param: [list, timestamp]
    * @return: int
    * @Author: Ryo
    * @Date: 2020/7/23
    */
    int inTableUpdate(List<String> list, Timestamp timestamp);
}
