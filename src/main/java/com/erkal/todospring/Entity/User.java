package com.erkal.todospring.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String useremail;

    @Column
    private String password;


    @OneToMany(mappedBy = "user")
    private List<ToDo> todolar = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private Collection<Role> roles = new ArrayList<>();

}
