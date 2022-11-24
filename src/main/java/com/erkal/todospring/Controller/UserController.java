package com.erkal.todospring.Controller;
import com.erkal.todospring.Dto.LoginFormDto;
import com.erkal.todospring.Dto.LoginResponse;
import com.erkal.todospring.Service.UserService;
import com.erkal.todospring.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public void register(@RequestBody User user){

        userService.bCryptPassword(user);
        userService.saveUser(user);

    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginFormDto loginDto){
        return userService.login(loginDto);

    }



}
