package com.dao;

import com.bean.goods.*;
import com.beanvo.*;

import java.util.List;

/**
 * @author liamg
 */
public interface GoodsMapper {

    /**
     * 查找全部的商品信息
     * @return java.util.List<com.beanvo.GoodsVo> 
     * @Author Ryo     
     * @create 2020/9/8 17:30
    */
    List<GoodsVo>findGoodsVoAll();
    /**
     * 根据商品id来删除对应的商品
     * @param list 
     * @return void 
     * @Author Ryo     
     * @create 2020/9/8 17:31
    */
    void deleteGoodsByIds(List<Integer> list);
    /**
     * 根据商品id来查询单个商品信息
     * @param id 
     * @return com.bean.goods.Goods 
     * @Author Ryo     
     * @create 2020/9/8 17:42
    */
    Goods findGoodNameById(Integer id);
    /**
     * 插入商品信息
     * @param list 
     * @return void 
     * @Author Ryo     
     * @create 2020/9/8 17:43
    */
    void insertGoods(List<Goods> list);
    /**
     * 修改商品信息
     * @param list 
     * @return void 
     * @Author Ryo     
     * @create 2020/9/8 17:44
    */
    void updateGoods(List<Goods> list);

    /**
     * 查找全部的商品类别
     * @return java.util.List<com.bean.goods.Bclass> 
     * @Author Ryo     
     * @create 2020/9/8 17:48
    */
    List<Bclass> findBClassAll();
}
