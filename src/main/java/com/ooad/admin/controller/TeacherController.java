package com.ooad.admin.controller;

import com.ooad.admin.crudrepository.CourseRepository;
import com.ooad.admin.crudrepository.TeacherRepository;
import com.ooad.admin.crudrepository.TimetableItemRepository;
import com.ooad.admin.model.Course;
import com.ooad.admin.model.Student;
import com.ooad.admin.model.Teacher;
import com.ooad.admin.model.TimetableItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    private TimetableItemRepository timetableItemRepository;

    private CourseRepository courseRepository;

    private TeacherRepository teacherRepository;

    @GetMapping("{teacherId}")
    public Teacher getTeacherInfo(@PathVariable("teacherId") String teacherId){
        return teacherRepository.findById(teacherId).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Teacher with ID " +
                        teacherId +
                        " does not exist. " +
                        "Please check database."));
    }

    @Transactional
    @PutMapping(path = "{teacherId}")
    public Teacher modifyTeacher(@PathVariable String teacherId, @RequestBody Teacher teacher){
        Teacher newTeacher = teacherRepository.findById(teacherId).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Teacher with ID " + teacherId + " does not exist. Please check database."
        ));

        //检查合法性
//        if (!checkLegitimacy(newTeacher)){
//            throw new ResponseStatusException(
//                HttpStatus.NOT_ACCEPTABLE,
//                "User request is illegal.");
//        }
//        newTeacher.setTeacher(teacher.getTeacher());
        newTeacher.setName(teacher.getName());
        return newTeacher;
    }

    @GetMapping("/students/{teacherId}")
    public Iterable<Student> getStudents(@PathVariable("teacherId") String teacherId){
        return courseRepository.findStudentsByTeacherId(teacherId)
                .stream().flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    @GetMapping("/courses/{teacherId}")
    public Iterable<Course> getCourses(@PathVariable("teacherId") String teacherId){
        Course course = new Course();

        return courseRepository.findByTeacherId(teacherId);
    }

    @GetMapping("/timetable/{teacherId}")
    public Iterable<TimetableItem> getTimetable(@PathVariable("teacherId") String teacherId){
        return timetableItemRepository.findByTeacherId(teacherId);
    }

    @Deprecated
    private boolean checkLegitimacy(Teacher teacher){
        return teacher.getTid() != null && teacher.getName() != null;
    }

    @Autowired
    public void setCourseRepository(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Autowired
    public void setTeacherRepository(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Autowired
    public void setTimetableItemRepository(TimetableItemRepository timetableItemRepository) {
        this.timetableItemRepository = timetableItemRepository;
    }



}
