package com.demo.boot.controller;

import com.demo.boot.domain.Todo;
import com.demo.boot.repository.TodoRepository;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/rest/todo")
@ConfigurationProperties(prefix="app")
public class TodoRestController {
    private TodoRepository repository;

    @Autowired
    public TodoRestController(TodoRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.GET)
    List<Todo> getAllTodo() {
        List<Todo> todos = Lists.newArrayList(repository.findAll());
        return todos;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    Todo getTodo(@PathVariable Long id) {
        Todo todo = repository.findOne(id);
        return todo;
    }
}
