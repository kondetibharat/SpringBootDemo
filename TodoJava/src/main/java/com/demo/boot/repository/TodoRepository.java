package com.demo.boot.repository;

import com.demo.boot.domain.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Long> {

}
