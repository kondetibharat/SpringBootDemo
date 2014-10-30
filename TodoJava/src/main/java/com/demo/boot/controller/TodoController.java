package com.demo.boot.controller;

import com.demo.boot.domain.Todo;
import com.demo.boot.repository.TodoRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
@ConfigurationProperties(prefix="app")
public class TodoController {
    private TodoRepository repository;

    private String title;

    @Autowired
    public TodoController(TodoRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value = "/todos", method = RequestMethod.GET)
    List<Todo> getTodos() {
        List<Todo> todos = Lists.newArrayList(repository.findAll());
        System.out.println(todos);

        return todos;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
