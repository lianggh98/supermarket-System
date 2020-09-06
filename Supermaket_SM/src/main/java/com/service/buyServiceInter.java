package com.service;

import com.BeanVo.BuyVo;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import javafx.beans.value.ObservableValue;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.function.Function;

public interface buyServiceInter {
     /**
     * @Description: 数据类型工厂设置
     * @Param: [column, mapper]
     * @return: void
     * @Author: Ryo
     * @Date: 2020/7/23
     */
     <T> void setBuyCellValueFactory(JFXTreeTableColumn<BuyVo, T> column, Function<BuyVo, ObservableValue<T>> mapper);
     /**
     * @Description: 查找被选中的然后删除
     * @Param: []
     * @return: int
     * @Author: Ryo
     * @Date: 2020/7/23
     */
     int Buyselected();
     /**
     * @Description: 显示Buy的TreeTableView
     * @Param: []
     * @return: void
     * @Author: Ryo
     * @Date: 2020/7/23
     */
     void show_BuyJFXTreeTableColumn();
     /**
     * @Description: //设置:Buy的TreeTableView显示格式
     * @Param: [column]
     * @return: void
     * @Author: Ryo
     * @Date: 2020/7/23
     */
     void set_BuyJFXTreeTableColumn(JFXTreeTableColumn... column);
     /**
     * @Description: 向数据库提交数据 Type则来判断类型
     * @Param: [type, strings, inTimeStamp, producedTimeStamp]
     * @return: void
     * @Author: Ryo
     * @Date: 2020/7/23
     */
     void update_inser(String type, List<String> strings, Timestamp inTimeStamp, Timestamp producedTimeStamp);

     /**
     * @Description: 获取一星期的采购力度
     * @Param: [strings]
     * @return: java.util.List<java.lang.Integer>
     * @Author: Ryo
     * @Date: 2020/7/23
     */
     List<Integer> get_EveryDayBuyRecord(List<String> strings);
}
