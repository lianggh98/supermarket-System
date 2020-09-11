package com.service;

import com.beanvo.GoodsVo;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTreeTableColumn;
import javafx.beans.value.ObservableValue;

import java.util.List;
import java.util.function.Function;

/**
 * @author liamg
 */
public interface GoodsServiceInter {
    /**
     * 设置goodsTreeTable显示格式
     * @param columns
     * @return void
     * @Author Ryo
     * @create 2020/9/11 21:36
    */
    void setJFXTreeTableColumn(JFXTreeTableColumn... columns);

    /**
     * 查找被选中的对象然后删除,并且返回成功值
     * 返回1删除成功 0失败
     * @return int
     * @Author Ryo
     * @create 2020/9/11 21:36
    */
    int selected();

    /**
     * 显示goodsTreeTableView
     * @return void
     * @Author Ryo
     * @create 2020/9/11 21:37
    */
    void showJFXTreeTableColumn();

    /**
     * 设置goodsTreeTableColumn的数据格式
     * @param column
     * @param mapper
     * @return void
     * @Author Ryo
     * @create 2020/9/11 21:37
    */
    <T> void setGoodsCellValueFactory(JFXTreeTableColumn<GoodsVo, T> column, Function<GoodsVo, ObservableValue<T>> mapper);

    /**
     * 向数据提交或者修改数据
     * @param type
     * @param strings
     * @return void
     * @Author Ryo
     * @create 2020/9/11 21:37
    */
    void goodsUpdate$Insert(String type , List<String> strings);

    /**
     * 显示类别选择框
     * @param jfxComboBox
     * @return void
     * @Author Ryo
     * @create 2020/9/11 21:38
    */
    void showBClassComboBox(JFXComboBox jfxComboBox);
}
