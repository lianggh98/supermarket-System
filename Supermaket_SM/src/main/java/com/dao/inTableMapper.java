package com.dao;




import com.Bean.Buy.Intable;
import com.BeanVo.IntableVo;
import java.util.List;

public interface inTableMapper {

    /** intable**/
    List<IntableVo>findInTableVoAll();

    void deleteIntableByIds(List<Integer> id);

    void insertIntable(Intable intable);


}
