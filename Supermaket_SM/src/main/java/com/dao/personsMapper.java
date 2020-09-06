package com.dao;

import com.Bean.Persons.Persons;
import com.BeanVo.PersonsVo;

import java.util.HashMap;
import java.util.List;

public interface personsMapper {
    /**
    * @Description: 查询标下所有数据
    * @Param: []
    * @return: java.util.List<com.bean.Persons>
    * @Author: Ryo
    * @Date: 2020/5/30
    */
     List<Persons> findPersonsAll();
    /**
    * @Description: 查找全部的PersonsVO
    * @Param: []
    * @return: java.util.List<com.BeanVo.PersonsVo>
    * @Author: Ryo
    * @Date: 2020/6/7
    */
     List<PersonsVo> findPersonsVoAll();
    /**
    * @Description: 修改数据
    * @Param: [list]
    * @return: void
    * @Author: Ryo
    * @Date: 2020/6/7
    */
     void updatePersonss(List<Persons> list);
     /**
     * @Description: 添加数据
     * @Param: [list]
     * @return: void
     * @Author: Ryo
     * @Date: 2020/6/7
     */
     void  insertPersonss(List<Persons> list);
    /**
    * @Description: 根据id来删除来批量删除
    * @Param: [list]
    * @return: void
    * @Author: Ryo
    * @Date: 2020/6/5
    */
     void deletePersonsByIds(List<Integer> list);

    /**
    * @Description:  模糊查询
    * @Param: [personsVo]
    * @return: java.util.List<com.BeanVo.PersonsVo>
    * @Author: Ryo
    * @Date: 2020/6/7
    */
     List<PersonsVo>findPersonsVoByCondition(PersonsVo personsVo);

     /**
     * @Description: 根據主鍵來查詢對應的信息
     * @Param: [id]
     * @return: com.Bean.Persons.Persons
     * @Author: Ryo
     * @Date: 2020/7/5
     */
     Persons findPersonsByIds(Integer id);


     /**
     * @Description:获取今日入职的人数并且显示出来
     * @Param: [map]
     * @return: java.util.List<com.Bean.Persons.Persons>
     * @Author: Ryo
     * @Date: 2020/7/17
     */
    List<Persons> getToday_entry(HashMap map);
}
