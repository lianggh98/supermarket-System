package com.dao;

import com.bean.persons.Department;
import com.bean.persons.Pcount;
import com.bean.persons.Post;

import java.util.List;

/**
 * @author liamg
 */
public interface DepartmentMapper {
    /**
     * 查找出全部部门
     * @return java.util.List<com.bean.persons.Department> 
     * @Author Ryo     
     * @create 2020/9/8 17:27
    */
    List<Department> findDepartmentAll();
    /**
     * 找出所有职位
     * @return java.util.List<com.bean.persons.Post>
     * @Author Ryo
     * @create 2020/9/8 17:28
    */
    List<Post> findPostAll();
    /**
     * 计算部门在职人员
     * @return java.util.List<com.bean.persons.Pcount>
     * @Author Ryo
     * @create 2020/9/8 17:28
    */
    List<Pcount>count_personsByDep();
}
