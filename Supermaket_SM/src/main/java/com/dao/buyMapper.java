package com.dao;


import com.Bean.Buy.Buy;
import com.Bean.Buy.Supplier;
import com.BeanVo.BuyVo;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface buyMapper {
    List<BuyVo> findBuyVoAll();

    List<Integer> findinTableByBuyId();

    void deleteBuyByIds(List<Integer> list);

    Supplier findSupplierNameByid(Integer id);

    void insertBuys(List<Buy> buys);

    void updateBuy(Buy buy);

    Buy findBuyByIds(Integer id);

    List<Buy> findEveryDayBuyRecord(Map map);

    Double sumTodayExpend(Map map);

    List<Integer> findinTbaleNoDate();
}
