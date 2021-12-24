package com.ooad.admin.controller;

import com.ooad.admin.crudrepository.StudentRepository;
import com.ooad.admin.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;
    /**
     * 新增一条数据
     * @param name
     * @return
     */
    @RequestMapping("/add")//http://localhost:8080/add?name=test123&year=2024&id=1
    public Student add(String name,String id,String year){
        Student student = new Student();
        student.setName(name);
        student.setYear(year);
        student.setId(id);
        return studentRepository.save(student);
    }
    /**
     * 查询所有数据
     * @return
     */
    @RequestMapping("/list")//http://localhost:8080/list
    public Iterable<Student> list(){
        Iterable<Student> all = studentRepository.findAll();
        return all;
    }

}
