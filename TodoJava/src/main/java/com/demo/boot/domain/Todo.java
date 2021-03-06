package com.demo.boot.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String label;
    private boolean completed;
    private Date dateCreated;
    private Date dateCompleted;

    public Todo() {}

    public Todo(String label) {
        this.label = label;
    }

    public long getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public boolean isCompleted() {
        return completed;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public Date getDateCompleted() {
        return dateCompleted;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void setDateCompleted(Date dateCompleted) {
        this.dateCompleted = dateCompleted;
    }

    @Override
    public String toString() {
        return String.format(
                "Todo[id=%d, label='%s', completed='%s', dateCreated='%s', dateCompleted='%s']",
                id, label, completed, dateCreated, dateCompleted);
    }
}
