package com.test.h2db.h2testbd.repository;

import com.test.h2db.h2testbd.model.UserDto;
import org.springframework.data.repository.CrudRepository;

public interface UserCrudRepository extends CrudRepository<UserDto,Long> {
}
