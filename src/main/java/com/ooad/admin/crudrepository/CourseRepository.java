package com.ooad.admin.crudrepository;

import com.ooad.admin.model.Course;
import com.ooad.admin.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, String> {
}
