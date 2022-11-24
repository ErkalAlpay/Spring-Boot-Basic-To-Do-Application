package com.erkal.todospring.Service;

import com.erkal.todospring.Entity.ToDo;
import com.erkal.todospring.Entity.User;
import com.erkal.todospring.Repository.ToDoRepository;
import com.erkal.todospring.Repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
@Slf4j
public class ToDoService {


    @Autowired
    private ToDoRepository toDoRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;



    public void saveTodo(ToDo toDo, User user){

        log.info("Saving new todo {} to the database", toDo.getTodo());
        toDoRepository.save(toDo);
        user.getTodolar().add(toDo);
    }

    public void addUserTodoWithToken(String token, ToDo toDo){
        String email = jwtService.getTokenEmail(token);
        User user = userService.getUser(email);
        toDo.setUser(user);
        toDoRepository.save(toDo);


    }

    public void showUsersTodo(String token){
        String email = jwtService.getTokenEmail(token);
        User user = userService.getUser(email);
        System.out.println(user.getTodolar());

    }

}
