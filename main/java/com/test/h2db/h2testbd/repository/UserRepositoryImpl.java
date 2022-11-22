package com.test.h2db.h2testbd.repository;

import com.test.h2db.h2testbd.model.BookingDto;
import com.test.h2db.h2testbd.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepositoryDao{
    @Autowired
    private UserCrudRepository userCrudRepository;

    @Override
    public List<UserDto> getAllUsers() {
        List<UserDto> userFound = new ArrayList<>();
        userCrudRepository.findAll().forEach(user -> userFound.add(user));
        return userFound;
    }

    @Override
    public UserDto findUserById(Long idUser) {
        return userCrudRepository.findById(idUser).get();
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        return userCrudRepository.save(userDto);
    }

    @Override
    public boolean updateUser(Long idUser, UserDto userDto) {
        UserDto userFound = findUserById(idUser);
        if (userFound != null){
            userFound.setName(userDto.getName());
            userFound.setAge(userDto.getAge());
            userCrudRepository.save(userFound);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean deleteUser(Long idUser) {
        UserDto userFound = findUserById(idUser);
        if (userFound != null){
            userCrudRepository.delete(userFound);
            return true;
        }else{
            return false;
        }
    }
}
