package com.dao;

import com.Bean.Buy.Supplier;
import com.Bean.Goods.Bclass;
import com.Bean.Inventory.Warehouse;
import com.BeanVo.SupplierVo;

import java.util.HashMap;
import java.util.List;

public interface setMapper {
    List<Warehouse> findWareHouseAll();
    int updateWarehouse(Warehouse warehouse);
    int accountUpdatePwd(HashMap map);
    int insertWarehouse(Warehouse warehouse);
    Warehouse findWarehouseById(Integer wid);
    int updateBclass(Bclass bclass);
    int insertBclass(Bclass bclass);
    Bclass findBclassByIds(Integer bid);
    void deleteBclassById(Integer bid);
    void deleteWarehouseById(Integer wid);
    List<SupplierVo> findSupplierAll();
    void deleteSupplierById(Integer id);
    Integer findSupplierVoByid(Integer id);
    void insertSupplier(Supplier supplier);
    void updateSupplier(Supplier supplier);
}
