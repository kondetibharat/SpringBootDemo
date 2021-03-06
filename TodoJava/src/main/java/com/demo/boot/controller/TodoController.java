package com.demo.boot.controller;

import com.demo.boot.domain.Todo;
import com.demo.boot.repository.TodoRepository;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/todo")
@ConfigurationProperties(prefix="app")
public class TodoController {
    private TodoRepository repository;

    private String title;

    @Autowired
    public TodoController(TodoRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.GET)
    String getAllTodo(Map<String,Object> model) {
        List<Todo> todos = Lists.newArrayList(repository.findAll());

        Collection<Todo> openTodos = Collections2.filter(todos, new Predicate<Todo>() {
            @Override
            public boolean apply(Todo todo) {
                return (false == todo.isCompleted());
            }
        });

        Collection<Todo> completedTodos = Collections2.filter(todos, new Predicate<Todo>() {
            @Override
            public boolean apply(Todo todo) {
                return (true == todo.isCompleted());
            }
        });

        model.put("openTodos", openTodos);
        model.put("completedTodos", completedTodos);
        model.put("title", title);

        return "todo";
    }

    @RequestMapping(method=RequestMethod.POST)
    public String addTodo(Todo todo) {
        todo.setDateCreated(new Date());
        repository.save(todo);
        return "redirect:/todo";
    }

    @RequestMapping(value = "/complete", method=RequestMethod.POST)
    public String completeTodo(@ModelAttribute(value="todo") Todo todo) {
        todo = repository.findOne(todo.getId());
        todo.setDateCompleted(new Date());
        todo.setCompleted(true);
        repository.save(todo);
        return "redirect:/todo";
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
