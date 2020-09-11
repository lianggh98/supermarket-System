package com.dao;

import com.bean.inventory.Stock;
import com.bean.inventory.Warehouse;
import com.beanvo.StockVo;

import java.util.List;

/**
 * @author liamg
 */
public interface StockMapper {
    /**
     * 1
     * @return java.util.List<com.beanvo.StockVo>
     * @Author Ryo
     * @create 2020/9/8 17:50
    */
    List<StockVo> findStockVoAll();
    /**
     * 1
     * @param stock
     * @return void
     * @Author Ryo
     * @create 2020/9/8 17:51
    */
    void insertStock(Stock stock);
    /**
     * 1
     * @param gid
     * @return com.bean.inventory.Stock
     * @Author Ryo
     * @create 2020/9/8 17:51
    */
    Stock findStockByGid(Integer gid);
    /**
     * 1
     * @param list
     * @return void
     * @Author Ryo
     * @create 2020/9/8 17:51
    */
    void deleteStockByIds(List<Integer> list);
    /**
     * 1
     * @param stock
     * @return void
     * @Author Ryo
     * @create 2020/9/8 17:51
    */
    void updateStock(Stock stock);
    /**
     * 1
     * @param wid
     * @return com.bean.inventory.Warehouse
     * @Author Ryo
     * @create 2020/9/8 17:51
    */
    Warehouse findWarehouseById(Integer wid);
}
