package com.liuchao.readwrite.service;

import com.liuchao.readwrite.annotation.ReadAnnotation;
import com.liuchao.readwrite.annotation.WriteAnnotation;
import com.liuchao.readwrite.entity.Student;
import com.liuchao.readwrite.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;

@Service
public class StudentService {

    @Autowired(required = false)
    private StudentMapper studentMapper;

    @WriteAnnotation
    public int insertStudent(Student stu){
       int id= studentMapper.insterStudent(stu);
       return id;

    }
    @ReadAnnotation
    public List<Student> findAllStudent(){
        List<Student> allUser = studentMapper.findAllUser();
        return allUser;
    }

}
