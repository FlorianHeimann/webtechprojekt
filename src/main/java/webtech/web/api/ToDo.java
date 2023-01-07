package webtech.web.api;

import java.time.LocalDate;

public class ToDo {

    private long id;
    private String task;
    private boolean isDone;
    private LocalDate created;
    private LocalDate dueTo;
    private String owner;

    public ToDo(long id, String task, boolean isDone, LocalDate created, LocalDate dueTo, String owner) {
        this.id = id;
        this.task = task;
        this.isDone = isDone;
        this.created = created;
        this.dueTo = dueTo;
        this.owner = owner;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public LocalDate getDueTo() {
        return dueTo;
    }

    public void setDueTo(LocalDate dueTo) {
        this.dueTo = dueTo;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
