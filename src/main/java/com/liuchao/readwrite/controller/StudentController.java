package com.liuchao.readwrite.controller;

import com.liuchao.readwrite.entity.Student;
import com.liuchao.readwrite.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/inster")
    public int inster(Student stu){
        int i = studentService.insertStudent(stu);
        return i;
    }

    @RequestMapping("/findAllStudent")
    public List<Student> findAllStudent(){
        List<Student> allStudent = studentService.findAllStudent();
        return allStudent;
    }
}
