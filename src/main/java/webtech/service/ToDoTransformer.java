package webtech.service;

import org.springframework.stereotype.Service;
import webtech.persistence.ToDoEntity;
import webtech.web.api.ToDo;

@Service
public class ToDoTransformer {
    public ToDo transformEntity(ToDoEntity toDoEntity){
        return new ToDo(
                toDoEntity.getId(),
                toDoEntity.getTask(),
                toDoEntity.isDone(),
                toDoEntity.getCreated(),
                toDoEntity.getDueTo(),
                toDoEntity.getOwner()
        );
    }
}
