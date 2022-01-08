package com.ooad.admin.crudrepository;

import com.ooad.admin.model.TimetableItem;
import org.springframework.data.repository.CrudRepository;

public interface TimetableItemRepository extends CrudRepository<TimetableItem, String> {
}
