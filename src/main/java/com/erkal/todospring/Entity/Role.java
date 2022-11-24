package com.erkal.todospring.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String role;

    @ManyToOne
    private User user;

}
