package com.erkal.todospring.Entity;
import lombok.Data;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;

@Entity
@Data
@Table
public class ToDo {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column
    private String todo;


    @ManyToOne
    private User user;



}
