package com.ooad.admin;

import com.ooad.admin.crudrepository.*;
import com.ooad.admin.model.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class BuptAdminConfig {
    @Bean
    CommandLineRunner buptAdminConfigCommandLineRunner(
            ClassroomRepository classroomRepository,
            CourseRepository courseRepository,
            StudentRepository studentRepository,
            TeacherRepository teacherRepository,
            TimetableItemRepository timetableItemRepository) {
        return args -> {
            // 新建 Classroom
            Classroom classroom = new Classroom("335", "教三", "完全空闲");
            classroomRepository.save(classroom);

            // 新建 Teacher
            Teacher teacher = new Teacher("2314234", "王安生", "男", "北京市", "47381928377738288882", "计算机学院");
            teacherRepository.save(teacher);


            // 新建 Student
            Student student = new Student("2019212008", "胡杨", "男", "广东省", "44000000000000000", "软件工程", new HashSet<Course>());
//            student.getCourses().add(course);
            studentRepository.save(student);

            // 新建 Course
            Course course = new Course("43241", "软件工程理论", teacher, "3", "软件工程", "周二上午3-5节", new HashSet<>());
            course.getStudentlist().add(student);
            courseRepository.save(course);

            // 新建 Timetable
            TimetableItem timetableItem = new TimetableItem("123131", "9:50", "12:15", "周二", course);
            timetableItemRepository.save(timetableItem);
        };
    }

}
