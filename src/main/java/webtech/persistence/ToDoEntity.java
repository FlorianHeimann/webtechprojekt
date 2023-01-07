package webtech.persistence;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "todos")
public class ToDoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "task", nullable = false)
    private String task;

    @Column(name = "isDone", nullable = false)
    private boolean isDone;

    @Column(name = "created", nullable = false)
    private LocalDate created;

    @Column(name = "dueTo")
    private LocalDate dueTo;

    @Column(name = "owner")
    private String owner;

    public ToDoEntity(String task, boolean isDone, LocalDate created, LocalDate dueTo, String owner) {
        this.task = task;
        this.isDone = isDone;
        this.created = created;
        this.dueTo = dueTo;
        this.owner = owner;
    }

    protected ToDoEntity(){}

    public long getId() {
        return id;
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
