package com.dao;

import com.Bean.Goods.*;
import com.BeanVo.*;

import java.util.List;

public interface goodsMapper {

    List<GoodsVo>findGoodsVoAll();
    void deleteGoodsByIds(List<Integer> list);
    Goods findGoodNameById(Integer id);
    void insertGoodss(List<Goods> list);
    void updateGoodss(List<Goods> list);

    List<Bclass> findBClassAll();
}
