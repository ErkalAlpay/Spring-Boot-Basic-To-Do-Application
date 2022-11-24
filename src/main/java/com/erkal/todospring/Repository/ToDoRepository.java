package com.erkal.todospring.Repository;
import com.erkal.todospring.Entity.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Long> {
}
