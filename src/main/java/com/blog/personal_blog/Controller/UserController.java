package com.blog.personal_blog.Controller;

import com.blog.personal_blog.Models.UserRequest;
import com.blog.personal_blog.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> registerUser(@RequestBody UserRequest userRequest){

        boolean isRegistered=userService.addUser(userRequest);
        if(isRegistered){
            return new ResponseEntity<>("User registered successfully.",HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
        }

    }

}
