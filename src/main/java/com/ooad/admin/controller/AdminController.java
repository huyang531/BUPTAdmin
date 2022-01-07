package com.ooad.admin.controller;

import com.ooad.admin.crudrepository.StudentRepository;
import com.ooad.admin.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private StudentRepository studentRepository;

    @RequestMapping("/stuadmin/add")
    public Student add(@RequestBody Student student){

//        student.setYear(year);
//        student.setId(id);
        return studentRepository.save(student);
    }
    /**
     * 查询所有数据
     * @return
     */
    @ResponseBody
    @RequestMapping("/stuadmin/list")//http://localhost:8080/stuadmin/list
    public Iterable<Student> list(){
        Iterable<Student> all = studentRepository.findAll();
        return all;
    }

}
