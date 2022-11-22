package com.test.h2db.h2testbd.repository;

import com.test.h2db.h2testbd.model.BookingDto;
import com.test.h2db.h2testbd.model.UserDto;

import java.util.List;

public interface UserRepositoryDao {
    List<UserDto> getAllUsers();
    UserDto findUserById(Long idUser);
    UserDto createUser(UserDto userDto);
    boolean updateUser(Long idUser,UserDto userDto);
    boolean deleteUser(Long idUser);
}
