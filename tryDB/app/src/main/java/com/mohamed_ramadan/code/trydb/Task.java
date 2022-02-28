package com.mohamed_ramadan.code.trydb;

public class Task {

   private String title;
   private String task;
   private int Id;

    public Task() {

    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Task(String title, String task , int id) {
        this.title = title;
        this.task = task;
        this.Id=id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }
}
