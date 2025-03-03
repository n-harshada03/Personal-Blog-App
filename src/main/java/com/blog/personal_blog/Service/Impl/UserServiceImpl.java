package com.blog.personal_blog.Service.Impl;

import com.blog.personal_blog.Entity.AppUser;
import com.blog.personal_blog.Models.UserRequest;
import com.blog.personal_blog.Repository.UserRepository;
import com.blog.personal_blog.Service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean addUser(UserRequest userRequest) {

        AppUser user =mapDTOtoUserEntity(userRequest);
        AppUser savedUser=userRepository.save(user);

        return true;
    }

    private AppUser mapDTOtoUserEntity(UserRequest userRequest) {
        return AppUser.builder()
                .username(userRequest.getUsername())
                .password(userRequest.getPassword())
                .build();
    }
}
