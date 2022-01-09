package com.ooad.admin.controller;

import com.ooad.admin.crudrepository.*;
import com.ooad.admin.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private ClassroomRepository classroomRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private TimetableItemRepository timetableItemRepository;

    private StudentRepository studentRepository;

    @RequestMapping("/classrooms")
    public Iterable<Classroom> listClassrooms(@RequestParam(value = "studentId") String studentId){
        return classroomRepository.findAll();
    }

    @RequestMapping("/teachers")
    public Iterable<Teacher> listTeachers(@RequestParam(value = "studentId") String studentId){
        return teacherRepository.findAll();
    }

    @RequestMapping("/course")
    public Iterable<Course> listCourses(@RequestParam(value = "studentId") String studentId){
        return courseRepository.findAll();
    }

    @RequestMapping("/timetable")
    public TimetableItem findTimetable(@RequestParam(value = "studentId") String studentId){
        return timetableItemRepository.findById("-1").get();
    }

    @GetMapping
    public Student getStudentInfo(@RequestParam(value = "studentId") String studentId){
        return studentRepository.findById(studentId).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Student with ID " +
                                studentId +
                                " does not exist. " +
                                "Please check database."));
    }

    @PostMapping
    public Student modifyStudentInfo(@RequestParam(value = "studentId") String studentId, @RequestBody Student student){
        Student newStudent = studentRepository.findById(studentId).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Student with ID " + studentId + " does not exist. Please check database."
                ));
        newStudent.setName(student.getName());
        return newStudent;
    }

    //@PutMapping("/choice")
}
