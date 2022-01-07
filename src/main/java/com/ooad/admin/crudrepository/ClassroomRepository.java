package com.ooad.admin.crudrepository;

import com.ooad.admin.model.Classroom;
import org.springframework.data.repository.CrudRepository;

public interface ClassroomRepository extends CrudRepository<Classroom, String> {
}
