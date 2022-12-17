package webtech.web.api;

import java.time.LocalDate;

public class ToDoManipulationRequest {

    private String task;
    private boolean isDone;
    private LocalDate created;
    private LocalDate dueTo;

    public ToDoManipulationRequest(String task, boolean isDone, LocalDate created, LocalDate dueTo) {
        this.task = task;
        this.isDone = isDone;
        this.created = created;
        this.dueTo = dueTo;
    }

    public ToDoManipulationRequest(){}

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
}
