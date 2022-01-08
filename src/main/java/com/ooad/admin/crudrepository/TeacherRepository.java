package com.ooad.admin.crudrepository;

import com.ooad.admin.model.Teacher;
import org.springframework.data.repository.CrudRepository;

public interface TeacherRepository extends CrudRepository<Teacher, String> {
}
