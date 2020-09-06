package com.dao;

import com.Bean.Persons.Department;
import com.Bean.Persons.Pcount;
import com.Bean.Persons.Post;

import java.util.List;

public interface departmentMapper {
    List<Department> findDepartmentAll();
    List<Post> findPostAll();
    List<Pcount>count_personsByDep();
}
