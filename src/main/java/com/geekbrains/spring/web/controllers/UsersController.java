package com.geekbrains.spring.web.controllers;


import com.geekbrains.spring.web.converters.UserConverter;
import com.geekbrains.spring.web.dto.ProductDto;
import com.geekbrains.spring.web.dto.UserDto;
import com.geekbrains.spring.web.entities.Product;
import com.geekbrains.spring.web.entities.User;
import com.geekbrains.spring.web.services.UserService;
import com.geekbrains.spring.web.validators.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UsersController {

    private final UserService userService;
    private final UserValidator userValidator;
    private final UserConverter userConverter;
    private final PasswordEncoder passwordEncoder;



    @PostMapping
    public UserDto getAllProducts(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "pass") String password,
            @RequestParam(name = "email") String email
    ) {

        UserDto userDto = new UserDto(null, name, passwordEncoder.encode(password), email);
        userValidator.validate(userDto);
        userService.save(userConverter.dtoToEntity(userDto));
        return userDto;
    }
}
