package com.dao;

import com.bean.buy.Supplier;
import com.bean.goods.Bclass;
import com.bean.inventory.Warehouse;
import com.beanvo.SupplierVo;

import java.util.HashMap;
import java.util.List;

/**
 * @author liamg
 */
public interface SetMapper {
    /**
     * 找出所有仓库
     * @return java.util.List<com.bean.inventory.Warehouse>
     * @Author Ryo
     * @create 2020/9/8 17:48
    */
    List<Warehouse> findWareHouseAll();
    /**
     * 修改仓库信息
     * @param warehouse
     * @return int
     * @Author Ryo
     * @create 2020/9/8 17:48
    */
    int updateWarehouse(Warehouse warehouse);
    /**
     * 修改账号密码
     * @param map
     * @return int
     * @Author Ryo
     * @create 2020/9/8 17:49
    */
    int accountUpdatePwd(HashMap map);
    /**
     * 插入仓库
     * @param warehouse
     * @return int
     * @Author Ryo
     * @create 2020/9/8 17:49
    */
    int insertWarehouse(Warehouse warehouse);
    /**
     * 根据仓库id来查找对应仓库
     * @param wid
     * @return com.bean.inventory.Warehouse
     * @Author Ryo
     * @create 2020/9/8 17:49
    */
    Warehouse findWarehouseById(Integer wid);
    /**
     * 1
     * @param bclass
     * @return int
     * @Author Ryo
     * @create 2020/9/8 17:50
    */
    int updateBclass(Bclass bclass);
    /**
     * 2
     * @param bclass
     * @return int
     * @Author Ryo
     * @create 2020/9/8 17:50
    */
    int insertBclass(Bclass bclass);
    /**
     * 1
     * @param bid
     * @return com.bean.goods.Bclass
     * @Author Ryo
     * @create 2020/9/8 17:50
    */
    Bclass findBclassByIds(Integer bid);
    /**
     * 1
     * @param bid
     * @return void
     * @Author Ryo
     * @create 2020/9/8 17:50
    */
    void deleteBclassById(Integer bid);
    /**
     * 1
     * @param wid
     * @return void
     * @Author Ryo
     * @create 2020/9/8 17:50
    */
    void deleteWarehouseById(Integer wid);
    /**
     * 1
     * @return java.util.List<com.beanvo.SupplierVo>
     * @Author Ryo
     * @create 2020/9/8 17:50
    */
    List<SupplierVo> findSupplierAll();
    /**
     * 1
     * @param id
     * @return void
     * @Author Ryo
     * @create 2020/9/8 17:50
    */
    void deleteSupplierById(Integer id);
    /**
     * 1
     * @param id
     * @return java.lang.Integer
     * @Author Ryo
     * @create 2020/9/8 17:50
    */
    Integer findSupplierVoByid(Integer id);
    /**
     * 1
     * @param supplier
     * @return void
     * @Author Ryo
     * @create 2020/9/8 17:50
    */
    void insertSupplier(Supplier supplier);
    /**
     * 1
     * @param supplier
     * @return void
     * @Author Ryo
     * @create 2020/9/8 17:50
    */
    void updateSupplier(Supplier supplier);
}
