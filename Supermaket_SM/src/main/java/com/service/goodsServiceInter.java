package com.service;

import com.BeanVo.GoodsVo;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTreeTableColumn;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeView;

import java.io.IOException;
import java.util.List;
import java.util.function.Function;

public interface goodsServiceInter {
    /**
    * @Description: 设置goodsTreeTable显示格式
    * @Param: [columns]
    * @return: void
    * @Author: Ryo
    * @Date: 2020/7/23
    */
    void set_JFXTreeTableColumn(JFXTreeTableColumn... columns);

    /**
    * @Description: 查找被选中的对象然后删除,并且返回成功值
    * @Param: 0失败 1成功
    * @return: int
    * @Author: Ryo
    * @Date: 2020/7/23
    */
    int selected();

    /**
    * @Description: 显示goodsTreeTableView
    * @Param: []
    * @return: void
    * @Author: Ryo
    * @Date: 2020/7/23
    */
    void show_JFXTreeTableColumn();

    /**
    * @Description: 设置goodsTreeTableColumn的数据格式
    * @Param: [column, mapper]
    * @return: void
    * @Author: Ryo
    * @Date: 2020/7/23
    */
    <T> void setGoodsCellValueFactory(JFXTreeTableColumn<GoodsVo, T> column, Function<GoodsVo, ObservableValue<T>> mapper);

    /**
    * @Description: 向数据提交或者修改数据
    * @Param: [type, strings]
    * @return: void
    * @Author: Ryo
    * @Date: 2020/7/23
    */
    void goods_Update$Insert(String type , List<String> strings);

    /**
    * @Description: 显示类别的选择框
    * @Param: [jfxComboBox]
    * @return: void
    * @Author: Ryo
    * @Date: 2020/7/23
    */
    void showBClassComboBox(JFXComboBox jfxComboBox);
}
