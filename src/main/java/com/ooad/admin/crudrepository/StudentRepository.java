package com.ooad.admin.crudrepository;

import com.ooad.admin.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, String> {
}
