package com.ooad.admin.crudrepository;

import com.ooad.admin.model.ElectiveInfoBody;
import org.springframework.data.repository.CrudRepository;

public interface ElectiveInfoRepository extends CrudRepository<ElectiveInfoBody, String> {
}
