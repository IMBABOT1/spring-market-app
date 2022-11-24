package com.geekbrains.spring.web.validators;

import com.geekbrains.spring.web.dto.ProductDto;
import com.geekbrains.spring.web.dto.UserDto;
import com.geekbrains.spring.web.exceptions.ValidationException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserValidator {

    public void validate(UserDto userDto) {
        List<String> errors = new ArrayList<>();
        if (userDto.getPassword().isBlank()){
            errors.add("password can't be blank");
        }
        if (userDto.getEmail().isBlank()){
            errors.add("email can't be blank");
        }
        if (userDto.getUsername().isBlank()){
            errors.add("name can't be blank");
        }
        if (!errors.isEmpty()) {
            throw new ValidationException(errors);
        }
    }
}
