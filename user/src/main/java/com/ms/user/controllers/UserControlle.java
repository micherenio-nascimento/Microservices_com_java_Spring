package com.ms.user.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;

import com.ms.user.dtos.UserRecordDto;
import com.ms.user.models.UserModel;
import com.ms.user.services.UserService;

import jakarta.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class UserControlle {

    final UserService userService;
    
    public UserControlle(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public ResponseEntity<UserModel> saveUser(@RequestBody @Valid UserRecordDto UserRecordDto) {
        var userModel = new UserModel();
        BeanUtils.copyProperties(UserRecordDto, userModel);        
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userModel));
    }
    
}