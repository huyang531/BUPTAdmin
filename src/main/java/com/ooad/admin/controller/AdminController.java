package com.ooad.admin.controller;

import com.ooad.admin.crudrepository.*;
import com.ooad.admin.model.Classroom;
import com.ooad.admin.model.Course;
import com.ooad.admin.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ClassroomRepository classroomRepository;
    @Autowired
    private CourseRepository courseRepository;

    @PostMapping("/stuadmin")
    public Student addStudent(@RequestBody Student student){
        return studentRepository.save(student);
    }

    @DeleteMapping("/stuadmin")
    public Student deleteStudent(@RequestParam String studentId){
        if(studentRepository.existsById(studentId)){
            studentRepository.deleteById(studentId);
        }
        return null;
    }
    @ResponseBody
    @PutMapping("/stuadmin")
    public Student updateStudent(@RequestParam String studentId,@RequestBody Student student){
        if(!studentRepository.existsById(studentId)){
            studentRepository.deleteById(studentId);
        }
        return studentRepository.save(student);
    }

    @ResponseBody
    @GetMapping("/stuadmin")
    public Iterable<Student> getStudent(@RequestParam(required = false) String studentId){
        List<Student> list = new ArrayList<>();
        if(studentId == null){
            Iterable<Student> all = studentRepository.findAll();
            Iterator<Student> it = all.iterator();
            while(it.hasNext()){
                list.add(it.next());
            }
        }else{
            Student student = studentRepository.findById(studentId).get();
            list.add(student);
        }
        return list;

    }






    @PostMapping("/classrooms")
    public Classroom addClassRoom(@RequestBody Classroom classroom){

        return classroomRepository.save(classroom);
    }

    @ResponseBody
    @RequestMapping("/classrooms")
    public Iterable<Classroom> getAllClassroom(){
        Iterable<Classroom> all = classroomRepository.findAll();
        return all;
    }



    @PostMapping("/courses")
    public Course addCourse(@RequestBody Course course){

        return courseRepository.save(course);
    }

    @ResponseBody
    @GetMapping("/courses")
    public Iterable<Course> listCourses(){
        Iterable<Course> all = courseRepository.findAll();
        return all;
    }
}
