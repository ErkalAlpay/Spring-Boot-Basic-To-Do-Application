package com.erkal.todospring.Controller;

import com.erkal.todospring.Entity.ToDo;
import com.erkal.todospring.Entity.User;
import com.erkal.todospring.Service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

@RestController
public class ToDoController {

    @Autowired
    private ToDoService toDoService;



    @PostMapping("/addtodo")
    public void saveTodoController(@RequestBody ToDo todo, @RequestHeader(HttpHeaders.AUTHORIZATION) String token ){
    toDoService.addUserTodoWithToken(token, todo);


    }

    @PostMapping("/deletetodo")
    public void deleteTodo(@RequestParam Long todoId){

    }

    @PostMapping("/showtodo")
    public void showUsersTodo(@RequestHeader(HttpHeaders.AUTHORIZATION) String token ){
        toDoService.showUsersTodo(token);

    }




}
