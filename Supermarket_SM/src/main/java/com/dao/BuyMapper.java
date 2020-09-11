package com.dao;


import com.bean.buy.Buy;
import com.bean.buy.Supplier;
import com.beanvo.BuyVo;
import java.util.List;
import java.util.Map;

/**
 * @author liamg
 */
public interface BuyMapper {
    /**
     * 找到全部采购记录
     * @return java.util.List<com.beanvo.BuyVo>
     * @Author Ryo
     * @create 2020/9/8 17:16
    */
    List<BuyVo> findBuyVoAll();

    /**
     * 找到入库记录
     * @return java.util.List<java.lang.Integer>
     * @Author Ryo
     * @create 2020/9/8 17:16
    */
    List<Integer> findInTableByBuyId();

    /**
     * 删除指定的id
     * @param list
     * @return void
     * @Author Ryo
     * @create 2020/9/8 17:21
    */
    void deleteBuyByIds(List<Integer> list);

    /**
     * 根据id找到供应商名称
     * @param id
     * @return com.bean.buy.Supplier
     * @Author Ryo
     * @create 2020/9/8 17:22
    */
    Supplier findSupplierNameByid(Integer id);

    /**
     * 批量插入
     * @param buys
     * @return void
     * @Author Ryo
     * @create 2020/9/8 17:23
    */
    void insertBuys(List<Buy> buys);

    /**
     * 修改
     * @param buy
     * @return void
     * @Author Ryo
     * @create 2020/9/8 17:23
    */
    void updateBuy(Buy buy);

    /**
     * 根据id来查询对应的buy
     * @param id
     * @return com.bean.buy.Buy
     * @Author Ryo
     * @create 2020/9/8 17:23
    */
    Buy findBuyByIds(Integer id);

    /**
     * 根据今日时间来查找入库记录
     * @param map
     * @return java.util.List<com.bean.buy.Buy>
     * @Author Ryo
     * @create 2020/9/8 17:24
    */
    List<Buy> findEveryDayBuyRecord(Map map);

    /**
     * 算出今日的采购额
     * @param map
     * @return java.lang.Double
     * @Author Ryo
     * @create 2020/9/8 17:24
    */
    Double sumTodayExpend(Map map);

    /**
     * 查找出没有入库的编号
     * @return java.util.List<java.lang.Integer>
     * @Author Ryo
     * @create 2020/9/8 17:24
    */
    List<Integer> findingTaleNoDate();
}
