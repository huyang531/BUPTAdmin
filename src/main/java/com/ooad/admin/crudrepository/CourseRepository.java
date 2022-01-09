package com.ooad.admin.crudrepository;

import com.ooad.admin.model.Course;
import com.ooad.admin.model.Student;
import com.ooad.admin.model.Teacher;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, String> {
    @Query("select c from Course c where c.teacher.tid = ?1")
    List<Course> findByTeacherId(String teacherId);

    @Query("select c.studentlist from Course c where c.teacher.tid = ?1")
    List<List<Student>> findStudentsByTeacherId(String teacherId);

}
