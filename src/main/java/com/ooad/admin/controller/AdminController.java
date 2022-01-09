package com.ooad.admin.controller;

import com.ooad.admin.crudrepository.*;
import com.ooad.admin.model.*;
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
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private TimetableItemRepository timetableItemRepository;

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
        if(studentRepository.existsById(studentId)){
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
    @DeleteMapping("/classrooms")
    public Classroom deleteClassroom(@RequestParam(name = "roomId") String roomId){
        if(classroomRepository.existsById(roomId)){
            classroomRepository.deleteById(roomId);
        }
        return null;
    }
    @ResponseBody
    @PutMapping("/classrooms")
    public Classroom updateClassroom(@RequestParam(name = "roomId") String room,@RequestBody Classroom classroom){
        if(classroomRepository.existsById(room)){
            classroomRepository.deleteById(room);
        }
        return classroomRepository.save(classroom);
    }


    @PostMapping("/courses")
    public Course addCourse(@RequestBody Course course){
        if(course.getTeacher() != null){
            teacherRepository.save(course.getTeacher());//直接上班
        }
        if(course.getStudentlist() != null){
            for(Student student : course.getStudentlist()){//直接
                studentRepository.save(student);
            }
        }
        return courseRepository.save(course);
    }



    @ResponseBody
    @GetMapping("/courses")
    public Iterable<Course> listCourses(){
        Iterable<Course> all = courseRepository.findAll();
        return all;
    }
    @DeleteMapping("/course")
    public Course deleteCourse(@RequestParam(name = "courseId") String courseId){
        if(courseRepository.existsById(courseId)){
            courseRepository.deleteById(courseId);
        }
        return null;
    }
    @ResponseBody
    @PutMapping("/course")
    public Course updateCourse(@RequestParam(name = "courseId") String courseId,@RequestBody Course course){
        if(courseRepository.existsById(courseId)){
            courseRepository.deleteById(courseId);
        }
        return courseRepository.save(course);
    }



    @PostMapping("/teachers")
    public Teacher addTeacher(@RequestBody Teacher teacher){
        return teacherRepository.save(teacher);
    }

    @DeleteMapping("/teachers")
    public Teacher deleteTeacher(@RequestParam String teacherId){
        if(teacherRepository.existsById(teacherId)){
            teacherRepository.deleteById(teacherId);
        }
        return null;
    }
    @ResponseBody
    @PutMapping("/teachers")
    public Teacher updateTeacher(@RequestParam String teacherId ,@RequestBody Teacher teacher){
        if(teacherRepository.existsById(teacherId)){
            teacherRepository.deleteById(teacherId);
        }
        return teacherRepository.save(teacher);
    }

    @ResponseBody
    @GetMapping("/teachers")
    public Iterable<Teacher> getTeacher(@RequestParam(required = false) String teacherId){
        if(teacherId == null){
            return teacherRepository.findAll();
        }else{
            List<Teacher> list = new ArrayList<>();
            Teacher teacher = teacherRepository.findById(teacherId).get();
            list.add(teacher);
            return list;
        }
    }
    @PostMapping("/timetable")
    public TimetableItem addTimetableItem(@RequestBody TimetableItem timetableItem){
        timetableItem.setId("-1");//课程表只设置有唯一的一个
        return timetableItemRepository.save(timetableItem);
    }
    @ResponseBody
    @GetMapping("/timetable")
    public TimetableItem getTimetableItem(){
        return timetableItemRepository.findAll().iterator().next();

    }

}
