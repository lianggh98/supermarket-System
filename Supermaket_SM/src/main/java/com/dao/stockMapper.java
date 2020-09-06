package com.dao;

import com.Bean.Inventory.Stock;
import com.Bean.Inventory.Warehouse;
import com.BeanVo.StockVo;

import java.util.List;

public interface stockMapper {
    List<StockVo> findStockVoAll();

    void insertStock(Stock stock);

    Stock findStockByGid(Integer gid);

    void deleteStockByIds(List<Integer> list);

    void updateStock(Stock stock);

    Warehouse findWarehouseById(Integer wid);
}
