package com.service;

import com.beanvo.PersonsVo;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTreeTableColumn;
import javafx.beans.value.ObservableValue;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;
import java.util.function.Function;

/**
 * @author liamg
 */
public interface PersonsServiceInter {
    /**
     * 设置JFX树列
     * @param columns
     * @return void
     * @Author Ryo
     * @create 2020/9/11 17:01
    */
    void setJFXTreeTableColumn(JFXTreeTableColumn...columns) throws IOException;
    /**
     * 显示JFX树列
     * @return void
     * @Author Ryo
     * @create 2020/9/11 17:04
    */
    void showJFXTreeTableColumn();
    /**
     * 设置人员细胞工厂
     * @param column
     * @param mapper
     * @return void
     * @Author Ryo
     * @create 2020/9/11 17:04
    */
    <T> void setPersonsCellValueFactory(JFXTreeTableColumn<PersonsVo, T> column, Function<PersonsVo, ObservableValue<T>> mapper);
   /**
    * 查询
    * @return int
    * @Author Ryo
    * @create 2020/9/11 17:04
   */
    int selected();
    /**
     * 显示部门联合盒子
     * @param comboBox
     * @return void
     * @Author Ryo
     * @create 2020/9/11 17:04
    */
    void show_Dep_ComboBox(JFXComboBox<String> comboBox);
    /**
     * 显示职位联合盒子
     * @param comboBox
     * @return void
     * @Author Ryo
     * @create 2020/9/11 17:04
    */
    void show_Post_ComboBox(JFXComboBox<String> comboBox);
    /**
     * 人员提交或修改
     * @param type
     * @param strings
     * @param inTimeStamp
     * @param outTimeStamp
     * @return void
     * @Author Ryo
     * @create 2020/9/11 17:04
    */
    void persons_Insert$Update(String type, List<String> strings, Timestamp inTimeStamp, Timestamp outTimeStamp);

    /**
     * 获取最后的id然后递增一个
     * @return Integer
     * @Author Ryo
     * @create 2020/9/12 13:02
    */
    Integer getNewIDByLastID();
    
   /**
    * 根据人员身份证来获取年龄,并且判断身份证长度是否合格
    * @param PNumber
    * -450 身份证长度不合格
    * @return java.lang.String
    * @Author Ryo
    * @create 2020/9/12 13:31
   */
    Integer getAgeByPersonsNumber(String PNumber);
}
