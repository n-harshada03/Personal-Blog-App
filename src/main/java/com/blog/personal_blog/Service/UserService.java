package com.blog.personal_blog.Service;

import com.blog.personal_blog.Models.UserRequest;
import org.springframework.stereotype.Service;

public interface UserService {

    public boolean addUser(UserRequest userRequest);

}
