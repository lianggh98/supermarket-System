package com.dao;




import com.bean.buy.Intable;
import com.beanvo.IntableVo;
import java.util.List;

/**
 * @author liamg
 */
public interface InTableMapper {

    /**
     * 查找全部入库信息
     * @return java.util.List<com.beanvo.IntableVo> 
     * @Author Ryo     
     * @create 2020/9/8 17:46
    */
    List<IntableVo>findInTableVoAll();

    /**
     * 根据商品id删除入库信息
     * @param id 
     * @return void 
     * @Author Ryo     
     * @create 2020/9/8 17:47
    */
    void deleteIntableByIds(List<Integer> id);
    
    /**
     * 插入入库表
     * @param intable 
     * @return void 
     * @Author Ryo     
     * @create 2020/9/8 17:48
    */
    void insertIntable(Intable intable);


}
