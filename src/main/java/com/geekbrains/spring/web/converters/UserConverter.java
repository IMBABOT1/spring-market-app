package com.geekbrains.spring.web.converters;


import com.geekbrains.spring.web.dto.ProductDto;
import com.geekbrains.spring.web.dto.UserDto;
import com.geekbrains.spring.web.entities.Product;
import com.geekbrains.spring.web.entities.Role;
import com.geekbrains.spring.web.entities.User;
import org.apache.catalina.UserDatabase;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Component
public class UserConverter {

    public User dtoToEntity(UserDto userDto) {
        List<Role> role = new ArrayList<>(Arrays.asList(new Role(1l, "ROLE_ADMIN", LocalDateTime.now(), LocalDateTime.now())));
        return new User(userDto.getId(), userDto.getUsername(), userDto.getPassword(), userDto.getEmail(), role,LocalDateTime.now(), LocalDateTime.now());
    }

    public UserDto entityToDto(User user) {
        return new UserDto(user.getId(), user.getUsername(), user.getPassword(), user.getEmail());
    }

}
