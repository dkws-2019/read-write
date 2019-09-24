package com.liuchao.readwrite.mapper;

import com.liuchao.readwrite.entity.Student;

import java.util.List;

public interface StudentMapper {

    public int insterStudent(Student stu);

    public List<Student> findAllUser();
}
