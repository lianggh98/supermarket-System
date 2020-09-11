package com.dao;

import com.bean.persons.Persons;
import com.beanvo.PersonsVo;

import java.util.HashMap;
import java.util.List;

/**
 * @author liamg
 */
public interface PersonsMapper {




    /**
     * 查找所有的Persons数据
     * @return java.util.List<com.bean.persons.Persons>
     * @create 2020/9/8 15:23
    */
     List<Persons> findPersonsAll();
    /**
     * 查找所有的PersonsVo数据
     * @return java.util.List<com.beanvo.PersonsVo>
     * @create 2020/9/8 15:23
    */
     List<PersonsVo> findPersonsVoAll();


    /**
     * 批量修改Persons数据
     * @param list 
     * @return void 
     * @create 2020/9/8 15:22
    */
     void updatePersonss(List<Persons> list);
    /**
     * 批量插入Persons数据
     * @param list
     * @return void
     * @create 2020/9/8 15:24
    */
     void insertPersons(List<Persons> list);
    /**
     * 根据id来批量删除
     * @param list
     * @return void
     * @create 2020/9/8 15:24
    */
     void deletePersonsByIds(List<Integer> list);

     /**
      * 根据指定Condition来查找复合的Persons
      * @param personsVo
      * @return java.util.List<com.beanvo.PersonsVo>
      * @Author Ryo
      * @create 2020/9/8 15:26
     */
     List<PersonsVo>findPersonsVoByCondition(PersonsVo personsVo);

     /**
      * 根据ID来查找对应的Persons
      * @param id
      * @return com.bean.persons.Persons
      * @Author Ryo
      * @create 2020/9/8 15:27
     */
     Persons findPersonsByIds(Integer id);


     /**
      * 获取今日的入职人数
      * @param map
      * @return java.util.List<com.bean.persons.Persons>
      * @Author Ryo
      * @create 2020/9/8 15:27
     */
    List<Persons> getToday_entry(HashMap map);
}
