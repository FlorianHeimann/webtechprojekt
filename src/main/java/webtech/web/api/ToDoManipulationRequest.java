package webtech.web.api;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

public class ToDoManipulationRequest {

    @NotBlank(message = "The Task must not be empty")
    private String task;
    @NotNull
    private boolean isDone;
    @NotNull
    private LocalDate created;
    @NotNull
    private LocalDate dueTo;
    private String owner;

    public ToDoManipulationRequest(String task, boolean isDone, LocalDate created, LocalDate dueTo, String owner) {
        this.task = task;
        this.isDone = isDone;
        this.created = created;
        this.dueTo = dueTo;
        this.owner = owner;
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

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
