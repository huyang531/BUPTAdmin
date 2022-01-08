package com.ooad.admin.crudrepository;

import com.ooad.admin.model.TimetableItem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TimetableItemRepository extends CrudRepository<TimetableItem, String> {
    @Query("select t from TimetableItem t where t.course.teacher.teacher = ?1")
    List<TimetableItem> findByTeacherId(String teacherId);
}
