package com.ooad.admin.controller;

import com.ooad.admin.crudrepository.*;
import com.ooad.admin.model.Classroom;
import com.ooad.admin.model.Course;
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
    @Autowired
    private ClassroomRepository classroomRepository;

    @Autowired
    private CourseRepository courseRepository;

    @RequestMapping("/stuadmin/add")
    public Student addStudent(@RequestBody Student student){

//        student.setYear(year);
//        student.setId(id);
        return studentRepository.save(student);
    }
    /**
     * 查询所有数据
     * @return
     */
    @ResponseBody
    @RequestMapping("/stuadmin/list")
    public Iterable<Student> listStudent(){
        Iterable<Student> all = studentRepository.findAll();
        return all;
    }


    @RequestMapping("/classroom/add")
    public Classroom addClassRoom(@RequestBody Classroom classroom){

        return classroomRepository.save(classroom);
    }

    @ResponseBody
    @RequestMapping("/classroom/list")
    public Iterable<Classroom> listClassroom(){
        Iterable<Classroom> all = classroomRepository.findAll();
        return all;
    }

    @RequestMapping("/course/add")
    public Course addCourse(@RequestBody Course course){

        return courseRepository.save(course);
    }

    @ResponseBody
    @RequestMapping("/course/list")
    public Iterable<Course> listCourses(){
        Iterable<Course> all = courseRepository.findAll();
        return all;
    }
}
